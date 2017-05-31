package by.masalsky.onlineshop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/users/*").permitAll()
                .antMatchers("/logout").authenticated()
                .antMatchers("/").hasAnyRole("ADMINISTRATOR", "CLIENT")
                .antMatchers("/categories/*").hasRole("ADMINISTRATOR")
                .antMatchers("/categories/**").hasRole("ADMINISTRATOR")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .usernameParameter("login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

}
