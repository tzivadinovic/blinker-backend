package rs.prod.blinker.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import rs.prod.blinker.entity.User;
import rs.prod.blinker.repository.UserRepository;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Optional;
import java.util.Properties;

@Component
@RequiredArgsConstructor
@Primary
public class AuthenticationManagerImpl implements AuthenticationManager {
	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;
	private final Environment env;
	@Value("${spring.security.disabled:false}")
	private String securityDisabled;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		Optional<User> userOptional = userRepository.findByUsername(username);

		if (userOptional.isEmpty())
			throw new BadCredentialsException("auth.invalidCredentials");

		User user = userOptional.get();
		if (!user.isEnabled())
			throw new DisabledException("auth.accountDisabled");

		// dev authentication override
		if (Boolean.parseBoolean(securityDisabled) || Arrays.asList(env.getActiveProfiles()).contains("dev")) {
			return new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
		}

		if (user.getPassword() == null) {
			if (password == null || !LdapAuthentication.isLdapRegistered(username, password))
				throw new BadCredentialsException("auth.invalidCredentials");
		} else {
			if (password == null || !passwordEncoder.matches(password, user.getPassword()))
				throw new BadCredentialsException("auth.invalidCredentials");
		}

		return new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
	}
}
