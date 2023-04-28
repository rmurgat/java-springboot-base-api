package com.hanygen.springboot.api.controllers;

import com.hanygen.springboot.api.models.UserModel;
import com.hanygen.springboot.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }

    @GetMapping(path="/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id) {
        return this.userService.getById(id);
    }

    @GetMapping(path="/query")
    public ArrayList<UserModel> getUsersByPriority(@RequestParam("priority") Integer priority) {
        return this.userService.getByPriority(priority);
    }

    @DeleteMapping(path="/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        if( this.userService.deleteUser(id) ) {
            return "the user was deleted by id " + id;
        } else {
            return "could not delete user by id " + id;
        }
    }
}
