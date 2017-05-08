package entities;

import enums.RoleType;

import javax.persistence.*;

@Entity
@Table(name = ("role"))
public class Role extends Bean {
    private RoleType role_name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('CLIENT', 'ADMINISTRATOR')")
    public RoleType getRole_name() {
        return role_name;
    }

    public void setRole_name(RoleType role_name) {
        this.role_name = role_name;
    }
}
