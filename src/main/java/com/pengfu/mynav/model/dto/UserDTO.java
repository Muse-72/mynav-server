package com.pengfu.mynav.model.dto;

/**
 * @author PrideZH
 * @date 2021/10/25 - 23:26
 */
public class UserDTO {

    private Integer uid;

    private String token;

    private String username;

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getUid() {
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
