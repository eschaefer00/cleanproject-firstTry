package de.dhbw.plugins.rest.users.data;

import de.dhbw.cleanproject.adapter.mappers.user.create.RawCreateUserData;
import de.dhbw.cleanproject.domain.models.todo.StatusTodo;
import de.dhbw.plugins.rest.customvalidatior.ValueOfEnum;
import de.dhbw.plugins.rest.customvalidatior.ValueOfUUID;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class CreateUserData implements RawCreateUserData {
    @NotEmpty(message = "The ID is required.")
    private UUID id;
    @NotEmpty(message = "The title is required.")
    private String email;

    @NotEmpty(message = "The title is required.")
    @Size(min = 2, max = 100, message = "The length of full title must be between 2 and 100 characters.")
    private String username;

    @Size(min = 2, max = 500, message = "The length of description title must be between 2 and 500 characters.")
    private String password;

    @NotEmpty(message = "The title is required.")
    @Size(min = 2, max = 100, message = "The length of full title must be between 2 and 100 characters.")
    private String name;

    @NotEmpty(message = "The category is required.")
    @ValueOfUUID(message = "The bookingCategoryId is invalid UUID.")
    private int points;

    @NotEmpty(message = "Status is required.")
    @ValueOfEnum(enumClass = StatusTodo.class, message = "Invalid status type")
    private LocalDate timeRegistered;

}
