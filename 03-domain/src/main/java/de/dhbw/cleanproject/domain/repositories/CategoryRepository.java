package de.dhbw.cleanproject.domain.repositories;

import de.dhbw.cleanproject.domain.models.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository {

    List<Category> findAllCategories();

    Optional<Category> findCategoryById(UUID id);

    Category save(Category category);

    boolean existsByIds(UUID id, UUID userId);

    List<Category> findByUserId(UUID userId);

    boolean existsById(UUID userId);

    void deleteById(UUID categoryAggregateId);
}
