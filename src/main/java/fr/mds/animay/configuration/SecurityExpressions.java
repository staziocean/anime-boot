package fr.mds.animay.configuration;

import fr.mds.animay.model.User;
import fr.mds.animay.repository.UserRepository;
import fr.mds.animay.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
public class SecurityExpressions {

    private final UserService userService;

    public SecurityExpressions(UserService userService) {
        this.userService = userService;
    }

    public boolean isConnectedUser(Long id, UserDetails connectedUser) {
        User modifiedUser = userService.findById(id);
        return modifiedUser.getUsername().equals(connectedUser.getUsername());
    }
}
