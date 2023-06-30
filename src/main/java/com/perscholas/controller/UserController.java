package com.perscholas.controller;

import com.perscholas.dto.UserDto;
import com.perscholas.persistence.model.User;
import com.perscholas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping
    public Iterable<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable Long id) {
        return userService.findUser(id);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);

    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id) {
        return userService.updateUser(user, id);
    }
}
