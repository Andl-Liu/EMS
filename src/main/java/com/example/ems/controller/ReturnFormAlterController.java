package com.example.ems.controller;

import com.example.ems.entity.Purchasable_product;
import com.example.ems.entity.Return_form;
import com.example.ems.repository.Purchasable_productRepository;
import com.example.ems.repository.Return_formRepository;
import com.example.ems.repository.SupplierRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

class ReturnFormForDisplay {
    private String id;
    private String name;
    private String specification;
    private double amount;
    private String unit;
    private String supplier;
    private String status;

    public ReturnFormForDisplay(Return_form form, Purchasable_product product, String supplier) {
        this.id = form.getId();
        this.name = product.getName();
        this.specification = product.getSpecification();
        this.amount = form.getAmount();
        this.unit = product.getUnit();
        this.supplier = supplier;
        if(form.getStatus()){
            this.status = "已完成";
        }
        else {
            this.status = "退货中";
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}

@Controller
public class ReturnFormAlterController {
    @Autowired
    Return_formRepository return_formRepository;
    @Autowired
    Purchasable_productRepository purchasable_productRepository;
    @Autowired
    SupplierRepsitory supplierRepsitory;

    @RequestMapping("/alterReturnForm")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView();
        List<Return_form> return_forms = return_formRepository.findAll();
        List<ReturnFormForDisplay> returnFormForDisplays = new ArrayList<>();

        for(Return_form e : return_forms) {
            Purchasable_product product = purchasable_productRepository.getById(e.getProduct_id());
            String supplier = supplierRepsitory.getById(product.getSupplier_id()).getName();
            returnFormForDisplays.add(new ReturnFormForDisplay(e, product, supplier));
        }

        modelAndView.addObject("returnFormForDisplays", returnFormForDisplays);
        modelAndView.setViewName("alttd");
        return modelAndView;
    }

    @RequestMapping("/confirmReturn")
    public String confirm(@RequestParam("id") String id) {
        Return_form form = return_formRepository.getById(id);
        form.setStatus(!form.getStatus());
        return_formRepository.save(form);
        return "redirect:/alterReturnForm";
    }

    @RequestMapping("/deleteReturn")
    public String delete(@RequestParam("id") String id) {
        return_formRepository.deleteById(id);
        return "redirect:/alterReturnForm";
    }
}
