package com.example.ems.controller;

import com.example.ems.entity.Comparison_list;
import com.example.ems.entity.User;
import com.example.ems.repository.Comparison_listRepository;
import com.example.ems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class Comparison_listController {
    @Autowired
    Comparison_listRepository comparison_listRepository;
    @ResponseBody
    @RequestMapping("/comparison_list/{id}")
    public Comparison_list inquiryComparison_list(@PathVariable("id")String id)
    {
        Comparison_list comparison_list =comparison_listRepository.findById(id).get();
        return comparison_list;
    }
    @ResponseBody
    @RequestMapping("/comparison_list")
    public Comparison_list insertComparison_list(Comparison_list comparison_list)
    {
        Comparison_list save = comparison_listRepository.save(comparison_list);
        return save;
    }
    @ResponseBody
    @RequestMapping("/comparison_list/delete/{id}")
    public String deleteComparison_list(@PathVariable("id")String id)
    {
        comparison_listRepository.deleteById(id);
        return "删除成功";
    }
}
