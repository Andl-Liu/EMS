package com.example.ems.controller;

import com.example.ems.entity.Purchasable_product;
import com.example.ems.entity.Purchase_information;
import com.example.ems.entity.Supplier;
import com.example.ems.repository.Purchasable_productRepository;
import com.example.ems.repository.Purchase_informationRepository;
import com.example.ems.repository.SupplierRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ComparisonForDisplay{
    private String id;
    private String name;
    private String specification;
    private double amount;
    private String unit;
    private List<Integer> product_id;
    private Map<Integer, String> suppliers;

    public ComparisonForDisplay(Purchase_information information) {
        this.id = information.getId();
        this.name = information.getName();
        this.specification = information.getSpecification();
        this.amount = information.getAmount();
        this.unit = information.getUnit();
        this.product_id = new ArrayList<>();
        this.suppliers = new HashMap<>();
    }

    public List<Integer> getProduct_id() {
        return product_id;
    }

    public void setProduct_id(List<Integer> product_id) {
        this.product_id = product_id;
    }

    public Map<Integer, String> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Map<Integer, String> suppliers) {
        this.suppliers = suppliers;
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
}

@Controller
public class ComparisonGeneratorController {
    @Autowired
    Purchase_informationRepository purchase_informationRepository;
    @Autowired
    Purchasable_productRepository purchasable_productRepository;
    @Autowired
    SupplierRepsitory supplierRepsitory;

    @RequestMapping("/showComparisonGenerator")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView();
        List<Purchase_information> purchase_informations = purchase_informationRepository.findAll();
        List<Purchasable_product> purchasable_products = purchasable_productRepository.findAll();
        List<ComparisonForDisplay> comparisonForDisplays = new ArrayList<>();

        for(Purchase_information e : purchase_informations) {
            if(e.getStatus() != 0)
                continue;
            ComparisonForDisplay comparisonForDisplay = new ComparisonForDisplay(e);
            for(Purchasable_product product : purchasable_products) {
                if(product.getName().equals(e.getName()) && product.getSpecification().equals(e.getSpecification()) && product.getUnit().equals(e.getUnit())) {
                    comparisonForDisplay.getProduct_id().add(product.getId());
                    comparisonForDisplay.getSuppliers().put(product.getId(), supplierRepsitory.getById(product.getSupplier_id()).getName());
                }
            }
            comparisonForDisplays.add(comparisonForDisplay);
        }
        modelAndView.addObject("comparisonForDisplays", comparisonForDisplays);
        modelAndView.setViewName("pricelist");
        return modelAndView;
    }

}
