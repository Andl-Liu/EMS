package com.example.ems.controller;

import com.example.ems.entity.Purchasable_product;
import com.example.ems.entity.Purchase_information;
import com.example.ems.repository.Purchasable_productRepository;
import com.example.ems.repository.Purchase_informationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Purchase_informationController {
    @Autowired
    Purchase_informationRepository purchase_informationRepository;
    @ResponseBody
    @RequestMapping("/purchase_information/{id}")
    public Purchase_information inquiryUser(@PathVariable("id")String id)
    {
        Purchase_information purchase_information=purchase_informationRepository.findById(id).get();
        return purchase_information;
    }
    @ResponseBody
    @RequestMapping("/purchase_information")
    public Purchase_information insertUser(Purchase_information purchase_information)
    {
        Purchase_information save = purchase_informationRepository.save(purchase_information);
        return save;
    }
    @ResponseBody
    @RequestMapping("/purchase_information/delete/{id}")
    public String deleteUser(@PathVariable("id")String id)
    {
        purchase_informationRepository.deleteById(id);
        return "删除成功";
    }
}
