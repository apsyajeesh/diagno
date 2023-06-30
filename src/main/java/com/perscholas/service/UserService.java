package com.perscholas.service;


import com.perscholas.dto.UserDto;
import com.perscholas.exception.UserIdMismatchException;
import com.perscholas.exception.UserNotFoundException;
import com.perscholas.persistence.model.Role;
import com.perscholas.persistence.model.User;
import com.perscholas.persistence.repo.RoleRepository;
import com.perscholas.persistence.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public User createUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAge(userDto.getAge());
        user.setGender(userDto.getGender());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if (role == null) {
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        return userRepository.save(user);
    }
    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }


    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User findUser(Long id) throws UserNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    public User findByEmail(String email) throws UserNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
    }

    public void deleteUser(Long id) throws UserNotFoundException {
        userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        userRepository.deleteById(id);
    }
    public User updateUser(User user,Long id)throws UserIdMismatchException, UserNotFoundException {
        if (user.getId() != id) {
            throw new UserIdMismatchException();
        }
        userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        return userRepository.save(user);
    }
}