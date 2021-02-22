package com.example.OzgurMovie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class ConfigTest extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // add our users for in memory authentication

        User.UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("user").password("123456").roles( "USER"))
                .withUser(users.username("admin").password("123456").roles( "ADMIN"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/movies/showForm*").hasAnyRole( "ADMIN","USER")
                .antMatchers("/movies/save*").hasAnyRole("ADMIN","USER")
                .antMatchers("/movies/delete").hasRole("ADMIN")
                .antMatchers("/movies/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/star/**").hasAnyRole("ADMIN","USER" )
                .antMatchers("/resources/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/loginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");

    }
}
