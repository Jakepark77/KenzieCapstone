package com.kenzie.appserver.service;

import com.kenzie.appserver.repositories.UserRepository;
import com.kenzie.appserver.repositories.model.UserRecord;
import com.kenzie.appserver.service.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User addNewUser(User user) {
        UserRecord userRecord = new UserRecord();
        userRecord.setUserId(user.getUserId());
        userRecord.setUserName(user.getUserName());
        userRepository.save(userRecord);
        return user;
    }
    public User findUserById(String userId) {
        User userFromRepository = userRepository
                .findById(userId)
                .map(user -> new User(user.getUserId(),
                        user.getUserId()))
                .orElse(null);
        return userFromRepository;
    }
}