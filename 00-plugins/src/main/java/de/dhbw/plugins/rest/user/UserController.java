package de.dhbw.plugins.rest.user;

import de.dhbw.cleanproject.adapter.mappers.user.create.RawToCreateUserDataMapper;
import de.dhbw.cleanproject.application.user.UserApplication;
import de.dhbw.plugins.rest.model.todo.TodoPreviewModel;
import de.dhbw.plugins.rest.model.user.mapper.UserToPreviewModelMapper;
import de.dhbw.plugins.rest.user.data.CreateUserData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user/")
@RequiredArgsConstructor
public class UserController {

    private final UserApplication userApplication;
    private final UserToPreviewModelMapper userToPreviewModelMapper;
    private final RawToCreateUserDataMapper rawToCreateUserDataMapper;


    @PostMapping
    public ResponseEntity<TodoPreviewModel> create(CreateUserData data) {
//        User user;
//        if (!user.existsById(userId)) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        Optional<User> optionalUser = userApplication.create(rawToCreateUserDataMapper.apply(data));
//        if (!optionalUser.isPresent()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        return ResponseEntity.ok(userToPreviewModelMapper.apply(optionalUser.get()));
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}

