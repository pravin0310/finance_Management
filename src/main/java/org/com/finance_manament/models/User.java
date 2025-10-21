package org.com.finance_manament.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class User extends BaseModel{
    private String name;
    private String password;
    private String email;

    @ManyToMany()
    private List<Role> role;
}