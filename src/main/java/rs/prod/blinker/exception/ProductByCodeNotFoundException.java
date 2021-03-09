package rs.prod.blinker.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The product does not exist")
public class ProductByCodeNotFoundException extends RuntimeException{
}
