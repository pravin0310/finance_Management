package org.com.finance_manament.controller;

import org.com.finance_manament.dtos.LoginRequestDto;
import org.com.finance_manament.dtos.SignupRequestDto;
import org.com.finance_manament.dtos.UserDto;
import org.com.finance_manament.models.User;
import org.com.finance_manament.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private IAuthService authservice;

    @PostMapping("/signup")
    public UserDto signup(@RequestBody SignupRequestDto signupRequestDto){
        String roleName = null;
        if (signupRequestDto.getRole() != null && !signupRequestDto.getRole().isEmpty()) {
            roleName = signupRequestDto.getRole().get(0).getName();
        }
        User user = authservice.signup(signupRequestDto.getName(), signupRequestDto.getPassword(), signupRequestDto.getEmail(), roleName);
        return mapToDtoList(user);
    }
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginRequestDto loginRequestDto){
        Pair<User,String> userWithToken = authservice.login(loginRequestDto.getEmail(),loginRequestDto.getPassword());
        System.out.println(userWithToken.getFirst());
        UserDto userDto  = mapToDtoList(userWithToken.getFirst());
        return new ResponseEntity<>(userDto, HttpStatus.OK);
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
