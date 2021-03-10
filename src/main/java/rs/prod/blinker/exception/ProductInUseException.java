package rs.prod.blinker.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Unable to delete! The product is in use")
public class ProductInUseException extends RuntimeException {
}
