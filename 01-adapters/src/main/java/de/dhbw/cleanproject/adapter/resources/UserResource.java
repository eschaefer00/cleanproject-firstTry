package de.dhbw.cleanproject.adapter.resources;

import java.time.LocalDate;
import java.util.UUID;

public class UserResource {
    private final String username;
    private final String password;
    private final String name;
    private final int points;
    private final LocalDate timeRegistered;

    public UserResource(final String username, final String password, final String name, final int points, final LocalDate timeRegistered) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.points = points;
        this.timeRegistered = timeRegistered;
    }

    public String getUsername() {
        return username;
    }

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
