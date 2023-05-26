package de.dhbw.cleanproject.adapter.mappers.user.update;

import de.dhbw.cleanproject.application.user.data.UpdateUserData;
import de.dhbw.cleanproject.valueobject.email.Email;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

public class RawToUpdateUserDataMapper implements Function<RawUpdateUserData, UpdateUserData> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public UpdateUserData apply(RawUpdateUserData data) {
        return map(data);
    }

    private UpdateUserData map(final RawUpdateUserData data) {

        UpdateUserData.UpdateUserDataBuilder builder = UpdateUserData.builder();

        Email email = new Email(data.getEmail());

        builder.dateRegistered(LocalDate.parse(data.getDateRegistered(), formatter));

        builder.name(data.getName()).email(email).password(data.getPassword()).points(data.getPoints());

        return builder.build();
    }
}
