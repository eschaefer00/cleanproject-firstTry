package de.dhbw.plugins.rest.model.scope;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class ScopeModel {
    private final UUID id;
    private final String title;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int todoAmount;
}
