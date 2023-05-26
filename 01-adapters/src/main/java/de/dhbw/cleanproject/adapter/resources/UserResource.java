package de.dhbw.cleanproject.adapter.resources;

import de.dhbw.cleanproject.valueobject.email.Email;

import java.time.LocalDate;
import java.util.UUID;

public class UserResource {
    private final UUID id;
    private final Email email;
    private final String password;
    private final String name;
    private final int points;
    private final LocalDate timeRegistered;

    public UserResource(final UUID id, final Email email, final String password, final String name, final int points, final LocalDate timeRegistered) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.points = points;
        this.timeRegistered = timeRegistered;
    }

    public UUID getId() {
        return id;
    }
    public Email getEmail(){ return email; }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public int getPoints() {
        return points;
    }
    public LocalDate getTimeRegistered() {
        return timeRegistered;
    }
}
