package com.myapp.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
/*
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
*/
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    // for custom table column names , run the script in mysql available in scripts folder 06-setup-spring-security-demo-database-bcrypt-custom-table-names.sql
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        //define query to retrieve a user by username
        // "?" parameter value will be the user name from login form

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id , pw , active from members where user_id=?"
        );

        //define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id,role from roles where user_id=?"
        );


        return jdbcUserDetailsManager;
    }

/*

    //add support for jdbc
    // for bcrypt run the script file from folder scripts  05-setup-spring-security-demo-database-bcrypt.sql
    //plain text password run the script file from folder scripts 04-setup-spring-security-demo-database-plaintext.sql
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }
*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
                       );
                //use HTTP basic authentication configuration
        http.httpBasic(Customizer.withDefaults());

        //disable Cross site request forgery csrf
        // in general, not required for stateless Rest Api's that use POST.PUT,DELETE
        http.csrf(csrf->csrf.disable());

        return http.build();
    }



    /*

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails saurabh = User.builder()
                .username("saurabh")
                .password("{noop}test123")
                .roles("Employee")
                .build();
        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("Employee","Manager")
                .build();
        UserDetails santa = User.builder()
                .username("santa")
                .password("{noop}test123")
                .roles("Employee","Manager","Admin")
                .build();

        return new InMemoryUserDetailsManager(saurabh,mary,santa);
    }
*/

}
