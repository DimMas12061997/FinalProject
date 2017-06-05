package by.masalsky.onlineshop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final AuthenticationEntryPoint authenticationEntryPoint;
    private final LogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    public SecurityConfig(CustomUserDetailsService userDetailsService,
                             AuthenticationEntryPoint authenticationEntryPoint,
                             LogoutSuccessHandler logoutSuccessHandler) {
        this.userDetailsService = userDetailsService;
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.logoutSuccessHandler = logoutSuccessHandler;
    }

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/users/login").permitAll()
                .antMatchers("/users/signUp").permitAll()
                .antMatchers(HttpMethod.GET,"/goods/**").permitAll()
                .antMatchers(HttpMethod.GET,"/categories/**").permitAll()
                .antMatchers("/logout").authenticated()
                .antMatchers("/categories/**").hasRole("ADMINISTRATOR")
                .antMatchers("/goods/**").hasRole("ADMINISTRATOR")
                .antMatchers("/shop/**").hasRole("ADMINISTRATOR")
                .antMatchers("/blackList/**").hasRole("ADMINISTRATOR")
                .antMatchers(HttpMethod.GET,"/order").hasRole("ADMINISTRATOR")
                .antMatchers(HttpMethod.GET,"/userProfile").hasRole("ADMINISTRATOR")
                .antMatchers("/order/**").hasAnyRole("ADMINISTRATOR", "CLIENT")
                .antMatchers("/userProfile/**").hasAnyRole("ADMINISTRATOR", "CLIENT")
                .antMatchers("/users/**").hasAnyRole("ADMINISTRATOR", "CLIENT")
                .anyRequest().authenticated()

                .and()
                .logout()
                .logoutSuccessHandler(logoutSuccessHandler)

                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)

                .and()
                .csrf()
                .disable();
    }

}
