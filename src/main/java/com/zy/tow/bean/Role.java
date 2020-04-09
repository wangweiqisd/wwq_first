package com.zy.tow.bean;

import java.util.Set;

public class Role {
    private String id;
    private String roleName;
    private Set<Permissions> permissionsSet;

    public Role(String id, String roleName, Set<Permissions> permissionsSet) {
        this.id = id;
        this.roleName = roleName;
        this.permissionsSet = permissionsSet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Permissions> getPermissionsSet() {
        return permissionsSet;
    }

    public void setPermissionsSet(Set<Permissions> permissionsSet) {
        this.permissionsSet = permissionsSet;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
