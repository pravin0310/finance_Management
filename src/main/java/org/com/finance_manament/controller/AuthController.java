package org.com.finance_manament.controller;

import org.com.finance_manament.dtos.UserDto;
import org.com.finance_manament.models.User;
import org.com.finance_manament.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IAuthService iAuthService;

    @RequestMapping("/signup")
    public UserDto signup(String username, String password, String email, String role){
        User user = iAuthService.signup(username, password, email, role);
        return mapToDtoList(user);
    }
    public UserDto mapToDtoList(User user){
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());

        return userDto;
    }

}
