package de.dhbw.plugins.rest.model.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class UserModel {
    private final UUID id;
    private final String name;
}
