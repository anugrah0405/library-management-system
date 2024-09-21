package com.example.library_management_system.controller;

import com.example.library_management_system.entity.User;
import com.example.library_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/view")
    public String viewAllUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users"; // This will look for users.html in src/main/resources/templates
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User getUser(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
