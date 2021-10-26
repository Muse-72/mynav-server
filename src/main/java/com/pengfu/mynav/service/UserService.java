package com.pengfu.mynav.service;

import com.pengfu.mynav.mapper.UserMapper;
import com.pengfu.mynav.model.dto.UserDTO;
import com.pengfu.mynav.model.entity.User;
import com.pengfu.mynav.model.vo.UserVO;
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

    public UserVO register(UserDTO userDTO) throws Exception {
        // 参数判断
        if (userDTO.getUsername().length() > 16) {
            throw new ServiceException("用户名长度必须为1到16");
        }

        // 判断是否已被注册
        if (findByUsername(userDTO.getUsername()) != null) {
            throw new ServiceException("用户名存在");
        }

        // 用户注册
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());

        if (userMapper.insert(user) > 0) {
            UserVO userVO = new UserVO();
            userVO.setUsername(userDTO.getUsername());
            userVO.setUid(user.getId());
            return userVO;
        }
        throw new Exception("注册失败");
    }

    public UserVO login(String username, String password) {
        return null;
    }

}
