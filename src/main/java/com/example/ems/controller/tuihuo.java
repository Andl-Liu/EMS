package com.example.ems.controller;

import com.example.ems.entity.*;
import com.example.ems.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller

public class tuihuo {
    @Autowired
    Purchase_informationRepository a;
    @Autowired
    UserRepository b;
    @Autowired
    SupplierRepsitory c;
    @Autowired
    Purchasable_productRepository d;
    @Autowired
    Return_formRepository e;
    //@ResponseBody
    @RequestMapping("/wirttd")
    public ModelAndView writtd(HttpServletRequest st){
        String flag=st.getParameter("flag1");
        ModelAndView modelAndView = new ModelAndView();
        if(flag==null)
            return  modelAndView;
        else {
            if (flag.equals("1"))
                modelAndView.addObject("flag1", 1);
            else if (flag.equals("2"))
                modelAndView.addObject("flag1", 2);
            else if (flag.equals("3"))
                modelAndView.addObject("flag1", 3);
            modelAndView.setViewName("wirttd.html");
            return modelAndView;
        }
    }
    @RequestMapping("/tuihuo")
    public ModelAndView tuihuo(HttpServletRequest st1, Model model) {
      //  System.out.println("asdlfkjalskdfj");
        String cpm = st1.getParameter("cpm");
        String cpgg = st1.getParameter("cpgg");
        String cpsl = st1.getParameter("cpsl");
        String gys =  st1.getParameter("gys");
        String jldw = st1.getParameter("jldw");
        int flag1=1;
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("redirect:wirttd");
        if(cpm==""||cpgg==""||cpsl==""||gys==""||jldw=="") {
            flag1 = 2;
            modelAndView.addObject("flag1",flag1);
            model.addAttribute("flag1", flag1);
            return modelAndView;
           // return "redirect:wirttd.html";
        }
        List<Purchase_information> la=a.findAll();
        List<Supplier> lc=c.findAll();
        List<Purchasable_product> ld=d.findAll();
        Return_form h = new Return_form();
       // SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");// 格式化时间
        //sdf.applyPattern("yyMMddHHmmss");//
       // h.setTime(sdf.format(date));
        Date date = new Date();
//         Date date = new Date();          // 获取一个Date对象
//        DateTime timeStamp = new Timestamp(date.getTime());
        //String s=sdf.format(date);
        h.setTime(date);
        int sid=0,pid=0;
//        for (Purchase_information a1:la){
//            if(cpm== a1.getName()&&cpgg==a1.getSpecification()) {
//                pid=a1.getId();
//                break;
//            }
//        }
        for(Purchasable_product d1:ld){
            if(cpm.equals(d1.getName())&&cpgg.equals(d1.getSpecification())){
                pid= d1.getId();
                break;
            }
        }
//        for(Supplier c1:lc ){
//            if(gys.equals(c1.getName()))
//            {
//                sid=c1.getId();
//            }
//        }

        Cookie cookie[]= st1.getCookies();
        int id1=0;
        String s5="";
        for(Cookie a:cookie){
            if(a!=null&&a.getName().equals("user_id")) {
                s5=a.getValue();
                id1 = Integer.valueOf(a.getValue());
            }
        }
        List<User> lb=b.findAll();
        for(User b1:lb){
            if(s5.equals(b1.getAccount()))
                sid=b1.getId();
        }
        //sid=0001;
        int cid=0;
        for(Supplier c1:lc){
            if(c1.getName().equals(gys))
                cid=c1.getId();
        }
        if(sid==0||pid==0||cid==0){
            flag1 = 3;
            modelAndView.addObject("flag1",flag1);
            model.addAttribute("flag1", flag1);

           return modelAndView;
         //   return "redirect:wirttd.html";
        }
        h.setAmount(Double.valueOf(cpsl));
        h.setProduct_id(pid);
        h.setStatus(false);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");// 格式化时间
        String s=sdf.format(date);
        h.setId(s);
        h.setInventory_id(sid);
        e.save(h);
        modelAndView.addObject("flag1",flag1);
        model.addAttribute("flag1", flag1);
       // return "redirect:wirttd.html";
        return modelAndView;
    }

    @RequestMapping("/alttd")
    public String tuihuoxiuigai(HttpServletRequest st, Model model) {
        String cpm = st.getParameter("cpm");
        String cpgg = st.getParameter("cpgg");
        String cpsl = st.getParameter("cpsl");
        String gys =  st.getParameter("gys");
        String jldw = st.getParameter("jldw");
        List<Purchase_information> la=a.findAll();

        return "alttd.html";
    }

}
