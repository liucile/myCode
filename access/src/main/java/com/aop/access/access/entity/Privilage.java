package com.aop.access.access.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * 权限表
 * @Author HLX
 * @Date 2018/7/3 11:40
 */
@Getter
@Setter
@Entity
public class Privilage {

    @Id
    @GeneratedValue
    private Integer privilageId;

    private String pname;

    private String remark;

    @ManyToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinTable(name = "ROLE_PRIVILAGE", joinColumns = {
            @JoinColumn(name = "PRIVILAGE_ID", referencedColumnName = "privilageId")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "roleId")})
    private Set<Role> roles;

}
