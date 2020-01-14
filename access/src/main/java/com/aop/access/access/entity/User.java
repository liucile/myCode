package com.aop.access.access.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * 用户表
 * @Author HLX
 * @Date 2018/7/3 11:40
 */
@Entity
@Getter
@Setter
public class User implements Serializable{

    @Id
    @GeneratedValue
    private String userId;

    private String uname;

    private String upwd;

    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE", joinColumns = {
            @JoinColumn(name = "USER_ID", referencedColumnName = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "roleId")})
    private Set<Role> roles;


}
