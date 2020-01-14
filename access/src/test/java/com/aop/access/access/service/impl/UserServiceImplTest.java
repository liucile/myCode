package com.aop.access.access.service.impl;

import com.aop.access.access.entity.Role;
import com.aop.access.access.entity.User;
import com.aop.access.access.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * @Author HLX
 * @Date 2018/7/4 16:50
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void getUsers(){
        Set<Role> roles = userService.getUsers();
        System.out.println(roles.size());
    }
}