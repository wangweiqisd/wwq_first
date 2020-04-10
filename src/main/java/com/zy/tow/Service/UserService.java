package com.zy.tow.Service;

import com.zy.tow.bean.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getOne(Long id);
    String getUserName ();
    void insert(User user);

    void update(User user);

    void delete(Long id);
}
