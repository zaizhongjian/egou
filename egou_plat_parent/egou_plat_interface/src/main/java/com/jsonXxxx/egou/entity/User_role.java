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
public class User_role extends Model<User_role> {

    private static final long serialVersionUID = 1L;

    private Long user_id;

    private Long role_id;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    @Override
    protected Serializable pkVal() {
        return this.user_id;
    }

    @Override
    public String toString() {
        return "User_role{" +
        "user_id=" + user_id +
        ", role_id=" + role_id +
        "}";
    }
}
