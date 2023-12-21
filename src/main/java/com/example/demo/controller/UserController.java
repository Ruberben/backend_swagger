package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@Api(value = "User Management System", description = "Operations pertaining to user in User Management System")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @ApiOperation(value = "Create a new user")
    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @ApiOperation(value = "View a list of all users")
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @ApiOperation(value = "Update user")
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user){
        User existingUser = userService.getUserById(id).orElse(null);

        if(existingUser== null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        user.setId(id);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }
}
