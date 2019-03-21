package com.jsonXxxx.egou.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author JsonXxxx
 * @since 2019-03-20
 */
public class Role_permission extends Model<Role_permission> {

    private static final long serialVersionUID = 1L;

    private Long role_id;

    private Long permission_id;

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }
    public Long getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(Long permission_id) {
        this.permission_id = permission_id;
    }

    @Override
    protected Serializable pkVal() {
        return this.role_id;
    }

    @Override
    public String toString() {
        return "Role_permission{" +
        "role_id=" + role_id +
        ", permission_id=" + permission_id +
        "}";
    }
}
