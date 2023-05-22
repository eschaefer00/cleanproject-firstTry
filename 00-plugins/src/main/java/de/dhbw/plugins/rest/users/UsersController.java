package de.dhbw.plugins.rest.users;

import de.dhbw.cleanproject.adapter.mappers.UserToUserResourceMapper;
import de.dhbw.cleanproject.adapter.resources.UserResource;
import de.dhbw.cleanproject.application.user.UserApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/user")
public class UsersController {


    private final UserApplicationService userApplicationService;
    private final UserToUserResourceMapper userToUserResourceMapper;

    @Autowired
    public UsersController(final UserApplicationService userApplicationService, final UserToUserResourceMapper userToUserResourceMapper){
        this.userApplicationService = userApplicationService;
        this.userToUserResourceMapper = userToUserResourceMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserResource> getUsers(){
        return this.userApplicationService.findAll().stream().map(userToUserResourceMapper).collect(Collectors.toList());
    }
}
