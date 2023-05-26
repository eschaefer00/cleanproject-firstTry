package de.dhbw.plugins.rest.user.data;

import de.dhbw.cleanproject.adapter.mappers.user.update.RawUpdateUserData;
import de.dhbw.cleanproject.domain.models.todo.StatusTodo;
import de.dhbw.plugins.rest.customvalidatior.ValueOfEnum;
import de.dhbw.plugins.rest.customvalidatior.ValueOfUUID;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
public class UpdateUserData implements RawUpdateUserData {
    @NotEmpty(message = "The ID is required.")
    @ValueOfUUID(message = "The ID must be a UUID.")
    private String id;
    @NotEmpty(message = "The email is required.")
    @Email(message = "Must be an email.")
    private String email;
    @NotEmpty(message = "The title is required.")
    @Size(min = 3, max = 50, message = "The length of the name must be between 3 and 50 characters.")
    private String name;

    @Size(min = 7, max = 50, message = "The length of the password must be between 7 and 50 characters.")
    private String password;

    @PositiveOrZero(message = "Points cannot get below zero as you cannot spend more points than you own.")
    private int points;

    @NotEmpty(message = "Status is required.")
    @ValueOfEnum(enumClass = StatusTodo.class, message = "Invalid status type")
    private String dateRegistered;
}
