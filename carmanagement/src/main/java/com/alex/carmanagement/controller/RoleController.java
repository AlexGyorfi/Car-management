package com.alex.carmanagement.controller;

import com.alex.carmanagement.datamodel.Role;
import com.alex.carmanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @PostMapping
    public Role createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }
    @GetMapping(value = "/{userId}")
    public List<Role> findRoleByUserId(@PathVariable(name = "userId")int userId){
        return roleService.findRoleByUserId(userId);
    }
    @GetMapping(value = "/findAllRoles")
    public List<Role> findAllRoles(){
        return roleService.findAllRoles();
    }
    @DeleteMapping(value = "/{id}")
    public String deleteRole(@PathVariable(name = "id")int id){
        roleService.deleteRole(id);
        return "Role deleted";
    }
}
