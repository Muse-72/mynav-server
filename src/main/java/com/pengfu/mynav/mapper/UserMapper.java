package com.pengfu.mynav.mapper;

import com.pengfu.mynav.model.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author PrideZH
 * @date 2021/10/16 - 16:06
 */
@Repository
public interface UserMapper {

    /**
     * 查询用户数据
     * @param user 属性不为空则为查询条件
     * @return 用户数据列表
     */
    List<User> select(User user);

    /**
     * 添加用户数据
     * @param user 欲添加数据
     * @return 添加后数据
     */
    Integer insert(User user);
}
