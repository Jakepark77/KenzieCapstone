package com.kenzie.appserver.controller;

import com.kenzie.appserver.controller.model.UserCreateRequest;
import com.kenzie.appserver.controller.model.UserResponse;
import com.kenzie.appserver.service.UserService;
import com.kenzie.appserver.service.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public class UserController {
    private UserService userService;

    UserController(UserService userService){this.userService = userService;}
    @PostMapping
    public ResponseEntity<UserResponse> addNewUser(@RequestBody UserCreateRequest userCreateRequest) {
        User user = new User(userCreateRequest.getUserId(), userCreateRequest.getUserName());

        UserResponse userResponse = createUserResponse(userService.addNewUser(user));

        return ResponseEntity.ok(userResponse);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> searchUserById(@PathVariable("userId") String userId){
        User user = userService.findUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        UserResponse userResponse = createUserResponse(user);
        return ResponseEntity.ok(userResponse);
    }
    private UserResponse createUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(user.getUserId());
        userResponse.setUserName(user.getUserName());
        return userResponse;
    }
}