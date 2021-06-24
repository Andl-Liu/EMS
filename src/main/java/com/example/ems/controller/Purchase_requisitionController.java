package com.example.ems.controller;

import com.example.ems.entity.Purchase_requisition;
import com.example.ems.entity.User;
import com.example.ems.repository.Purchase_requisitionRepository;
import com.example.ems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Purchase_requisitionController {
    @Autowired
    Purchase_requisitionRepository purchase_requisitionRepository;
    @ResponseBody
    @RequestMapping("/purchase_requisition/{id}")
    public Purchase_requisition inquiryPurchase_requisition(@PathVariable("id")String id)
    {
        Purchase_requisition purchase_requisition=purchase_requisitionRepository.findById(id).get();
        return purchase_requisition;
    }
    @ResponseBody
    @RequestMapping("/purchase_requisition")
    public Purchase_requisition insertPurchase_requisition(Purchase_requisition purchase_requisition)
    {
        Purchase_requisition save = purchase_requisitionRepository.save(purchase_requisition);
        return save;
    }
    @ResponseBody
    @RequestMapping("/purchase_requisition/delete/{id}")
    public String deletePurchase_requisition(@PathVariable("id")String id)
    {
        purchase_requisitionRepository.deleteById(id);
        return "删除成功";
    }
}
