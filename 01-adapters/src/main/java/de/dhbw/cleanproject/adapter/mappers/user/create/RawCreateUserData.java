package de.dhbw.cleanproject.adapter.mappers.user.create;

import java.time.LocalDate;

public interface RawCreateUserData {
    String getEmail();
    String getUsername();
    String getPassword();
    String getName();
    int getPoints();
    LocalDate getTimeRegistered();
}
