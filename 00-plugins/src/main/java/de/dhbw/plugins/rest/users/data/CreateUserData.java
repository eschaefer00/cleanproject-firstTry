package de.dhbw.plugins.rest.users.data;

import de.dhbw.cleanproject.adapter.mappers.user.create.RawCreateUserData;
import de.dhbw.plugins.rest.customvalidatior.ValueOfLocalDate;
import de.dhbw.plugins.rest.customvalidatior.ValueOfUUID;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
public class CreateUserData implements RawCreateUserData {
    @NotEmpty(message = "The ID is required.")
    @ValueOfUUID(message = "The ID must be a UUID.")
    private String id;
    @NotEmpty(message = "The email is required.")
    @Email(message = "Must be an Email")
    private String email;
    @NotEmpty(message = "The username is required.")
    @Size(min = 3, max = 50, message = "The length of the name must be between 3 and 50 characters.")
    private String name;
    @NotEmpty(message = "The password is required.")
    @Size(min = 7, max = 50, message = "The length of the password must be between 7 and 50 characters.")
    private String password;
    @PositiveOrZero(message = "Points cannot get below zero as you cannot spend more points than you own.")
    private int points;
    @NotEmpty(message = "Status is required.")
    @ValueOfLocalDate(message = "The time registered must be a LocalDate")
    private String dateRegistered;
}
