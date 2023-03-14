package de.dhbw.cleanproject.application.category;

import de.dhbw.cleanproject.domain.book.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryApplicationService {
    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryApplicationService(final CategoryRepository categoryRepository){this.categoryRepository=categoryRepository;}
}
