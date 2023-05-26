package de.dhbw.cleanproject.adapter.mappers.category.create;

import de.dhbw.cleanproject.application.category.data.CreateCategoryData;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class RawToCreateCategoryDataMapper implements Function<RawCreateCategoryData, CreateCategoryData>{
    @Override
    public CreateCategoryData apply(RawCreateCategoryData data) { return map(data); }

    private CreateCategoryData map(RawCreateCategoryData data) {
        CreateCategoryData.CreateCategoryDataBuilder builder = CreateCategoryData.builder();
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