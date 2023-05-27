package de.dhbw.plugins.rest.scope.data;

import de.dhbw.cleanproject.adapter.mappers.scope.update.RawUpdateScopeData;
import de.dhbw.plugins.rest.customvalidatior.ValueOfLocalDate;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
public class UpdateScopeData implements RawUpdateScopeData {
    @NotEmpty(message = "The title is required.")
    @Size(min = 2, max = 100, message = "The length of full title must be between 2 and 100 characters.")
    private final String title;

    @ValueOfLocalDate(message = "The deadline must be a LocalDate.")
    private String startDate;

    @ValueOfLocalDate(message = "The deadline must be a LocalDate.")
    private String endDate;

    @Positive(message = "The Scope needs a minimum of one todo")
    private int todoAmount;
}
