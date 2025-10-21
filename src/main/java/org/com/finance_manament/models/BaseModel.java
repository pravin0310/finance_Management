package org.com.finance_manament.models;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public abstract class BaseModel {
    @Id
    private String id;
    private Date CreatedAt;
    private Date UpdatedAt;
    private String CreatedBy;
    private String UpdatedBy;

    @ManyToMany()
    private List<Role> roles;
}

