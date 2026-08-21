package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getalluser")
    public List<UserDto> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/getuser/{name}")
    public List<UserDto> getUser(@PathVariable String name){
        return userService.getUser(name);
    }

    @PostMapping("/saveuser")
    public UserDto saveuser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }

    @PutMapping("/updateuser")
    public UserDto updateuser(@RequestBody UserDto userDto){
        return userService.updateUser(userDto);
    }

    @DeleteMapping("/deleteuser/{id}")
    public UserDto deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }
}
