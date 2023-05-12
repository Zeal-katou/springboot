package cn.yunji.user.management2.model;

import java.io.Serializable;



public class User implements Serializable { // 实现Serializable接口，定义一个用户类，用于封装用户的属性和行为。
    private Integer id;
    private String username;
    private String password;
    private String role;

    public User(int i, String admin, String s, String admin1) {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}

