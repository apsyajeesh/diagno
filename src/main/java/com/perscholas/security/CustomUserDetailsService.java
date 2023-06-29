package com.perscholas.security;

import com.perscholas.persistence.repo.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        com.perscholas.persistence.model.User user = userRepository.findByEmail(usernameOrEmail).get();
        return new User(user.getEmail(),
                user.getPassword(),
                user.getRoles().stream()
                        .map((role) -> new SimpleGrantedAuthority(role.getName()))
                        .collect(Collectors.toList()));
    }
}
