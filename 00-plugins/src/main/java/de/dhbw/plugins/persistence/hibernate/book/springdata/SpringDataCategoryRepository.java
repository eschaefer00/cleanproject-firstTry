package de.dhbw.plugins.persistence.hibernate.book.springdata;

import de.dhbw.cleanproject.domain.book.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import java.util.List;

public interface SpringDataCategoryRepository extends JpaRepository<Category, UUID> {

    List<Category> findAllCategories();

    Category findCategoryById(UUID id);


}
