package com.zy.tow.bean;

import com.zy.tow.Service.UserService;

import javax.annotation.Resource;
import java.util.Set;

public class User {
    private String id;
    private String name;
    private String age;
    private Set<Role> roleSet;
    private String password;


    public User(String id, String name, String age, Set<Role> roleSet) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.roleSet = roleSet;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", roleSet=" + roleSet +
                ", password='" + password + '\'' +
                '}';
    }
}
