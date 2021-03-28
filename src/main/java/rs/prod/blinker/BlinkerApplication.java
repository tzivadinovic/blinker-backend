package rs.prod.blinker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BlinkerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BlinkerApplication.class, args);
    }

}
