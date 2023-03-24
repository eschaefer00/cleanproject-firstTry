package de.dhbw.plugins.persistence.hibernate.book.springdata;

import de.dhbw.cleanproject.domain.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;
import java.util.List;

public interface SpringDataCategoryRepository extends JpaRepository<Category, UUID> {

    List<Category> findAllCategories();

    Category findCategoryById(UUID id);


}
