package com.tech552.demosqljpa.repositories;

import com.tech552.demosqljpa.models.Role;
import com.tech552.demosqljpa.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

        void saveUser(User user);
        User findByUserName(String username);
        List<User> userList();
        Role findUserRoleByName(String role);
        Role saveRole();
}
