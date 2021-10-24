package com.pengfu.mynav.service;

import com.pengfu.mynav.mapper.UserMapper;
import com.pengfu.mynav.model.entity.User;
import com.pengfu.mynav.model.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author PrideZH
 * @date 2021/10/20 - 21:04
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public User findByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        List<User> userList = userMapper.select(user);
        if (userList.isEmpty()) {
            return null;
        }
        return userList.get(0);
    }

    public UserVo register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if (userMapper.insert(user) > 0) {
            UserVo userVo = new UserVo();
            userVo.setUsername(username);
            userVo.setUid(user.getId());
            return userVo;
        }
        return null;
    }

    public UserVo login(String username, String password) {
        return null;
    }

}
