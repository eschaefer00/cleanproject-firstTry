package de.dhbw.plugins.rest.categories.data;

import de.dhbw.cleanproject.adapter.mappers.category.create.RawCreateCategoryData;
import de.dhbw.plugins.rest.customvalidatior.ValueOfUUID;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Builder
@Data
public class CreateCategoryData implements RawCreateCategoryData {
    @NotEmpty(message = "The title is required.")
    @ValueOfUUID(message = "The ID must be a UUID.")
    private final String id;
    @NotEmpty(message = "The title is required.")
    @Size(min = 2, max = 100, message = "The length of full title must be between 2 and 100 characters.")
    private final String title;
    @Size(min = 2, max = 500, message = "The length of the description must be between 2 and 500 characters.")
    private final String description;
    @NotEmpty(message = "The title is required.")
    @ValueOfUUID(message = "The userId must be a UUID.")
    private final String userId;
}