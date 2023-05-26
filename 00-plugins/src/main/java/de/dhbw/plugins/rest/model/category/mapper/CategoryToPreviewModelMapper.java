package de.dhbw.plugins.rest.model.category.mapper;

import de.dhbw.cleanproject.domain.models.Category;
import de.dhbw.plugins.rest.model.category.CategoryPreviewModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class CategoryToPreviewModelMapper implements Function<Category, CategoryPreviewModel> {

        @Override
        public CategoryPreviewModel apply(final Category resource) {
            return map(resource);
        }

        private CategoryPreviewModel map(final Category resource) {
            return CategoryPreviewModel.builder().id(resource.getId()).title(resource.getTitle()).description(resource.getDescription()).userId(resource.getUserId()).build();
        }
}
