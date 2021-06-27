package com.example.ems.controller;

import com.example.ems.entity.*;
import com.example.ems.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

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
    UserRepository userRepository;
    @Autowired
    Purchase_informationRepository purchase_informationRepository;
    @Autowired
    Purchasable_productRepository purchasable_productRepository;
    @Autowired
    SupplierRepsitory supplierRepsitory;
    @Autowired
    Comparison_listRepository comparison_listRepository;

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

    private String getCharAndNumber(int length) {
        Random random = new Random();
        StringBuffer valSb = new StringBuffer();
        String charStr = "0123456789abcdefghijklmnopqrstuvwxyz";
        int charLength = charStr.length();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charLength);
            valSb.append(charStr.charAt(index));
        }
        return valSb.toString();
    }

    @RequestMapping("/submitComparison")
    public String submit(HttpServletRequest request) {
        Comparison_list comparison_list = new Comparison_list();
        Date date = new Date();
        date.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        comparison_list.setId(sdf.format(date) + getCharAndNumber(4));
        comparison_list.setInformation_id(request.getParameter("id"));
        comparison_list.setStatus(0);
        comparison_list.setTime(date);
        comparison_list.setSupplier_amount(Integer.valueOf(request.getParameter("amount")));
        Cookie [] cookies = request.getCookies();
        String user_account = "";
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals("user_id")) {
                    user_account = cookie.getValue();
                    break;
                }
            }
        }
        List<User> users = userRepository.findAll();
        for(User user : users) {
            if(user.getAccount().equals(user_account)) {
                comparison_list.setPurchaser_id(user.getId());
            }
        }
        if(comparison_list.getSupplier_amount() > 0)
            comparison_list.setProduct_id1(Integer.valueOf(request.getParameter("supplier1")));
        if(comparison_list.getSupplier_amount() > 1)
            comparison_list.setProduct_id1(Integer.valueOf(request.getParameter("supplier2")));
        if(comparison_list.getSupplier_amount() > 2)
            comparison_list.setProduct_id1(Integer.valueOf(request.getParameter("supplier3")));
        comparison_listRepository.save(comparison_list);

        Purchase_information information = purchase_informationRepository.getById(request.getParameter("id"));
        information.setStatus(1);
        purchase_informationRepository.save(information);

        return "redirect:/showComparisonGenerator";
    }

}
