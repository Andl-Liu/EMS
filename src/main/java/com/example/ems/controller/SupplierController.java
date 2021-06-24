package com.example.ems.controller;

import com.example.ems.entity.Supplier;
import com.example.ems.repository.SupplierRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SupplierController {
    @Autowired
    SupplierRepsitory supplierRepsitory;
    @ResponseBody
    @RequestMapping("/supplier/{id}")
    public Supplier inquirySupplier(@PathVariable("id")Integer id)
    {
        Supplier supplier=supplierRepsitory.findById(id).get();
        System.out.println(supplier);
        return supplier;
    }
    @ResponseBody
    @RequestMapping("/supplier")
    public Supplier insertSupplier(Supplier supplier)
    {
        Supplier save = supplierRepsitory.save(supplier);
        return save;
    }
    @ResponseBody
    @RequestMapping("/supplier/delete/{id}")
    public String deleteSupplier(@PathVariable("id")Integer id)
    {
        supplierRepsitory.deleteById(id);
        return "删除成功";
    }
}
