package com.goit.Mod15Dev.data.entity;

import com.goit.Mod15Dev.utils.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class RolesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private UserRole name;

    public RolesEntity() {}

    public RolesEntity(UserRole name) {
        this.name = name;
    }
}
