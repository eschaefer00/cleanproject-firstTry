package de.dhbw.plugins.persistence.hibernate.bridges;

import de.dhbw.cleanproject.domain.models.Category;
import de.dhbw.cleanproject.domain.repositories.CategoryRepository;
import de.dhbw.plugins.persistence.hibernate.springdata.SpringDataCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryBridge implements CategoryRepository {

    private final SpringDataCategoryRepository springDataCategoryRepository;

    @Override
    public List<Category> findAllCategories(){return this.springDataCategoryRepository.findAll();}

    @Override
    public Optional<Category> findCategoryById(final UUID id){
        return this.springDataCategoryRepository.findById(id);
    }

    @Override
    public Category save(final Category category){return this.springDataCategoryRepository.save(category);}

    @Override
    public boolean existsByIds(UUID id, UUID userId) {
        return springDataCategoryRepository.selectAllByIds(id, userId).contains(id);
    }

    @Override
    public List<Category> findByUserId(UUID userId) {
        return springDataCategoryRepository.findByUserId(userId);
    }

    @Override
    public boolean existsById(UUID userId) {
        return springDataCategoryRepository.selectAllById(userId);
    }

    @Override
    public void deleteById(UUID categoryAggregateId) {
        springDataCategoryRepository.deleteById(categoryAggregateId);

    }

}
