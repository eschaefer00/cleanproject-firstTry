package de.dhbw.cleanproject.adapter.mappers.user.create;

import de.dhbw.cleanproject.application.user.data.CreateUserData;
import de.dhbw.cleanproject.valueobject.email.Email;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class RawToCreateUserDataMapper implements Function<RawCreateUserData, CreateUserData> {

    @Override
    public CreateUserData apply(final RawCreateUserData data) {
        return map(data);
    }

    private CreateUserData map(final RawCreateUserData data) {
        Email email = new Email(data.getEmail());

        return CreateUserData.builder().name(data.getName()).email(email).build();
    }
}
