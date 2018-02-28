package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ssm.pojo.Collect;
import com.ssm.pojo.Feet;
import com.ssm.pojo.Pro_shop;
import com.ssm.service.ProDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@Transactional
public class proDetailController {
@Autowired
    private ProDetailService proDetailService;
@RequestMapping("/detail.htm")
@ResponseBody
    public String testfindProDetail(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.200:8080");
        response.setHeader("Access-Control-Allow-Credentials","true");
        String pro_shop_id = request.getParameter("pro_shop_id");
        HttpSession session= request.getSession();
        int user_id=1;
        session.setAttribute("user_id",user_id);
        String m=request.getSession().getAttribute("user_id").toString();//从session中获取user_id
//        int t = Integer.parseInt(m);
//        System.out.println(t);
//        String coll = request.getParameter("ccc");

//         String s1 = JSONObject.toJSONString(user_id);
//        String s1 = JSON.toJSONString(user_id);
        System.out.println(pro_shop_id);//打印获取的pro_shop_id
//        System.out.println(s1);//打印获取的user_id
//        System.out.println(coll);
        int p = Integer.parseInt(pro_shop_id);
//        int u = Integer.parseInt(user_id);
//        int c = Integer.parseInt(coll);
        List<Pro_shop> list=proDetailService.findProDetail(p);
         System.out.println("--------------------");
        proDetailService.addlook1(p);   //调用增加浏览量方法，使数据库中浏览量加1

        String s= JSON.toJSONString(list);
        System.out.println(s);
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printWriter.write(s);

       if(null!=m){
            int u = Integer.parseInt(m);
            java.sql.Date feet_time = new java.sql.Date(System.currentTimeMillis());
            System.out.println(feet_time.toString());
            Feet feet = new Feet();
            feet.setUser_id(u);
            feet.setPro_shop_id(p);
            feet.setFeet_time(feet_time);
            proDetailService.insertIntoFeet(feet);
            System.out.println(feet);
       }else{
           try {
               printWriter = response.getWriter();
           } catch (IOException e) {
               e.printStackTrace();
           }
           printWriter.write(-1);
           printWriter.close();

       }
      return null;
    }

  @RequestMapping("/insertCollect.htm")
    @ResponseBody
    public void insertIntoCollect(HttpServletRequest request,HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.200:8080");
        response.setHeader("Access-Control-Allow-Credentials","true");
//        Integer pro_shop_id=(int)request.getAttribute("pro_shop-id");
      String pro_shop_id=request.getParameter("pro_shop_id");
      int p = Integer.parseInt(pro_shop_id);
      HttpSession session= request.getSession();
      int user_id=1;
      session.setAttribute("user_id",user_id);
      String m=request.getSession().getAttribute("user_id").toString();//从session中获取user_id
      if(null!=m)
      {
      int u = Integer.parseInt(m);

      String coll = request.getParameter("ccc");
      int c = Integer.parseInt(coll);
      System.out.println(c);

        Collect collect = new Collect();
        collect.setUser_id(u);
        collect.setPro_shop_id(p);
        if(c==3){
            proDetailService.insertIntoCollect(collect);
            System.out.println(collect);
        }else {

        }

      }else{
          PrintWriter printWriter=null;
          try {
              printWriter = response.getWriter();
          } catch (IOException e) {
              e.printStackTrace();
          }
          printWriter.write(-1);
          printWriter.close();

      }
  }

}




//    @RequestMapping("/insertFeet.htm")
//    @ResponseBody
//    public void insertIntoFeet(HttpServletRequest request, HttpServletResponse response){
//        response.setContentType("text/html;charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.200:8080");
//        response.setHeader("Access-Control-Allow-Credentials","true");
//
//        Integer user_id=(int)request.getAttribute("user_id");//从前端获取user_i
//        Integer pro_shop_id=(int)request.getAttribute("pro_shop_id");
//        java.sql.Date feet_time = new java.sql.Date(System.currentTimeMillis());
//        System.out.println(feet_time.toString());
//        Feet feet = new Feet();
//        feet.setUser_id(user_id);
//        feet.setPro_shop_id(pro_shop_id);
//        feet.setFeet_time(feet_time);
//
//        proDetailService.insertIntoFeet(feet);
//        System.out.println(feet);
//    }


