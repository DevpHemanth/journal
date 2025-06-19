package com.hemanth.journalApp.repository;

import com.hemanth.journalApp.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User,Long> {

    User findUserByUserName(String userName);
}
