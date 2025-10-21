package org.com.finance_manament.service;

import org.com.finance_manament.controller.AuthController;
import org.com.finance_manament.dtos.UserDto;
import org.com.finance_manament.exceptions.UserAlreadyExistException;
import org.com.finance_manament.models.User;
import org.com.finance_manament.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Authservice implements IAuthService{

    @Autowired
    private UserRepo userRepo;

    public User signup(String name, String password, String email, String role){
        Optional<User> userOptional = userRepo.findByEmailEqual(email);
        if(userOptional.isPresent()){
            throw new UserAlreadyExistException("User Already Exist");
        }
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);

        return userRepo.save(user);
    }
}
