package by.masalsky.onlineshop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PersistenceConfiguration.class})
@ComponentScan("by.masalsky.onlineshop.services")
public class ServiceConfiguration {
}
