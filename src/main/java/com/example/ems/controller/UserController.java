package com.example.ems.controller;

import com.example.ems.entity.Supplier;
import com.example.ems.entity.User;
import com.example.ems.repository.SupplierRepsitory;
import com.example.ems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;
    @ResponseBody
    @RequestMapping("/user/{id}")
    public User inquiryUser(@PathVariable("id")Integer id)
    {
        User user=userRepository.findById(id).get();
        return user;
    }
    @ResponseBody
    @RequestMapping("/user")
    public User insertUser(User user)
    {
        User save = userRepository.save(user);
        return save;
    }
    @ResponseBody
    @RequestMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id")Integer id)
    {
        userRepository.deleteById(id);
        return "删除成功";
    }
}
