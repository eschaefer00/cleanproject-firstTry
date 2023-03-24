package de.dhbw.cleanproject.application.category;

import java.util.UUID;

public interface CategoryApplication {

    Boolean existsByIds(UUID id, UUID userId);

}
