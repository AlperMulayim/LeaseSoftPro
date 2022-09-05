package com.alper.leasesoftprobe.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    public JdbcUserDetailsManager userDetailsManager;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @PostMapping
    public void addUser( @RequestBody  LesaUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDetailsManager.createUser(user);
    }
}
