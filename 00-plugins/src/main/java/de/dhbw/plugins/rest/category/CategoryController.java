package de.dhbw.plugins.rest.category;

import de.dhbw.cleanproject.adapter.mappers.category.update.RawToUpdateCategoryDataMapper;
import de.dhbw.cleanproject.application.category.CategoryApplication;
import de.dhbw.cleanproject.domain.models.Category;
import de.dhbw.plugins.rest.category.data.UpdateCategoryData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/user/{userId}/category/{categoryAggregateId}")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryApplication categoryApplication;
    private final RawToUpdateCategoryDataMapper rawToUpdateCategoryDataMapper;

    @GetMapping
    public ResponseEntity<Category> findOne(@PathVariable("userId") UUID userId, @PathVariable("categoryAggregateId") UUID categoryAggregateId) {
        if (!categoryApplication.existsByIds(categoryAggregateId, userId)) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        Optional<Category> optionalCategory = categoryApplication.findCategoryById(categoryAggregateId);
        if (optionalCategory.isEmpty()) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        return ResponseEntity.ok(optionalCategory.get());
    }

    @PatchMapping
    public ResponseEntity<Category> update(@PathVariable("userId") UUID userId, @PathVariable("categoryAggregateId") UUID categoryAggregateId, @Valid @RequestBody UpdateCategoryData data) {
        if (!categoryApplication.existsByIds(userId, categoryAggregateId)) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        Optional<Category> optionalCategory = categoryApplication.findCategoryById(categoryAggregateId);
        if (optionalCategory.isEmpty()) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        optionalCategory = categoryApplication.update(optionalCategory.get(), rawToUpdateCategoryDataMapper.apply(data));
        if (optionalCategory.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(optionalCategory.get());
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable("userId") UUID userId, @PathVariable("categoryAggregateId") UUID categoryAggregateId) {
        if (!categoryApplication.delete(userId, categoryAggregateId)) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}