package de.dhbw.plugins.rest.users;

import de.dhbw.cleanproject.adapter.mappers.user.UserToUserResourceMapper;
import de.dhbw.cleanproject.adapter.mappers.user.create.RawToCreateUserDataMapper;
import de.dhbw.cleanproject.application.user.UserApplication;
import de.dhbw.cleanproject.application.user.UserApplicationService;
import de.dhbw.cleanproject.domain.models.User;
import de.dhbw.plugins.rest.model.user.UserPreviewModel;
import de.dhbw.plugins.rest.model.user.mapper.UserToPreviewModelMapper;
import de.dhbw.plugins.rest.users.data.CreateUserData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UsersController {

    private final UserApplicationService userApplicationService;
    private final UserToUserResourceMapper userToUserResourceMapper;
    private final UserApplication userApplication;
    private final UserToPreviewModelMapper userToPreviewModelMapper;
    private final RawToCreateUserDataMapper rawToCreateUserDataMapper;
    @GetMapping
    public ResponseEntity<List<UserPreviewModel>> listAll() {
        List<UserPreviewModel> result = userApplication.findAllUsers().stream().map(userToPreviewModelMapper::apply).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<UserPreviewModel> create(@Valid @RequestBody CreateUserData data) {

        Optional<User> optionalUser = userApplication.create(rawToCreateUserDataMapper.apply(data));
        if (!optionalUser.isPresent()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(userToPreviewModelMapper.apply(optionalUser.get()));
    }
}