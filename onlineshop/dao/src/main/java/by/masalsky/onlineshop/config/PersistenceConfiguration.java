package by.masalsky.onlineshop.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;


@Configuration
@ComponentScan("by.masalsky.onlineshop.dao")
@ImportResource("classpath:dao-context.xml")
@PropertySource("classpath:environment.xml")
public class PersistenceConfiguration {
    // here you can write other beans okey? It is JAVA based config


    // here you can use ENVIRONMENTS values by keys
    @Value("${db.url}")
    private String url;

    //or you can use Environment bean to get values
    @Autowired
    private Environment environment;


    // also you can get your properties inside arguments
//    @Bean
//    public DataSource dataSource(@Value("db.driver") String driver){
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName(driver);
//        dataSource.setUrl(url);
//        final String user = environment.getProperty("db.username");
//        final String password = environment.getProperty("db.pass");
//        dataSource.setUsername(user);
//        dataSource.setPassword(password);
//        return dataSource;
//    }


    // it simple bean need to activate annotation @Value
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigIn() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
