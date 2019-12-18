package com.alex.carmanagement.service;

import com.alex.carmanagement.datamodel.Role;
import com.alex.carmanagement.exceptions.MyException;
import com.alex.carmanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> findRoleByUserId(Integer userId) {
        return roleRepository.findRoleByUserId(userId);

    }

    public List<Role> findAllRoles() {
        List<Role> roles = new ArrayList<>();
        roleRepository.findAll().forEach(c -> roles.add(c));
        return roles;
    }

    public void deleteRole(int id) {
        if (roleRepository.findById(id).isPresent()) {
            roleRepository.deleteById(id);
        } else {
            throw new MyException("Impossible to delete. No such role!");
        }
    }
}
