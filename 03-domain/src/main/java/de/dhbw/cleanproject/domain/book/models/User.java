package de.dhbw.cleanproject.domain.book.models;

import org.apache.commons.lang3.Validate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;
@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name="points")
    private int points;

    @Column(name = "time_registered")
    private LocalDate timeRegistered;

    protected User() {
        //default constructor for JPA
    }

    public User(UUID id, String username, String password, String name, int points, LocalDate timeRegistered) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.points = points;
        this.timeRegistered = timeRegistered;
    }

    public UUID getId() {
        return id;
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
