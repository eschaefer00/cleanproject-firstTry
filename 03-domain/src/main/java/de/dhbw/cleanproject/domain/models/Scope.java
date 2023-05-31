package de.dhbw.cleanproject.domain.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
@Table(name="scope")
@AllArgsConstructor
@NoArgsConstructor
public class Scope {
    @Setter(AccessLevel.PACKAGE)
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "todo_amount", nullable = false)
    private int todoAmount;

    @Column(name="user_id", nullable = false)
    private UUID userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true, updatable = false, insertable = false)
    private User user;


    public static class ScopeBuilder {
        public static Scope create(String title, LocalDate startDate, LocalDate endDate, int todoAmount, UUID userId) {
            return Scope.builder()
                    .id(UUID.randomUUID())
                    .title(title)
                    .startDate(startDate)
                    .endDate(endDate)
                    .todoAmount(todoAmount)
                    .userId(userId)
                    .build();
        }
    }

}
