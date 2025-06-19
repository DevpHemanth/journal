package com.hemanth.journalApp.controller;

import com.hemanth.journalApp.entity.JournalEntry;
import com.hemanth.journalApp.entity.User;
import com.hemanth.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControllerV2 {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<?> findAllUsers(){

        List<User> users = userService.getAllUsers();

        if(users != null)
            return new ResponseEntity<>(users, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable long id){

        User userById = userService.getUserById(id);

        if(userById != null)
            return new ResponseEntity<>(userById, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping
    public ResponseEntity<?> createNewUser(@RequestBody User user){

       User userCreated = userService.addUser(user);

        if(userCreated != null)
            return new ResponseEntity<>(userCreated, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<User> removeUser(@PathVariable long id){

        return userService.removeUserById(id) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/{userName}")
    public ResponseEntity<User> updateUser(@PathVariable String userName,@RequestBody User user) {

        User userInDb = userService.findUserByName(userName);

        if(userInDb != null){
            userInDb.setUserName(user.getUserName());
            userInDb.setUserPassword(user.getUserPassword());
        }
        userService.addUser(userInDb);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
