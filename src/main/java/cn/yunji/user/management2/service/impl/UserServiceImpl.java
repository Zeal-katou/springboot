package cn.yunji.user.management2.service.impl;

import cn.yunji.user.management2.model.User;
import cn.yunji.user.management2.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service // 标注这是一个服务类，用于实现业务逻辑接口，并被spring容器管理。
public class UserServiceImpl implements UserService { // 实现UserService接口，定义一个用户服务实现类。

    private static List<User> users = new ArrayList<>(); // 定义一个静态的用户列表，用于模拟数据库中的数据。

    static { // 静态代码块，在类加载时执行一次，用于初始化一些数据。
        users.add(new User(1, "admin", "123456", "admin")); // 向用户列表中添加一个管理员对象。
        users.add(new User(2, "alice", "123456", "user")); // 向用户列表中添加一个普通用户对象。
        users.add(new User(3, "bob", "123456", "user")); // 向用户列表中添加一个普通用户对象。
        users.add(new User(4, "charlie", "123456", "user")); // 向用户列表中添加一个普通用户对象。
        users.add(new User(5, "david", "123456", "user")); // 向用户列表中添加一个普通用户对象
    }

    @Override
    public User login(String username, String password) { // 实现登录方法。
        for (User user : users) { // 遍历用户列表。
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) { // 如果找到一个用户的用户名和密码都与参数匹配。
                return user; // 返回该用户对象。
            }
        }
        return null; // 如果没有找到匹配的用户，返回null。
    }

    @Override
    public List<User> findAll() { // 实现查询所有用户方法。
        return users; // 返回用户列表。
    }

    @Override
    public void add(User user) { // 实现添加用户方法。
        user.setId(users.size() + 1); // 设置用户的id为用户列表的大小加一，模拟自增主键。
        users.add(user); // 向用户列表中添加该用户对象。
    }

    @Override
    public void delete(Integer id) { // 实现删除用户方法。
        for (int i = 0; i < users.size(); i++) { // 遍历用户列表。
            if (users.get(i).getId().equals(id)) { // 如果找到一个用户的id与参数匹配。
                users.remove(i); // 从用户列表中移除该用户对象。
                break; // 跳出循环。
            }
        }
    }

    @Override
    public void update(User user) { // 实现更新用户方法。
        for (int i = 0; i < users.size(); i++) { // 遍历用户列表。
            if (users.get(i).getId().equals(user.getId())) { // 如果找到一个用户的id与参数中的用户对象的id匹配。
                users.set(i, user); // 用参数中的用户对象替换原来的用户对象。
                break; // 跳出循环。
            }
        }
    }

    @Override
    public User findById(Integer id) { // 实现根据id查询用户方法。
        for (User user : users) { // 遍历用户列表。
            if (user.getId().equals(id)) { // 如果找到一个用户的id与参数匹配。
                return user; // 返回该用户对象。
            }
        }
        return null; // 如果没有找到匹配的用户，返回null。
    }

    @Override
    public List<User> findByName(String name) { // 实现根据名字模糊查询用户方法。
        return users.stream() // 将用户列表转换为流对象，用于进行流式处理。
                .filter(user -> user.getUsername().contains(name)) // 过滤出用户名包含参数中的名字的用户对象，返回一个新的流对象。
                .collect(Collectors.toList()); // 将流对象收集为一个新的列表对象，并返回该列表对象。
    }
}
