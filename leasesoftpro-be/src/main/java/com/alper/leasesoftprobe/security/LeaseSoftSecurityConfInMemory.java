package com.alper.leasesoftprobe.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

//@Configuration
public class LeaseSoftSecurityConfInMemory extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService(){
        LesaUser u1 = LesaUser.builder().username("alperm").password("1234").authority("read").build();
        LesaUser u2 = LesaUser.builder().username("alperm2").password("1235").authority("read").build();

        return new LeaseSoftInMemUserDetailsService(List.of(u1,u2));
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }
}
