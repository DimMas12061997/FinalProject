package by.masalsky.onlineshop.entities;

import by.masalsky.onlineshop.enums.RoleType;

import javax.persistence.*;

@Entity
@Table(name = ("role"))
public class Role extends Bean {
    private RoleType role_name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('CLIENT', 'ADMINISTRATOR','GUEST')")
    public RoleType getRole_name() {
        return role_name;
    }

    public void setRole_name(RoleType role_name) {
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_name=" + role_name +
                '}';
    }
}
