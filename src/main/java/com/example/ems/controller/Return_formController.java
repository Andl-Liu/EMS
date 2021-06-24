package com.example.ems.controller;

import com.example.ems.entity.Return_form;
import com.example.ems.entity.User;
import com.example.ems.repository.Return_formRepository;
import com.example.ems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Return_formController {
    @Autowired
    Return_formRepository return_formRepository;
    @ResponseBody
    @RequestMapping("/return_form/{id}")
    public Return_form inquiryReturn_form(@PathVariable("id")String id)
    {
        Return_form return_form=return_formRepository.findById(id).get();
        return return_form;
    }
    @ResponseBody
    @RequestMapping("/return_form")
    public Return_form insertReturn_form(Return_form return_form)
    {
        Return_form save = return_formRepository.save(return_form);
        return save;
    }
    @ResponseBody
    @RequestMapping("/return_form/delete/{id}")
    public String deleteReturn_form(@PathVariable("id")String id)
    {
        return_formRepository.deleteById(id);
        return "删除成功";
    }
}
