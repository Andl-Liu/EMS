package com.example.ems.controller;

import com.example.ems.entity.*;
import com.example.ems.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//用来展示采购申请
class RequisitionForDisplay {
    private String id;
    private String type;
    private Date date;
    private String Planner_name;
    private String Planner_id;

    public RequisitionForDisplay(String id, int type, Date date,String planner_id,String planner_name) {
        this.id = id;
        this.date = date;
        this.Planner_id = planner_id;
        this.Planner_name = planner_name;
        if(type == 0) {
            this.type = "外协粗生产计划";
        }
        else if(type == 1) {
            this.type = "自传外协生产单";
        }
        else if(type == 2) {
            this.type = "原材料采购申请";
        }
        else if(type == 3) {
            this.type = "配套件采购申请";
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlanner_name() {
        return Planner_name;
    }

    public void setPlanner_name(String planner_name) {
        Planner_name = planner_name;
    }

    public String getPlanner_id() {
        return Planner_id;
    }

    public void setPlanner_id(String planner_id) {
        Planner_id = planner_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

//用来展示采购信息
class InformationForDisplay {
    private String id;
    private String name;
    private String specification;
    private double amount;
    private String unit;
    private String status;

    public InformationForDisplay(Purchase_information p) {
        this.id = p.getId();
        this.name = p.getName();
        this.specification = p.getSpecification();
        this.amount = p.getAmount();
        this.unit = p.getUnit();
        if(p.getStatus() == 0) {
            this.status = "申请成功";
        }
        else if(p.getStatus() == 1) {
            this.status = "已生成比价单";
        }
        else if(p.getStatus() == 2) {
            this.status = "已生成采购单";
        }
        else {
            this.status = "已完成采购";
        }
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

//用来展示采购单
class OrderForDisplay {
    private String id;
    private Date time;
    private String purchaser_id;
    private String purchaser_name;
    private Date  completion_time;
    private Boolean material;
    private int evaluation;
    private String supplier_name;
    private String status;
    private String information_id;

    public OrderForDisplay(Purchase_order p, String supplier_name, String purchaser_id, String purchaser_name) {
        this.id = p.getId();
        this.time = p.getTime();
        this.completion_time = p.getCompletion_time();
        this.material = p.getMaterial();
        this.evaluation = p.getEvaluation();
        this.information_id = p.getInformation_id();
        this.purchaser_id = purchaser_id;
        this.purchaser_name = purchaser_name;
        this.supplier_name = supplier_name;
        if(p.getStatus() == 0) {
            this.status = "生成成功";
        }
        else if(p.getStatus() == 1) {
            this.status = "未完成";
        }
        else {
            this.status = "已完成";
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPurchaser_id() {
        return purchaser_id;
    }

    public void setPurchaser_id(String purchaser_id) {
        this.purchaser_id = purchaser_id;
    }

    public String getPurchaser_name() {
        return purchaser_name;
    }

    public void setPurchaser_name(String purchaser_name) {
        this.purchaser_name = purchaser_name;
    }

    public Date getCompletion_time() {
        return completion_time;
    }

    public void setCompletion_time(Date completion_time) {
        this.completion_time = completion_time;
    }

    public Boolean getMaterial() {
        return material;
    }

    public void setMaterial(Boolean material) {
        this.material = material;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInformation_id() {
        return information_id;
    }

    public void setInformation_id(String information_id) {
        this.information_id = information_id;
    }
}

//用来展示比价单
class ListForDisplay {
    private String id;
    private String name;
    private double price1;
    private String supplier1;
    private double price2;
    private String supplier2;
    private double price3;
    private String supplier3;
    private Date time;
    private Date completion_time;

    public ListForDisplay(Comparison_list c, String name, String supplier1, double price1
                                                        , String supplier2, double price2
                                                        , String supplier3, double price3) {
        this.id = c.getId();
        this.name = name;
        this.price1 = price1;
        this.supplier1 = supplier1;
        this.price2 = price2;
        this.supplier2 = supplier2;
        this.price3 = price3;
        this.supplier3 = supplier3;
        this.time = c.getTime();
        this.completion_time = c.getCompletion_time();
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

    public double getPrice1() {
        return price1;
    }

    public void setPrice1(double price1) {
        this.price1 = price1;
    }

    public String getSupplier1() {
        return supplier1;
    }

    public void setSupplier1(String supplier1) {
        this.supplier1 = supplier1;
    }

    public double getPrice2() {
        return price2;
    }

    public void setPrice2(double price2) {
        this.price2 = price2;
    }

    public String getSupplier2() {
        return supplier2;
    }

    public void setSupplier2(String supplier2) {
        this.supplier2 = supplier2;
    }

    public double getPrice3() {
        return price3;
    }

    public void setPrice3(double price3) {
        this.price3 = price3;
    }

    public String getSupplier3() {
        return supplier3;
    }

    public void setSupplier3(String supplier3) {
        this.supplier3 = supplier3;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getCompletion_time() {
        return completion_time;
    }

    public void setCompletion_time(Date completion_time) {
        this.completion_time = completion_time;
    }

}

//用来展示退货单
class FormForDisplay {
    private String id;
    private String user_account;
    private String user_name;
    private String name;
    private String specification;
    private String unit;
    private Double amount;
    private Date time;
    private Date completion_time;
    private String status;

    public FormForDisplay(Return_form f, String user_account, String user_name, String name, String specification, String unit) {
        this.unit = unit;
        this.user_account = user_account;
        this.user_name = user_name;
        this.name = name;
        this.specification = specification;
        this.id = f.getId();
        this.amount = f.getAmount();
        this.time = f.getTime();
        this.completion_time = f.getCompletion_time();
        if(f.getStatus()) {
            this.status = "已退货";
        } else {
            this.status = "已申请";
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getCompletion_time() {
        return completion_time;
    }

    public void setCompletion_time(Date completion_time) {
        this.completion_time = completion_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

@Controller

public class MessageSearchController {
    @Autowired
    Purchase_informationRepository purchase_informationRepository;
    @Autowired
    Purchase_requisitionRepository purchase_requisitionRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    Purchase_orderRepository purchase_orderRepository;
    @Autowired
    SupplierRepsitory supplierRepsitory;
    @Autowired
    Comparison_listRepository comparison_listRepository;
    @Autowired
    Purchasable_productRepository purchasable_productRepository;
    @Autowired
    Return_formRepository return_formRepository;

    @RequestMapping(value={"/messagesearch"})
    public ModelAndView getInformation(@RequestParam("type") String type) {
        ModelAndView modelAndView = new ModelAndView();

        if(type.equals("inf")) { //显示采购信息
            List<Purchase_information> purchase_informations = purchase_informationRepository.findAll();
            List<InformationForDisplay> informationForDisplays = new ArrayList<>();
            for(Purchase_information e : purchase_informations) {
                informationForDisplays.add(new InformationForDisplay(e));
            }
            modelAndView.addObject("informationForDisplays", informationForDisplays);
            modelAndView.setViewName("ShowPurchaseInformation");

        }
        else if(type.equals("req")) { //显示采购申请
            List<Purchase_requisition> purchase_requisitions = purchase_requisitionRepository.findAll();
            List<RequisitionForDisplay> requisitionForDisplays = new ArrayList<>();
            for(Purchase_requisition e : purchase_requisitions) {
                User user = userRepository.getById(e.getPlanner_id());
                requisitionForDisplays.add(new RequisitionForDisplay(e.getId(), e.getType(), e.getDatetime(), user.getAccount(), user.getName()));
            }
            modelAndView.addObject("requisitionForDisplays", requisitionForDisplays);
            modelAndView.setViewName("ShowPurchaseRequisition");

        }
        else if(type.equals("ord")) { //显示采购单
            List<Purchase_order> purchase_orders = purchase_orderRepository.findAll();
            List<OrderForDisplay> orderForDisplays = new ArrayList<>();
            for(Purchase_order e : purchase_orders) {
                if(e.getPurchaser_id() == 0)
                    continue;
                if(e.getSupplier_id() == 0)
                    continue;
                User user = userRepository.getById(e.getPurchaser_id());
                Supplier supplier = supplierRepsitory.getById(e.getSupplier_id());
                orderForDisplays.add(new OrderForDisplay(e, supplier.getName(), user.getAccount(), user.getName()));
            }
            modelAndView.addObject("orderForDisplays", orderForDisplays);
            modelAndView.setViewName("ShowPurchaseOrder");

        }
        else if(type.equals("cmp")) { //显示比价单
            List<Comparison_list> comparison_lists = comparison_listRepository.findAll();
            List<ListForDisplay> listForDisplays = new ArrayList<>();
            for(Comparison_list e : comparison_lists) {
                String name = "";
                String s1 = "无";
                String s2 = "无";
                String s3 = "无";
                double p1 = 0;
                double p2 = 0;
                double p3 = 0;
                if(e.getSupplier_amount() > 0) {
                    Purchasable_product product = purchasable_productRepository.getById(e.getProduct_id1());
                    name = product.getName();
                    p1 = product.getPrice();
                    s1 = supplierRepsitory.getById(product.getSupplier_id()).getName();
                }
                if(e.getSupplier_amount() > 1) {
                    Purchasable_product product = purchasable_productRepository.getById(e.getProduct_id2());
                    p2 = product.getPrice();
                    s2 = supplierRepsitory.getById(product.getSupplier_id()).getName();
                }
                if(e.getSupplier_amount() > 2) {
                    Purchasable_product product = purchasable_productRepository.getById(e.getProduct_id3());
                    p3 = product.getPrice();
                    s3 = supplierRepsitory.getById(product.getSupplier_id()).getName();
                }
                listForDisplays.add(new ListForDisplay(e, name, s1, p1, s2, p2, s3, p3));
            }
            modelAndView.addObject("listForDisplays", listForDisplays);
            modelAndView.setViewName("showComparison_list");
        }
        else if(type.equals("ret")) { //显示退货单
            List<Return_form> return_forms = return_formRepository.findAll();
            List<FormForDisplay> formForDisplays = new ArrayList<>();
            for(Return_form e : return_forms) {
                User user = userRepository.getById(e.getInventory_id());
                Purchasable_product product = purchasable_productRepository.getById(e.getProduct_id());
                formForDisplays.add(new FormForDisplay(e, user.getAccount(), user.getName(), product.getName(), product.getSpecification(), product.getUnit()));
            }
            modelAndView.addObject("formForDisplays", formForDisplays);
            modelAndView.setViewName("ShowReturnForm");
        }

        return modelAndView;
    }

}
