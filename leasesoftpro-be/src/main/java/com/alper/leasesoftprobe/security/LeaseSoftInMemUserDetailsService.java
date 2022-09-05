package com.alper.leasesoftprobe.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@AllArgsConstructor
public class LeaseSoftInMemUserDetailsService  implements UserDetailsService {

    private List<UserDetails> userDetailsList;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return  userDetailsList.stream().filter(userDetails -> userDetails.getUsername().equals(username)).findFirst().get();
    }
}
