package com.pengfu.mynav.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author PrideZH
 * @date 2021/10/25 - 23:26
 */
@ApiModel("用户信息")
public class UserVO {

    @ApiModelProperty(value = "用户ID")
    private Long uid;

    @ApiModelProperty(value = "用户令牌")
    private String token;

    @ApiModelProperty(value = "用户账号")
    private String username;

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getUid() {
        return uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "uid=" + uid +
                ", token='" + token + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
