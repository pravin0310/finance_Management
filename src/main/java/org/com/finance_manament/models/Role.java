package org.com.finance_manament.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity

public class Role extends BaseModel{
    private String name;

    @ManyToMany(mappedBy = "role")
    private List<User> users;
}
