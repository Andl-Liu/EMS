package com.example.ems.controller;

import com.example.ems.entity.*;
import com.example.ems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller

public class login {
    //@Autowired
    @Autowired
    UserRepository u;

    //@ResponseBody
    @RequestMapping("/login")
    public String login(HttpServletRequest st,Model model) {
        String id = st.getParameter("id");
        String pswd = st.getParameter("Pswd");
        List<User> user = u.findAll();
//        String ans = "";
//        for(User u : user) {
//            ans += u.getName() + "\n";
//        }
//        return ans;
        // User user=u.findById(id).get();
        int flag=1;
        for (User a : user) {
            if (a.getAccount().equals(id)) {
                if (a.getPassword().equals(pswd)) {
                    flag=0;
                    model.addAttribute("flag", flag);
                    model.addAttribute("user_id", a.getAccount());
                    model.addAttribute("user_name", a.getName());
                    model.addAttribute("user_planner_authority", a.getPlanner_authority());
                    model.addAttribute("user_purchaser_authority", a.getPurchaser_authority());
                    model.addAttribute("user_inventory_authority", a.getInventory_authority());
                    return "index.html";
                }
                else {
                    model.addAttribute("flag", flag);
                    return "loginpage.html";
                }
            }
        }
        model.addAttribute("flag", flag);
        return "loginpage.html";
    }

}
