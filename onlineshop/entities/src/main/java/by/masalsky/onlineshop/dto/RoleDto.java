package by.masalsky.onlineshop.dto;

import by.masalsky.onlineshop.enums.RoleType;


public class RoleDto extends BeanDto {
    private RoleType role_name;

    public RoleType getRole_name() {
        return role_name;
    }

    public void setRole_name(RoleType role_name) {
        this.role_name = role_name;
    }
}
