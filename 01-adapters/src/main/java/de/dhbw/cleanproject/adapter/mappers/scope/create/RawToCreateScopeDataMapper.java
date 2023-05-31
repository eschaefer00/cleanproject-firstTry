package de.dhbw.cleanproject.adapter.mappers.scope.create;

import de.dhbw.cleanproject.application.scope.data.CreateScopeData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class RawToCreateScopeDataMapper implements Function<RawCreateScopeData, CreateScopeData> {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    @Override
    public CreateScopeData apply(final RawCreateScopeData data){return map(data);}

    private CreateScopeData map(final RawCreateScopeData data){
        CreateScopeData.CreateScopeDataBuilder builder = CreateScopeData.builder();

        builder.startDate(LocalDate.parse(data.getStartDate(), formatter));
        builder.endDate(LocalDate.parse(data.getEndDate(), formatter));

        if (data.getUserId() != null){
            builder.userId(UUID.fromString(data.getUserId()));
        }

        builder.title(data.getTitle()).todoAmount(data.getTodoAmount());
        return builder.build();
    }



}
