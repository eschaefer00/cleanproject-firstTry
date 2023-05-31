package de.dhbw.cleanproject.application.scope.data;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Data
public class CreateScopeData {
    private final String title;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int todoAmount;
    private final UUID userId;
}
