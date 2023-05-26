package de.dhbw.cleanproject.adapter.mappers.category.update;

import de.dhbw.cleanproject.application.category.data.UpdateCategoryData;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class RawToUpdateCategoryDataMapper implements Function<RawUpdateCategoryData, UpdateCategoryData> {
    @Override
    public UpdateCategoryData apply(RawUpdateCategoryData data) { return map(data); }

    private UpdateCategoryData map(final RawUpdateCategoryData data){

        UpdateCategoryData.UpdateCategoryDataBuilder builder = UpdateCategoryData.builder();

        if(data.getId() != null){
            builder.id(UUID.fromString(data.getId()));
        }

        if (data.getUserId() != null){
            builder.userId(UUID.fromString(data.getUserId()));
        }

        builder.title(data.getTitle()).description(data.getDescription());
        return builder.build();
    }
}
