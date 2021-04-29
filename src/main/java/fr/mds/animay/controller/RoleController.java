package fr.mds.animay.controller;

import fr.mds.animay.model.Role;
import fr.mds.animay.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @PostMapping
    public Role create(@RequestBody Role role) {
        return roleService.create(role);
    }
}
