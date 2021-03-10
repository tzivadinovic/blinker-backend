package rs.prod.blinker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class BlinkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlinkerApplication.class, args);
    }

}
