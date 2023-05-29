package de.dhbw.cleanproject.domain.models.user;


import de.dhbw.cleanproject.domain.models.User;
import de.dhbw.cleanproject.valueobject.email.Email;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class UserTest {

    private UUID userId;
    private Email userEmail;
    private String userPassword;
    private String userName;
    private int userPoints;
    private LocalDate userDateRegistered;

    @BeforeEach
    void setUp() {
        userId = UUID.randomUUID();
        userEmail = mock(Email.class);
        userPassword = "password";
        userName = "username";
        userPoints = 100;
        userDateRegistered = LocalDate.now();
    }

    @Test
    void createUser_ValidData_AllPropertiesSetCorrectly() {
        User user = User.UserBuilder.create(userEmail, userPassword, userName, userPoints, userDateRegistered);

        assertEquals(userEmail, user.getEmail());
        assertEquals(userPassword, user.getPassword());
        assertEquals(userName, user.getName());
        assertEquals(userPoints, user.getPoints());
        assertEquals(userDateRegistered, user.getDateRegistered());
    }

}

