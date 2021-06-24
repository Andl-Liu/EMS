package com.example.ems.controller;

import com.example.ems.entity.Purchasable_product;
import com.example.ems.entity.User;
import com.example.ems.repository.Purchasable_productRepository;
import com.example.ems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Purchasable_productController {
    @Autowired
    Purchasable_productRepository purchasable_productRepository;
    @ResponseBody
    @RequestMapping("/purchasable_product/{id}")
    public Purchasable_product inquiryUser(@PathVariable("id")Integer id)
    {
        Purchasable_product purchasable_product=purchasable_productRepository.findById(id).get();
        return purchasable_product;
    }
    @ResponseBody
    @RequestMapping("/purchasable_product")
    public Purchasable_product insertUser(Purchasable_product purchasable_product)
    {
        Purchasable_product save = purchasable_productRepository.save(purchasable_product);
        return save;
    }
    @ResponseBody
    @RequestMapping("/purchasable_product/delete/{id}")
    public String deleteUser(@PathVariable("id")Integer id)
    {
        purchasable_productRepository.deleteById(id);
        return "删除成功";
    }
}
