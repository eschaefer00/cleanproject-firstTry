package de.dhbw.cleanproject.application.scope;

import de.dhbw.cleanproject.application.scope.data.CreateScopeData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

public class CreateScopeDataTest {

    @Test
    public void testCreateScopeDataBuilder() {
        // Create sample data
        String title = "Sample Scope";
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        int todoAmount = 10;
        UUID userId = UUID.randomUUID();

        // Use the builder to create an instance of CreateScopeData
        CreateScopeData scopeData = CreateScopeData.builder()
                .title(title)
                .startDate(startDate)
                .endDate(endDate)
                .todoAmount(todoAmount)
                .userId(userId)
                .build();

        // Verify the values are correctly set
        Assertions.assertEquals(title, scopeData.getTitle());
        Assertions.assertEquals(startDate, scopeData.getStartDate());
        Assertions.assertEquals(endDate, scopeData.getEndDate());
        Assertions.assertEquals(todoAmount, scopeData.getTodoAmount());
        Assertions.assertEquals(userId, scopeData.getUserId());
    }
}