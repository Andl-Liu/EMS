package com.example.ems.controller;

import com.example.ems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class hdxdgh {
    @Autowired
    UserRepository u;

    @RequestMapping("/sssf")
    Map<String, Object> fasdf(HttpServletRequest req) {
        Map<String, Object> x = new HashMap<>();
        x.put("info", 0);
        x.put("ljasdf",u.findAll());
        return x;
    }
}
