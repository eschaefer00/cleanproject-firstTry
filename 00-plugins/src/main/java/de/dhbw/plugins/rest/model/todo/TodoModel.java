package de.dhbw.plugins.rest.model.todo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class TodoModel {
    private final UUID id;
    private final String title;
}
