package de.dhbw.cleanproject.application.category;

import de.dhbw.cleanproject.domain.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryApplicationService implements CategoryApplication {

   private final CategoryRepository categoryRepository;

   @Override
   public Boolean existsByIds(UUID id, UUID userId) {
      return categoryRepository.existsByIds(id, userId);
   }

}
