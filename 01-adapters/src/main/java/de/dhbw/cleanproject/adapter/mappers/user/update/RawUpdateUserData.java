package de.dhbw.cleanproject.adapter.mappers.user.update;

public interface RawUpdateUserData {
    String getId();
    String getEmail();
    String getName();
    String getPassword();
    int getPoints();
    String getDateRegistered();
}
