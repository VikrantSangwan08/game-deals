package com.vikrant.gamedeals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vikrant.gamedeals.entity.User;
import com.vikrant.gamedeals.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    // @GetMapping("/getUser/{userId}")
    // public User getUser(@PathVariable String userId){
    //     return userService.getUser(userId);
    // }
    @GetMapping("/getUser")
    public User getUser(@RequestParam(name = "id") String userId){
        return userService.getUserById(userId);
    }
    @GetMapping("/getAllUsers")
    public List<User> getMultipleUser(@RequestParam(required = false) String name ,
                                @RequestParam(required = false) String email,
                                @RequestParam(required = false) String prefix ){
        return userService.findAllUserContaining(name, email, prefix);
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user){
        return userService.addNewUser(user);
    }
    
    @PutMapping("/updateUser" )
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user);
    }
}
