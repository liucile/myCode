package com.aop.access.access.repository;

import com.aop.access.access.entity.Role;
import com.aop.access.access.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author HLX
 * @Date 2018/7/3 14:03
 */
public interface UserRepository extends JpaRepository<User, String>{

    User getUserByUname(String uname);

    List<Role> getRoleByUserId(String user_id);

}
