package de.dhbw.cleanproject.domain.models;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;


@Builder
@Getter
@Setter
@Entity
@Table(name="category")
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Setter(AccessLevel.PACKAGE)
    @Id
    @Column(name = "id", nullable = false)
//    @Type(type="uuid-char")
    private UUID id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="user_id", nullable = false)
    private UUID userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true, updatable = false, insertable = false)
    private User user;

    public static class CategoryBuilder {
        public static Category create(String title, String description, UUID userId) {
            return Category.builder()
                    .id(UUID.randomUUID())
                    .title(title)
                    .description(description)
                    .userId(userId)
                    .build();
        }
    }
}
