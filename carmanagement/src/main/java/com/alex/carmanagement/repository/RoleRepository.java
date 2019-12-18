package com.alex.carmanagement.repository;

import com.alex.carmanagement.datamodel.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    List<Role> findRoleByUserId(Integer userId);

}
