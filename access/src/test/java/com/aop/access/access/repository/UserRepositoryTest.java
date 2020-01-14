package com.aop.access.access.repository;

import com.aop.access.access.entity.Role;
import com.aop.access.access.entity.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * @Author HLX
 * @Date 2018/7/3 14:08
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void getUserByName() {
        User user = repository.getUserByUname("1");
        Assert.assertNotNull(user);
    }

    @Test
    @Transactional
    public void getUsers(){
        List<User> userList = repository.findAll();

        Set<Role> roles = userList.get(0).getRoles().
                stream().map(e -> new Role(e.getRoleId(),e.getRname())).
                collect(Collectors.toSet());
        
        for(Role role : roles){
            System.out.println(role.getRoleId());
        }
    }
}