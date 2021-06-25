package com.example.ems.controller;

import com.example.ems.entity.Purchase_information;
import com.example.ems.entity.Purchase_requisition;
import com.example.ems.entity.User;
import com.example.ems.repository.Purchase_informationRepository;
import com.example.ems.repository.Purchase_requisitionRepository;
import com.example.ems.repository.UserRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

@Controller

public class MessageSearchController {
    @Autowired
    Purchase_informationRepository purchase_informationRepository;
    @Autowired
    Purchase_requisitionRepository purchase_requisitionRepository;
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value={"/messagesearch"})
    public ModelAndView getInformation(@RequestParam("type") String type) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(type);
        if(type.equals("inf")) {
            List<Purchase_information> purchase_informations = purchase_informationRepository.findAll();
            List<InformationForDisplay> informationForDisplays = new ArrayList<>();
            for(Purchase_information e : purchase_informations) {
                informationForDisplays.add(new InformationForDisplay(e));
            }
            modelAndView.addObject("informationForDisplays", informationForDisplays);
            modelAndView.setViewName("ShowPurchaseInformation");

        }
        else if(type.equals("req")) {
            List<Purchase_requisition> purchase_requisitions = purchase_requisitionRepository.findAll();
            List<RequisitionForDisplay> requisitionForDisplays = new ArrayList<>();
            for(Purchase_requisition e : purchase_requisitions) {
                User user = userRepository.getById(e.getPlanner_id());
                requisitionForDisplays.add(new RequisitionForDisplay(e.getId(), e.getType(), e.getDatetime(), user.getAccount(), user.getName()));
            }
            modelAndView.addObject("requisitionForDisplays", requisitionForDisplays);
            modelAndView.setViewName("ShowPurchaseRequisition");

        }
        else if(type.equals("ord")) {

        }
        else if(type.equals("cmp")) {

        }
        else if(type.equals("ret")) {

        }

        return modelAndView;
    }

}
