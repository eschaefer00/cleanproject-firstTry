package de.dhbw.cleanproject.adapter.mappers.user.create;

import de.dhbw.cleanproject.application.user.data.CreateUserData;
import de.dhbw.cleanproject.valueobject.email.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;
@Component
@RequiredArgsConstructor
public class RawToCreateUserDataMapper implements Function<RawCreateUserData, CreateUserData> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public CreateUserData apply(final RawCreateUserData data) {
        return map(data);
    }

    private CreateUserData map(final RawCreateUserData data) {

        CreateUserData.CreateUserDataBuilder builder = CreateUserData.builder();

        Email email = new Email(data.getEmail());

        builder.dateRegistered(LocalDate.parse(data.getDateRegistered(), formatter));

        builder.name(data.getName()).email(email).password(data.getPassword()).points(data.getPoints());

        return builder.build();
    }
}