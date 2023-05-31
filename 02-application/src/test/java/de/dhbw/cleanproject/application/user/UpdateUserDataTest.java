package de.dhbw.cleanproject.application.user;

import de.dhbw.cleanproject.valueobject.email.Email;
import de.dhbw.cleanproject.application.user.data.UpdateUserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

public class UpdateUserDataTest {

    @Test
    public void testUpdateUserDataBuilder() {
        // Create sample data
        UUID id = UUID.randomUUID();
        Email email = new Email("test@example.com");
        String password = "password123";
        String name = "John Doe";
        int points = 100;
        LocalDate dateRegistered = LocalDate.now();

        // Use the builder to create an instance of UpdateUserData
        UpdateUserData userData = UpdateUserData.builder()
                .id(id)
                .email(email)
                .password(password)
                .name(name)
                .points(points)
                .dateRegistered(dateRegistered)
                .build();

        // Verify the values are correctly set
        Assertions.assertEquals(id, userData.getId());
        Assertions.assertEquals(email, userData.getEmail());
        Assertions.assertEquals(password, userData.getPassword());
        Assertions.assertEquals(name, userData.getName());
        Assertions.assertEquals(points, userData.getPoints());
        Assertions.assertEquals(dateRegistered, userData.getDateRegistered());
    }
}
