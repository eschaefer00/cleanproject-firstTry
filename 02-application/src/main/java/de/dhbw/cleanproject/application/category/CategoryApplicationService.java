package de.dhbw.cleanproject.application.category;

import de.dhbw.cleanproject.domain.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CategoryApplicationService {
    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryApplicationService(final CategoryRepository categoryRepository){this.categoryRepository=categoryRepository;}
}
