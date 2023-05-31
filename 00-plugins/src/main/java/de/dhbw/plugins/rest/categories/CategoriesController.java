package de.dhbw.plugins.rest.categories;

import de.dhbw.cleanproject.adapter.mappers.category.create.RawToCreateCategoryDataMapper;
import de.dhbw.cleanproject.application.category.CategoryApplication;
import de.dhbw.cleanproject.domain.models.Category;
import de.dhbw.plugins.rest.categories.data.CreateCategoryData;
import de.dhbw.plugins.rest.model.category.CategoryPreviewModel;
import de.dhbw.plugins.rest.model.category.mapper.CategoryToPreviewModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/user/{userId}/categories")
@RequiredArgsConstructor
public class CategoriesController {
    private final CategoryApplication categoryApplication;
    private final CategoryToPreviewModelMapper categoryToPreviewModelMapper;
    private final RawToCreateCategoryDataMapper rawToCreateCategoryDataMapper;

        @GetMapping
        public ResponseEntity<List<CategoryPreviewModel>> listAll(@PathVariable("userId") UUID userId) {
            if (!categoryApplication.existsById(userId)) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            List<CategoryPreviewModel> result = categoryApplication.findAllCategoriesByUserId(userId).stream().map(categoryToPreviewModelMapper::apply).collect(Collectors.toList());
            return ResponseEntity.ok(result);
        }

        @PostMapping
        public ResponseEntity<CategoryPreviewModel> create(@PathVariable("userId") UUID userId, @Valid @RequestBody CreateCategoryData data) {
            if (!categoryApplication.existsById(userId)) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            Optional<Category> optionalCategory = categoryApplication.create(userId, rawToCreateCategoryDataMapper.apply(data));
            return optionalCategory.map(category -> ResponseEntity.ok(categoryToPreviewModelMapper.apply(category))).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }

}
