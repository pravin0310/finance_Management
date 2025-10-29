package org.com.finance_manament.dtos;

import lombok.Getter;
import lombok.Setter;
import org.com.finance_manament.models.Role;

import java.util.List;

@Getter
@Setter
public class SignupRequestDto {
    private String name;
    private String email;
    private String password;
    private List<Role> role;
}
