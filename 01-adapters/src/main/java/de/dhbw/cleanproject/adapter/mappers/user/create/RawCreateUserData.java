package de.dhbw.cleanproject.adapter.mappers.user.create;

public interface RawCreateUserData {
    String getId();
    String getEmail();
    String getName();
    String getPassword();
    int getPoints();
    String getDateRegistered();
}
