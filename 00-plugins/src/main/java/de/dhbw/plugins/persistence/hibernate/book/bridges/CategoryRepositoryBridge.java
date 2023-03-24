package de.dhbw.plugins.persistence.hibernate.book.bridges;

import de.dhbw.cleanproject.domain.models.Category;
import de.dhbw.cleanproject.domain.repositories.CategoryRepository;
import de.dhbw.plugins.persistence.hibernate.book.springdata.SpringDataCategoryRepository;
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
    public Boolean existsByIds(UUID id, UUID userId) {
        return springDataCategoryRepository.selectAllByIds(id, userId).contains(id);
    }

}
