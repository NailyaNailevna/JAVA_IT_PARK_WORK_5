package ru.itpark.milkyKitchen.security.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;



/**
 * Created by nailya.shakirova on 28.06.2018.
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    private PasswordEncoder passwordEncoder() {
        return new MessageDigestPasswordEncoder();

    }

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(HttpMethod.GET, "/receipts")
                .permitAll()
            .antMatchers(HttpMethod.POST, "/reseipts")
                .permitAll()
            .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("login")
                .defaultSuccessUrl("/")
                .permitAll();
        http.csrf().disable();
    }

    @Autowired
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

}
