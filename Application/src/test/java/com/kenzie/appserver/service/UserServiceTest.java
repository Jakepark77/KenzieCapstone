package com.kenzie.appserver.service;

import com.kenzie.appserver.repositories.UserRepository;
import com.kenzie.appserver.repositories.model.UserRecord;
import com.kenzie.appserver.service.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Optional;

import static java.util.UUID.randomUUID;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setup() {
        userRepository = mock(UserRepository.class);
        userService = new UserService(userService);
    }

    @Test
    void findUserById() {
        // GIVEN
        String id = randomUUID().toString();

        UserRecord record = new UserRecord();
        record.setUserId(id);
        record.setUserName("BuyerName");

        // WHEN
        when(userRepository.findById(id)).thenReturn(Optional.of(record));
        User user = userService.findUserById(id);

        // THEN
        Assertions.assertNotNull(user, "The object is returned");
        Assertions.assertEquals(record.getUserId(), user.getUserId(), "The userId matches");
        Assertions.assertEquals(record.getUserName(), user.getUserName(), "The userName matches");
    }


    @Test
    void addNewUser() {
        // GIVEN
        String userId = randomUUID().toString();

        User user = new User(userId, "BuyerName");

        ArgumentCaptor<UserRecord> userRecordCaptor = ArgumentCaptor.forClass(UserRecord.class);

        // WHEN
        User returnedUser = userService.addNewUser(user);

        // THEN
        Assertions.assertNotNull(returnedUser);

        verify(userRepository).save(userRecordCaptor.capture());

        UserRecord record = userRecordCaptor.getValue();

        Assertions.assertNotNull(record, "The User Record is returned");
        Assertions.assertEquals(record.getUserId(), user.getUserId(), "The userId matches");
        Assertions.assertEquals(record.getUserName(), user.getUserName(), "The userName matches");
    }

}