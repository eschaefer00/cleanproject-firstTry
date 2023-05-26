package de.dhbw.cleanproject.domain.models;


import de.dhbw.cleanproject.valueobject.email.Email;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Setter(AccessLevel.PACKAGE)
    @Id
    @Column(name = "id")
    private UUID id;

    @Embedded
    @Column(name = "email", nullable = false)
    private Email email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name="points")
    private int points;

    @Column(name = "date_registered")
    private LocalDate dateRegistered;


    public static class UserBuilder {
        public static User create(Email email, String password, String name, int points, LocalDate timeRegistered) {
            //todo validierung
            return User.builder()
                    .id(UUID.randomUUID())
                    .email(email)
                    .password(password)
                    .name(name)
                    .points(points)
                    .dateRegistered(timeRegistered)
                    .build();
        }
    }

}
