package cn.yunji.user.management2.mapper;

import cn.yunji.user.management2.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // 标注这是一个mapper接口，用于定义与数据库交互的方法。
public interface UserMapper { // 定义一个用户mapper接口，用于操作user表。
    User login(String username, String password); // 登录方法，传入用户名和密码，返回一个用户对象或null。
    List<User> findAll(); // 查询所有用户方法，返回一个用户列表。
    void add(User user); // 添加用户方法，传入一个用户对象作为参数。
    void delete(Integer id); // 删除用户方法，传入要删除的用户id作为参数。
    void update(User user); // 更新用户方法，传入一个用户对象作为参数。
    User findById(Integer id); // 根据id查询用户方法，传入要查询的用户id作为参数，返回一个用户对象或null。
    List<User> findByName(String name); // 根据名字模糊查询用户方法，传入要搜索的名字作为参数，返回一个用户列表。
}