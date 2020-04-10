package com.zy.tow.Service;

import com.zy.tow.bean.User;

public interface LoginService {
    User getUserByName(String getMapByName);
    User getMapByName(String userName);
}
