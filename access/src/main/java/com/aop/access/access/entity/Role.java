package com.aop.access.access.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * 角色表
 * @Author HLX
 * @Date 2018/7/3 11:40
 */
@Entity
@Getter
@Setter
public class Role {

    @Id
    private Integer roleId;

    private String rname;

    private String remark;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
    private Set<User> users;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
    private Set<Privilage> privilages;

    public Role(Integer roleId, String rname) {
        this.roleId = roleId;
        this.rname = rname;
    }

    public Role() {
        super();
    }
}
