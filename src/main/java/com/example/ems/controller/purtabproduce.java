package com.example.ems.controller;

import com.example.ems.entity.Comparison_list;
import com.example.ems.entity.Purchase_information;
import com.example.ems.entity.Purchase_order;
import com.example.ems.entity.User;
import com.example.ems.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Column;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
class caigou{
    private String cpname;
    private  String gg;
    private String gysname;
    private double  sl;
    private double dj;
    private  String jldw;
    private String bjdid;
    private  String cjxxid;
    private int gysid;

    public caigou(String cpname, String gg, String gysname, double sl, double dj, String jldw, String bjdid, String cjxxid, int gysid) {
        this.cpname = cpname;
        this.gg = gg;
        this.gysname = gysname;
        this.sl = sl;
        this.dj = dj;
        this.jldw = jldw;
        this.bjdid = bjdid;
        this.cjxxid = cjxxid;
        this.gysid = gysid;
    }

    public String getBjdid() {
        return bjdid;
    }

    public void setBjdid(String bjdid) {
        this.bjdid = bjdid;
    }

    public String getCjxxid() {
        return cjxxid;
    }

    public void setCjxxid(String cjxxid) {
        this.cjxxid = cjxxid;
    }

    public int getGysid() {
        return gysid;
    }

    public void setGysid(int gysid) {
        this.gysid = gysid;
    }

    public String getCpname() {
        return cpname;
    }

    public void setCpname(String cpname) {
        this.cpname = cpname;
    }

    public String getGg() {
        return gg;
    }

    public void setGg(String gg) {
        this.gg = gg;
    }

    public String getGysname() {
        return gysname;
    }

    public void setGysname(String gysname) {
        this.gysname = gysname;
    }

    public double getSl() {
        return sl;
    }

    public void setSl(double sl) {
        this.sl = sl;
    }

    public double getDj() {
        return dj;
    }

    public void setDj(double dj) {
        this.dj = dj;
    }

    public String getJldw() {
        return jldw;
    }

    public void setJldw(String jldw) {
        this.jldw = jldw;
    }

    public caigou(String cpname, String gg, String gysname, int sl, int dj, String jldw) {
        this.cpname = cpname;
        this.gg = gg;
        this.gysname = gysname;
        this.sl = sl;
        this.dj = dj;
        this.jldw = jldw;
    }

    public caigou(String cpname) {
        this.cpname = cpname;
    }

    public caigou() {
    }
}
class searchtable{
    private String id;
    private Date time;
    private int purchaser_id;
    private Date  completion_time;
    private String  material;
    private int evaluation;
    private int supplier_id;
    private String status;
    String information_id;

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

    public int getPurchaser_id() {
        return purchaser_id;
    }

    public void setPurchaser_id(int purchaser_id) {
        this.purchaser_id = purchaser_id;
    }

    public Date getCompletion_time() {
        return completion_time;
    }

    public void setCompletion_time(Date completion_time) {
        this.completion_time = completion_time;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
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

    public searchtable() {
    }

    public searchtable(String id, Date time, int purchaser_id, Date completion_time, String material, int evaluation, int supplier_id, String status, String information_id) {
        this.id = id;
        this.time = time;
        this.purchaser_id = purchaser_id;
        this.completion_time = completion_time;
        this.material = material;
        this.evaluation = evaluation;
        this.supplier_id = supplier_id;
        this.status = status;
        this.information_id = information_id;
    }
}
@Controller
public class purtabproduce {
    @Autowired
    UserRepository user;
    @Autowired
    Comparison_listRepository a;
    @Autowired
    Purchase_orderRepository b;
    @Autowired
    Purchase_informationRepository c;
    @Autowired
    SupplierRepsitory d;
    @Autowired
    Purchasable_productRepository e;
    @Autowired
    Purchase_orderRepository f;
    @RequestMapping("/purtabproduce")
    public ModelAndView produce(HttpServletRequest st1){
        ModelAndView modelAndView = new ModelAndView();
        List<Comparison_list> laa= a.findAll();
        List<Comparison_list> la=new ArrayList<Comparison_list>();
        for(Comparison_list a1:laa){
            if(a1.getStatus()==0) {
                la.add(a1);
                System.out.println(a1.getId());
            }
        }
        List<caigou> la1=new ArrayList<caigou>();
        for(Comparison_list a3:la){
            caigou a2=new caigou();
            System.out.println(a3.getId());
            a2.setBjdid(a3.getId());
            String cpid=a3.getInformation_id();//采购信息id
            a2.setCjxxid(cpid);
            a2.setCpname(c.getById(cpid).getName());
            a2.setGg(c.getById(cpid).getSpecification());
            a2.setSl(c.getById(cpid).getAmount());
            int cid=a3.getProduct_id1();//产品id
            a2.setDj(e.getById(cid).getPrice());
            a2.setJldw(e.getById(cid).getUnit());
            int gysid=e.getById(cid).getSupplier_id();
            a2.setGysid(gysid);
            a2.setGysname(d.getById(gysid).getName());
            la1.add(a2);
        }
        for(caigou a4:la1){
            System.out.println(a4.getBjdid());
        }
        modelAndView.addObject("comparison",la1);
        modelAndView.setViewName("purtabproduce.html");
        return modelAndView;
    }
    @RequestMapping("/produce")
    public String pro(HttpServletRequest st2){
        ModelAndView modelAndView=new ModelAndView();
        String cpname=st2.getParameter("cpname");
        String gg=st2.getParameter("gg");
        String gysname=st2.getParameter("gysname");
        String  sl=st2.getParameter("sl");
        String dj=st2.getParameter("dj");
        String jldw=st2.getParameter("jldw");
        String select=st2.getParameter("select");
        String bjdid=st2.getParameter("bjdid");
        String gysid=st2.getParameter("gysid");
        String cgxxid=st2.getParameter("cgxxid");
        Purchase_order f1= new Purchase_order();
        Comparison_list op=a.getById(bjdid);
        op.setStatus(1);
        a.save(op);
        Date date=new Date();
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
        List<User> list=user.findAll();
        int userid=0;
        for(User li:list){
            if(li.getAccount().equals(s5))
                userid=li.getId();
        }
        f1.setId(s+s5);
        f1.setPurchaser_id(userid);
        f1.setSupplier_id(Integer.valueOf(gysid));
        f1.setStatus(0);
        if(select.equals("1"))
            f1.setMaterial(true);
        else
            f1.setMaterial(false);
        f1.setTime(date);
        f1.setInformation_id(cgxxid);
        f.save(f1);
        modelAndView.setViewName("purtabproduce");
        return "redirect:/purtabproduce";
    }
    @RequestMapping("/purtabsearch")
    public ModelAndView search(HttpServletRequest st3){
        ModelAndView modelAndView=new ModelAndView();
        List<Purchase_order> lf=f.findAll();
        List<searchtable> list=new ArrayList<searchtable>();
        for(Purchase_order f1:lf){
            searchtable li=new searchtable();
            li.setId(f1.getId());
            li.setEvaluation(f1.getEvaluation());
            li.setInformation_id(f1.getInformation_id());
            li.setCompletion_time(f1.getCompletion_time());
            li.setPurchaser_id(f1.getPurchaser_id());
            li.setSupplier_id(f1.getSupplier_id());
            li.setTime(f1.getTime());
            if(f1.getMaterial()==true){
                li.setMaterial("是");
            }
            else
                li.setMaterial("否");
            if(f1.getStatus()==0)
                li.setStatus("未开始");
            else if(f1.getStatus()==1)
                li.setStatus("未完成");
            else
                li.setStatus("已完成");
            list.add(li);
        }
        modelAndView.addObject("search",list);
        modelAndView.setViewName("purtabsearch");
        return modelAndView;
    }
    @RequestMapping("/search")
    public String search2(HttpServletRequest st4){
        ModelAndView modelAndView=new ModelAndView();
        String id=st4.getParameter("id");
        String status=st4.getParameter("status");
        String evaluation=st4.getParameter("evaluation");
        //List<Purchase_order> list=f.findAll();
        Purchase_order y=f.getById(id);
        if(status.equals("1")) {
            y.setStatus(1);
            y.setCompletion_time(null);
        }
        else if(status.equals("0")) {
            y.setStatus(0);
            y.setCompletion_time(null);
        }
        else{
            y.setStatus(2);
            Date date = new Date();
            y.setCompletion_time(date);
        }
        y.setEvaluation(Integer.valueOf(evaluation));
        f.save(y);
        // modelAndView.setViewName("purtabsearch");
        return "redirect:/purtabsearch";
    }
}
