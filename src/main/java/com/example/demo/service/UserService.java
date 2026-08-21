package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.UserModel;
import com.example.demo.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    public List<UserDto> getAllUser(){
        List<UserModel> userModelList = userRepo.findAll();
        return modelMapper.map(userModelList, new TypeToken<List<UserDto>>(){}.getType());
}


    public List<UserDto> getUser(String name){
        List<UserModel> userModelList = userRepo.findByName(name);
        return modelMapper.map(userModelList, new TypeToken<List<UserDto>>(){}.getType());
    }

    public UserDto saveUser(UserDto userDto){
        userRepo.save(modelMapper.map(userDto, UserModel.class));
        return userDto;
    }

    public UserDto updateUser(UserDto userDto){
        userRepo.save(modelMapper.map(userDto, UserModel.class));
        return userDto;
    }

    public UserDto deleteUser(int id){
        UserModel userModel = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        userRepo.delete(userModel);
        return modelMapper.map(userModel, UserDto.class);
    }
}
