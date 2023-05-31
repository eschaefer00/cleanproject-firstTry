package de.dhbw.cleanproject.domain.models.todo;

import de.dhbw.cleanproject.domain.models.Category;
import de.dhbw.cleanproject.domain.models.Scope;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
@Table(name="todo")
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    @Setter(AccessLevel.PACKAGE)
    @Id
    @Column(name = "id", nullable = false)
//    @Type(type="uuid-char")
    private UUID id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;



    @Column(name="category_aggregate_id", nullable = false)
//    @Type(type="uuid-char")
    private UUID categoryAggregateId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_aggregate_id", nullable = true, updatable = false, insertable = false)
    private Category categoryAggregate;


    @Column(name="priority", nullable = false)
    private PriorityTodo priority;

    @Column(name="deadline")
    private LocalDate deadline;

    @Column(name="status") //backlog, dashboard/planned, done
    private StatusTodo status;

    @Column(name="points")
    private int points;

    @Column(name="scope_aggregate_id", nullable = false)
    private UUID scopeAggregateId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scope_aggregate_id", nullable = true, updatable = false, insertable = false)
    private Scope scopeAggregate;

    public static class TodoBuilder {
        public static Todo create(String title, String description, UUID categoryAggregateId, PriorityTodo priority, LocalDate deadline, StatusTodo status, int points, UUID scopeAggregateId) {
            return Todo.builder()
                    .id(UUID.randomUUID())
                    .title(title)
                    .description(description)
                    .categoryAggregateId(categoryAggregateId)
                    .categoryAggregate(null)
                    .priority(priority)
                    .deadline(deadline)
                    .status(status)
                    .points(points)
                    .scopeAggregateId(scopeAggregateId)
                    .build();
        }
    }

}
