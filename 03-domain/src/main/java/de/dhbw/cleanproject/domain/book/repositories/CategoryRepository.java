package de.dhbw.cleanproject.domain.book.repositories;

import de.dhbw.cleanproject.domain.book.models.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository {
    List<Category> findAllCategories();

    Category findCategoryById(UUID id);

    Category save(Category category);

}
