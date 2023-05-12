package cn.yunji.user.management2.controller;

import cn.yunji.user.management2.model.User;
import cn.yunji.user.management2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @GetMapping("/add")
    public String add() {
        return "userAdd";
    }

    @PostMapping("/add")
    public String add(User user) {
        userService.add(user);
        return "redirect:/user/list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "userUpdate";
    }

    @PostMapping("/update")
    public String update(User user) {
        userService.update(user);
        return "redirect:/user/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        userService.delete(id);
        return "redirect:/user/list";
    }

    @GetMapping("/search")
    public String search(String name, Model model) {
        model.addAttribute("users", userService.findByName(name));
        return "userList";
    }
}
