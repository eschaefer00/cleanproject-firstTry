package de.dhbw.cleanproject.application.category;

import de.dhbw.cleanproject.application.category.data.CreateCategoryData;
import de.dhbw.cleanproject.application.category.data.UpdateCategoryData;
import de.dhbw.cleanproject.domain.models.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryApplication {

    Boolean existsByIds(UUID id, UUID userId);

    Boolean existsById(UUID userId);

    Optional<Category> findCategoryById(UUID categoryAggregateId);

    Optional<Category> update(Category category, UpdateCategoryData apply);

    List<Category> findAllCategoriesByUserId(UUID userId);

    Optional<Category> create(UUID userId, CreateCategoryData apply);

    boolean delete(UUID userId, UUID categoryAggregateId);
}
