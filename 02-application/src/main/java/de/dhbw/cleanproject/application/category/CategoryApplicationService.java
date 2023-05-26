package de.dhbw.cleanproject.application.category;

import de.dhbw.cleanproject.application.category.data.CreateCategoryData;
import de.dhbw.cleanproject.application.category.data.UpdateCategoryData;
import de.dhbw.cleanproject.domain.models.Category;
import de.dhbw.cleanproject.domain.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryApplicationService implements CategoryApplication {

   private final CategoryRepository categoryRepository;

   @Override
   public Boolean existsByIds(UUID id, UUID userId) {
      return categoryRepository.existsByIds(id, userId);
   }

   @Override
   public Boolean existsById(UUID userId) {
      return this.categoryRepository.existsById(userId);
   }

   @Override
   public Optional<Category> findCategoryById(UUID categoryAggregateId) {
      return this.categoryRepository.findCategoryById(categoryAggregateId);
   }

   @Override
   public Optional<Category> update(Category category, UpdateCategoryData data) {
      categoryRepository.save(category);
      return Optional.of(category);
   }

   @Override
   public List<Category> findAllCategoriesByUserId(UUID userId) {
      return categoryRepository.findByUserId(userId);
   }

   @Override
   public Optional<Category> create(UUID userId, CreateCategoryData data) {
      Category category = Category.CategoryBuilder.create(data.getTitle(), data.getDescription(), data.getUserId());
      categoryRepository.save(category);
      return Optional.of(category);
   }

   @Override
   public boolean delete(UUID userId, UUID categoryAggregateId) {
      if(existsByIds(categoryAggregateId, userId)) {
         Optional<Category> category = findCategoryById(categoryAggregateId);
         if (category.isPresent()) {
            this.categoryRepository.deleteById(categoryAggregateId);
            return true;
         }
      }
      return false;
   }

}
