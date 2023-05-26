package de.dhbw.plugins.rest.categories.data;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class CreateCategoryData {
    private final UUID id;
    private final String title;
    private final String description;
    private final UUID userId;
}
