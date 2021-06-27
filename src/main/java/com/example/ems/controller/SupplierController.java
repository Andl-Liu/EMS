package com.example.ems.controller;

import com.example.ems.entity.Supplier;
import com.example.ems.repository.SupplierRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    @RequestMapping("/supplier/all")
    public List<Supplier> inquiryallSupplier(Supplier supplier)
    {
       List<Supplier> suppliers= supplierRepsitory.findAll();
       System.out.println(suppliers);
       return suppliers;
    }
    @ResponseBody
    @RequestMapping("/supplier/modify/{id}")
    public String modifySupplier(@PathVariable("id")Integer id,Supplier supplier)
    {
        //supplierRepsitory.deleteById(id);
       supplierRepsitory.save(supplier);
       return "修改成功";
    }
    @ResponseBody
    @RequestMapping("/supplier/delete/{id}")
    public String deleteSupplier(@PathVariable("id")Integer id)
    {
        supplierRepsitory.deleteById(id);
        return "删除成功";
    }

    @RequestMapping("/suppliers")
    public String a()
    {
        return "sup.html";
    }
}
