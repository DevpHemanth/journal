package com.hemanth.journalApp.service;

import com.hemanth.journalApp.entity.User;
import com.hemanth.journalApp.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User addUser(User user){
        return  userRepo.save(user);
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User  getUserById(Long id){
        return userRepo.findById(id).orElse(null);
    }

    public boolean removeUserById(Long id){
        userRepo.deleteById(id);
        return true;
    }

    public User findUserByName(String userName){
        return userRepo.findUserByUserName(userName);
    }

}
