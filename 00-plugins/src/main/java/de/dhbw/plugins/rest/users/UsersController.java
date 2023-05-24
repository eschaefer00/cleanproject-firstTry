package de.dhbw.plugins.rest.users;

import de.dhbw.cleanproject.adapter.mappers.user.UserToUserResourceMapper;
import de.dhbw.cleanproject.adapter.resources.UserResource;
import de.dhbw.cleanproject.application.user.UserApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UsersController {

    private final UserApplicationService userApplicationService;
    private final UserToUserResourceMapper userToUserResourceMapper;

    @RequestMapping(method = RequestMethod.GET)
    public List<UserResource> getUsers(){
        return this.userApplicationService.findAll().stream().map(userToUserResourceMapper).collect(Collectors.toList());
    }
}
