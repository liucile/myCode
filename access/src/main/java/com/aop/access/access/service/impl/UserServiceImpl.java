package com.aop.access.access.service.impl;

import com.aop.access.access.entity.Role;
import com.aop.access.access.entity.User;
import com.aop.access.access.repository.UserRepository;
import com.aop.access.access.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

/**
 * @Author HLX
 * @Date 2018/7/3 15:42
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    public User findUserByUname(String uname) {
        return repository.getUserByUname(uname);
    }

    @Override
    @Transactional
    public Set<Role> getUsers() {
        List<User> users = repository.findAll();
        Set<Role> roleSet = users.get(0).getRoles();
        return roleSet;
    }




}
