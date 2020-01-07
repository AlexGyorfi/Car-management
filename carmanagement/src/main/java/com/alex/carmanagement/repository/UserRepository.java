package com.alex.carmanagement.repository;

import com.alex.carmanagement.datamodel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User getUserByUsername(String username);

}
