package rs.prod.blinker.service.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.prod.blinker.entity.Employee;
import rs.prod.blinker.entity.User;
import rs.prod.blinker.repository.EmployeeRepository;
import rs.prod.blinker.repository.UserRepository;
import rs.prod.blinker.service.EmployeeService;

import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

import static rs.prod.blinker.util.StringUtils.normalize;
import static rs.prod.blinker.util.StringUtils.throwIfEmpty;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NoSuchElementException("EmployeeService.notFound"));
    }

    @Override
    public Employee save(Employee employee) {
        User user = new User();
        String firstName = throwIfEmpty(employee.getFirstName());
        String lastName = throwIfEmpty(employee.getLastName());
        String username = normalize(String.format("%s.%s", firstName.toLowerCase(), lastName.toLowerCase()));
        user.setUsername(username);
        userRepository.save(user);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }


}