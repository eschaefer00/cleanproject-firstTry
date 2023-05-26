package de.dhbw.plugins.rest.category.data;

import de.dhbw.cleanproject.adapter.mappers.category.update.RawUpdateCategoryData;
import de.dhbw.plugins.rest.customvalidatior.ValueOfUUID;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Builder
@Data
public class UpdateCategoryData implements RawUpdateCategoryData {
    @NotEmpty(message = "The title is required.")
    @ValueOfUUID(message = "The ID must be a UUID.")
    private final String id;
    @NotEmpty(message = "The title is required.")
    @Size(min = 2, max = 100, message = "The length of full title must be between 2 and 100 characters.")
    private final String title;
    @Size(min = 2, max = 500, message = "The length of description title must be between 2 and 500 characters.")
    private final String description;
    @NotEmpty(message = "The userID is required.")
    @ValueOfUUID(message = "The userID must be a UUID.")
    private final String userId;
}
