package org.com.finance_manament.controller;

import org.com.finance_manament.dtos.SignupRequestDto;
import org.com.finance_manament.dtos.UserDto;
import org.com.finance_manament.models.User;
import org.com.finance_manament.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthController {

    @Autowired
    private IAuthService iAuthService;

    @PostMapping("/signup")
    public UserDto signup(@RequestBody SignupRequestDto signupRequestDto){
        String roleName = null;
        if (signupRequestDto.getRole() != null && !signupRequestDto.getRole().isEmpty()) {
            roleName = signupRequestDto.getRole().get(0).getName();
        }
        User user = iAuthService.signup(signupRequestDto.getName(), signupRequestDto.getPassword(), signupRequestDto.getEmail(), roleName);
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
