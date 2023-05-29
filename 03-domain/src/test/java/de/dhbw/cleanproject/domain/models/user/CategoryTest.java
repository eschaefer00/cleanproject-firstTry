package de.dhbw.cleanproject.domain.models.user;
import de.dhbw.cleanproject.domain.models.Category;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryTest {

    @Test
    public void testCategoryBuilder() {
        // Arrange
        String title = "Category Title";
        String description = "Category Description";
        UUID userId = UUID.randomUUID();

        // Act
        Category category = Category.CategoryBuilder.create(title, description, userId);

        // Assert
        assertEquals(title, category.getTitle());
        assertEquals(description, category.getDescription());
        assertEquals(userId, category.getUserId());
    }
}
