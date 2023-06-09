package de.dhbw.cleanproject.application.user.data;

import de.dhbw.cleanproject.valueobject.email.Email;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Data
public class UpdateUserData {
    private final UUID id;
    private final Email email;
    private final String password;
    private final String name;
    private final int points;
    private final LocalDate dateRegistered;
}
