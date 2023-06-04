package com.kenzie.appserver.service.model;

import static java.util.UUID.randomUUID;

public class User {
    private final String userName;
    private final String userId;


    public User(String userName) {
        this.userName = userName;
        this.userId = randomUUID().toString();

    }

    public User(String userName, String userId) {
        this.userName = userName;
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }
}
