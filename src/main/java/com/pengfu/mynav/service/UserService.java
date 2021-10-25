package com.pengfu.mynav.service;

import com.pengfu.mynav.mapper.UserMapper;
import com.pengfu.mynav.model.entity.User;
import com.pengfu.mynav.model.vo.UserVo;
import com.pengfu.mynav.util.Result;
import com.pengfu.mynav.util.ResultCode;
import com.pengfu.mynav.util.ServiceException;
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


    private User findByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        List<User> userList = userMapper.select(user);
        if (userList.isEmpty()) {
            return null;
        }
        return userList.get(0);
    }

    public UserVo register(String username, String password) throws Exception {
        // 判断是否已被注册
        if (findByUsername(username) != null) {
            throw new ServiceException("用户名存在");
        }

        // 用户注册
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if (userMapper.insert(user) > 0) {
            UserVo userVo = new UserVo();
            userVo.setUsername(username);
            userVo.setUid(user.getId());
            return userVo;
        }
        throw new Exception("注册失败");
    }

    public UserVo login(String username, String password) {
        return null;
    }

}
