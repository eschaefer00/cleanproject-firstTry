package de.dhbw.cleanproject.application.scope;

import de.dhbw.cleanproject.application.scope.data.UpdateScopeData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UpdateScopeDataTest {

    @Test
    public void testUpdateScopeDataBuilder() {
        // Create sample data
        String title = "Sample Title";
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        int todoAmount = 5;

        // Use the builder to create an instance of UpdateScopeData
        UpdateScopeData scopeData = UpdateScopeData.builder()
                .title(title)
                .startDate(startDate)
                .endDate(endDate)
                .todoAmount(todoAmount)
                .build();

        // Verify the values are correctly set
        Assertions.assertEquals(title, scopeData.getTitle());
        Assertions.assertEquals(startDate, scopeData.getStartDate());
        Assertions.assertEquals(endDate, scopeData.getEndDate());
        Assertions.assertEquals(todoAmount, scopeData.getTodoAmount());
    }
}
