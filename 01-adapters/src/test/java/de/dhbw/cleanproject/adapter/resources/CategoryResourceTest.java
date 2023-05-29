package de.dhbw.cleanproject.adapter.resources;


import org.testng.annotations.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryResourceTest {

    @Test
    public void testCategoryResource() {
        // Arrange
        String name = "Category Name";
        String description = "Category Description";
        UUID userId = UUID.randomUUID();

        // Act
        CategoryResource categoryResource = new CategoryResource(name, description, userId);

        // Assert
        assertEquals(name, categoryResource.getName());
        assertEquals(description, categoryResource.getDescription());
        assertEquals(userId, categoryResource.getUserId());
    }
}

