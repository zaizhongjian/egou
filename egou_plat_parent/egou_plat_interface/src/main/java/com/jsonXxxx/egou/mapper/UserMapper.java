package com.jsonXxxx.egou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jsonXxxx.egou.entity.User;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author JsonXxxx
 * @since 2019-03-20
 */
public interface UserMapper extends BaseMapper<User> {
    User selectByUsername(String username);
}
