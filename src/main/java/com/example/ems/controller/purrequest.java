package com.example.ems.controller;

import com.example.ems.entity.Purchasable_product;
import com.example.ems.entity.Purchase_information;
import com.example.ems.entity.Purchase_requisition;
import com.example.ems.entity.User;
import com.example.ems.repository.Purchasable_productRepository;
import com.example.ems.repository.Purchase_informationRepository;
import com.example.ems.repository.Purchase_requisitionRepository;
import com.example.ems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class purrequest {
    @Autowired
    Purchasable_productRepository a;
    @Autowired
    Purchase_requisitionRepository b;
    @Autowired
    Purchase_informationRepository c;
    @Autowired
    UserRepository d;

    @RequestMapping("/purrequest")
    public ModelAndView pur(HttpServletRequest st1){
        List<Purchasable_product> a1=a.findAll();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("purproduct",a1);
        modelAndView.setViewName("purrequest.html");
        String s=st1.getParameter("count");
        if(s==null)
            return modelAndView;
        int count=Integer.valueOf(s);
        modelAndView.addObject("c", count+1);
//        modelAndView.addObject("purproduct",a1);
//        modelAndView.setViewName("purrequest.html");
        return modelAndView;
    }
    @RequestMapping("/caigoushenqing")
    public ModelAndView pur1(HttpServletRequest st2, Model mod){
        // String lx=st2.getParameter("lx");
        String mc1=st2.getParameter("mc1");
        String gg1=st2.getParameter("gg1");
        String sl1=st2.getParameter("sl1");
        String dw1=st2.getParameter("dw1");
        String mc2=st2.getParameter("mc2");
        String gg2=st2.getParameter("gg2");
        String sl2=st2.getParameter("sl2");
        String dw2=st2.getParameter("dw2");
        String mc3=st2.getParameter("mc3");
        String gg3=st2.getParameter("gg3");
        String sl3=st2.getParameter("sl3");
        String dw3=st2.getParameter("dw3");
        String mc4=st2.getParameter("mc4");
        String gg4=st2.getParameter("gg4");
        String sl4=st2.getParameter("sl4");
        String dw4=st2.getParameter("dw4");
        int count=0;
        Purchase_requisition b1=new Purchase_requisition();
        Purchase_information c1=new Purchase_information();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");// 格式化时间
        String s=sdf.format(date);
        Cookie cookie[]= st2.getCookies();
        int id1=0;
        String s5="";
        for(Cookie a:cookie){
            if(a!=null&&a.getName().equals("user_id")) {
                s5=a.getValue();
                id1 = Integer.valueOf(a.getValue());
            }
        }
        List<User> d1=d.findAll();
        int id=0;
        for(User d2:d1){
            if(d2.getAccount().equals(s5)){
                id=Integer.valueOf(d2.getId());
            }
        }
        if(sl1!="") {
            b1.setType(count);
            String s1="W"+s;
            b1.setId(s1);
            b1.setDatetime(date);
            b1.setPlanner_id(id);
            c1.setId(s1+s5);
            c1.setRequisition_id(s1);
            c1.setName(mc1);
            c1.setSpecification(gg1);
            c1.setUnit(dw1);
            c1.setAmount(Double.valueOf(sl1));
            c1.setStatus(0);
            count++;
            b.save(b1);
            c.save(c1);
        }
        if(sl2!="") {
            b1.setType(count);
            String s2="Z"+s;
            b1.setId(s2);
            b1.setDatetime(date);
            b1.setPlanner_id(id);
            c1.setId(s2+s5);
            c1.setRequisition_id(s2);
            c1.setName(mc2);
            c1.setSpecification(gg2);
            c1.setUnit(dw2);
            c1.setAmount(Double.valueOf(sl2));
            c1.setStatus(0);
            count++;
            b.save(b1);
            c.save(c1);
        }
        if(sl3!="") {
            b1.setType(count);
            String s3="P"+s;
            b1.setId(s3);
            b1.setDatetime(date);
            b1.setPlanner_id(id);
            c1.setId(s3+s5);
            c1.setRequisition_id(s3);
            c1.setName(mc3);
            c1.setSpecification(gg3);
            c1.setUnit(dw3);
            c1.setAmount(Double.valueOf(sl3));
            c1.setStatus(0);
            count++;
            b.save(b1);
            c.save(c1);
        }
        if(sl4!="") {
            b1.setType(count);
            String s4="Z"+s;
            b1.setId(s4);
            b1.setDatetime(date);
            b1.setPlanner_id(id);
            c1.setId(s4+s5);
            c1.setRequisition_id(s4);
            c1.setName(mc4);
            c1.setSpecification(gg4);
            c1.setUnit(dw4);
            c1.setAmount(Double.valueOf(sl4));
            c1.setStatus(0);
            count++;
            b.save(b1);
            c.save(c1);
        }
        mod.addAttribute("msg", count+1);
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.addObject("count",count);
        modelAndView.setViewName("redirect:/purrequest");
        // modelAndView.setViewName("forward:/purrequest.actiont");
        // return "purrequest";
        return modelAndView;

    }
}

