package de.dhbw.cleanproject.domain.models.user;


import de.dhbw.cleanproject.domain.models.Scope;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.testng.AssertJUnit.assertEquals;

public class ScopeTest {

    @Test
    public void testScopeBuilder() {
        // Arrange
        String title = "Scope Title";
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        int todoAmount = 5;
        UUID userId = UUID.randomUUID();

        // Act
        Scope scope = Scope.ScopeBuilder.create(title, startDate, endDate, todoAmount, userId);

        // Assert
        assertEquals(title, scope.getTitle());
        assertEquals(startDate, scope.getStartDate());
        assertEquals(endDate, scope.getEndDate());
        assertEquals(todoAmount, scope.getTodoAmount());
        assertEquals(userId, scope.getUserId());
    }
}


