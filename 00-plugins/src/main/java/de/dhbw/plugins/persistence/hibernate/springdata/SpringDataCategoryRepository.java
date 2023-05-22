package de.dhbw.plugins.persistence.hibernate.springdata;

import de.dhbw.cleanproject.domain.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;
import java.util.List;

public interface SpringDataCategoryRepository extends JpaRepository<Category, UUID> {

    @Query("SELECT c.id FROM Category c WHERE c.id = ?1 and c.userId = ?2")
    List<UUID> selectAllByIds(UUID id, UUID userId);

}
