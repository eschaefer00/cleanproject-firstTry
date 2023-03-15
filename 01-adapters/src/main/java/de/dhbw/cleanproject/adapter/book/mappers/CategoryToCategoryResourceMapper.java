package de.dhbw.cleanproject.adapter.book.mappers;

import de.dhbw.cleanproject.adapter.book.resources.CategoryResource;
import de.dhbw.cleanproject.domain.book.models.Category;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CategoryToCategoryResourceMapper implements Function<Category, CategoryResource> {
    @Override
    public CategoryResource apply(final Category category){return map(category);}

    private CategoryResource map(final Category category){
        return new CategoryResource(category.getName(), category.getDescription());
    }
}
