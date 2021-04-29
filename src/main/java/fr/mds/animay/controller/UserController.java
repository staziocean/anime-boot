package fr.mds.animay.controller;

import fr.mds.animay.dto.UserDto;
import fr.mds.animay.model.User;
import fr.mds.animay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN') or @securityExpressions.isConnectedUser(#id, principal)")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto user) {
        return UserDto.fromUser(userService.update(id, UserDto.toUser(user)));
    }
}
