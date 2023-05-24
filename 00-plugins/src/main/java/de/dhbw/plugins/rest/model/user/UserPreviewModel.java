package de.dhbw.plugins.rest.model.user;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
@Builder
public class UserPreviewModel {
    private final UUID id;
    private final String name;
}
