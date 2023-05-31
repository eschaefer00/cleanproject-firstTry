package de.dhbw.cleanproject.adapter.mappers.scope.update;

import de.dhbw.cleanproject.application.scope.data.UpdateScopeData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class RawToUpdateScopeDataMapper implements Function<RawUpdateScopeData, UpdateScopeData> {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    @Override
    public UpdateScopeData apply(final RawUpdateScopeData data){return map(data);}

    private UpdateScopeData map(final RawUpdateScopeData data){
        UpdateScopeData.UpdateScopeDataBuilder builder = UpdateScopeData.builder();

        builder.startDate(LocalDate.parse(data.getStartDate(), formatter));
        builder.endDate(LocalDate.parse(data.getEndDate(), formatter));

        if (data.getUserId() != null){
            builder.userId(UUID.fromString(data.getUserId()));
        }

        builder.title(data.getTitle()).todoAmount(data.getTodoAmount());
        return builder.build();
    }
}
