package com.example.ems.controller;

import com.example.ems.entity.Purchase_order;
import com.example.ems.entity.User;
import com.example.ems.repository.Purchase_orderRepository;
import com.example.ems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Purchase_orderController {
    @Autowired
    Purchase_orderRepository purchase_orderRepository;
    @ResponseBody
    @RequestMapping("/purchase_order/{id}")
    public Purchase_order inquiryPurchase_order(@PathVariable("id")String id)
    {
        Purchase_order purchase_order=purchase_orderRepository.findById(id).get();
        return purchase_order;
    }
    @ResponseBody
    @RequestMapping("/purchase_order")
    public Purchase_order insertPurchase_order(Purchase_order purchase_order)
    {
        Purchase_order save = purchase_orderRepository.save(purchase_order);
        return save;
    }
    @ResponseBody
    @RequestMapping("/purchase_order/delete/{id}")
    public String deletePurchase_order(@PathVariable("id")String  id)
    {
        purchase_orderRepository.deleteById(id);
        return "删除成功";
    }
}
