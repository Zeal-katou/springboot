package cn.yunji.user.management2.service;

import cn.yunji.user.management2.model.User;

import java.util.List;

public interface UserService {

    User login(String username, String password);

    List<User> findAll();

    User findById(Integer id);

    void add(User user);

    void update(User user);

    void delete(Integer id);

    List<User> findByName(String name);
}
