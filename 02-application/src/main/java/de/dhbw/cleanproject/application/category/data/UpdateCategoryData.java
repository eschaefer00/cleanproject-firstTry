package de.dhbw.cleanproject.application.category.data;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class UpdateCategoryData {
    private final UUID id;
    private final String title;
    private final String description;
    private final UUID userId;
}
