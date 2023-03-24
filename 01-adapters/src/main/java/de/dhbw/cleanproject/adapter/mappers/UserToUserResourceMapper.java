package de.dhbw.cleanproject.adapter.mappers;

import de.dhbw.cleanproject.adapter.resources.UserResource;
import org.springframework.stereotype.Component;
import de.dhbw.cleanproject.domain.models.User;

import java.util.function.Function;
@Component
public class UserToUserResourceMapper implements Function<User, UserResource> {

   @Override
   public UserResource apply(final User user){
       return map(user);
   }

   private UserResource map(final User user){
       return new UserResource(user.getName(), user.getName(), user.getPassword(), user.getPoints(), user.getTimeRegistered());
   }

}
