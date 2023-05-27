package de.dhbw.cleanproject.application.scope.data;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class UpdateScopeData {
    private final String title;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int todoAmount;

}
