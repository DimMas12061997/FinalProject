package by.masalsky.onlineshop;

import by.masalsky.onlineshop.config.ServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import({ServiceConfiguration.class})
//@EntityScan(basePackages = "by.masalsky.onlineshop")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
