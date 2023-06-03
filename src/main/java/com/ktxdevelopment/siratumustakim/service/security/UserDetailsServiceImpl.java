package com.ktxdevelopment.siratumustakim.service.security;

import com.ktxdevelopment.siratumustakim.model.user.User;
import com.ktxdevelopment.siratumustakim.service.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
        if (user == null) throw new UsernameNotFoundException("User cannot be found in database");

        return new UserSecuredDetails(user);
    }
}
