package org.myownstock.user.roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    @Autowired
    RoleService roleService;
    @PostMapping
    public Role add(@RequestBody Role role){
        return roleService.add(role);
    }

    @GetMapping
    public List<Role> findAll(){
        return roleService.findAll();
    }

}
