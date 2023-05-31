package de.dhbw.plugins.rest.user;

import de.dhbw.cleanproject.adapter.mappers.user.create.RawToCreateUserDataMapper;
import de.dhbw.cleanproject.adapter.mappers.user.update.RawToUpdateUserDataMapper;
import de.dhbw.cleanproject.application.user.UserApplication;
import de.dhbw.cleanproject.domain.models.User;
import de.dhbw.plugins.rest.model.user.mapper.UserToPreviewModelMapper;
import de.dhbw.plugins.rest.user.data.UpdateUserData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/user/{userId}")
@RequiredArgsConstructor
public class UserController {

    private final UserApplication userApplication;
    private final UserToPreviewModelMapper userToPreviewModelMapper;
    private final RawToCreateUserDataMapper rawToCreateUserDataMapper;
    private final RawToUpdateUserDataMapper rawToUpdateUserDataMapper;

    @PatchMapping
    public ResponseEntity<User> update(@PathVariable("userId") UUID userId, @Valid @RequestBody UpdateUserData data) {
        if (!userApplication.existsById(userId)) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        Optional<User> optionalUser = userApplication.findUserById(userId);
        if (optionalUser.isEmpty()) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        optionalUser = userApplication.update(optionalUser.get(), rawToUpdateUserDataMapper.apply(data));
        return optionalUser.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable("userId") UUID userId) {
        if (!userApplication.delete(userId)) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}

