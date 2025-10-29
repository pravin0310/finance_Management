package org.com.finance_manament.service;

import org.com.finance_manament.controller.AuthController;
import org.com.finance_manament.dtos.UserDto;
import org.com.finance_manament.exceptions.UserAlreadyExistException;
import org.com.finance_manament.models.Role;
import org.com.finance_manament.models.User;
import org.com.finance_manament.repository.RoleRepo;
import org.com.finance_manament.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Authservice implements IAuthService{

    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private RoleRepo roleRepo;

    public User signup(String name, String password, String email, String roleName){
        Optional<User> userOptional = userRepo.findByEmailEquals(email);
        if(userOptional.isPresent()) {
            throw new UserAlreadyExistException("Please try login directly !!!");
        }
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);

        // Handle role assignment
        if (roleName != null && !roleName.isEmpty()) {
            Optional<Role> roleOptional = roleRepo.findByName(roleName);
            if (roleOptional.isPresent()) {
                List<Role> roles = new ArrayList<>();
                roles.add(roleOptional.get());
                user.setRole(roles);
            } else {
                // Create new role if it doesn't exist
                Role newRole = new Role();
                newRole.setName(roleName);
                Role savedRole = roleRepo.save(newRole);
                List<Role> roles = new ArrayList<>();
                roles.add(savedRole);
                user.setRole(roles);
            }
        }

        return userRepo.save(user);
    }
}
