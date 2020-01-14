package com.aop.access.access.service;

import com.aop.access.access.entity.Role;
import com.aop.access.access.entity.User;

import java.util.Set;

/**
 * @Author HLX
 * @Date 2018/7/3 15:12
 */
public interface UserService {

    User findUserByUname(String uname);

    Set<Role> getUsers();

}
