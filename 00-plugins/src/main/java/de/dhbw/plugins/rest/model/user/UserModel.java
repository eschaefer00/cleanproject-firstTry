package de.dhbw.plugins.rest.model.user;

import de.dhbw.cleanproject.valueobject.email.Email;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class UserModel {
    private final UUID id;
    private final String name;
    private final Email email;
    private final String password;
    private final int points;
    private final LocalDate timeRegistered;
}
