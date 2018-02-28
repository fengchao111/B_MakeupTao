
package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ssm.po.collectInfo;
import com.ssm.po.feetInfo;
import com.ssm.po.infomix;
import com.ssm.po.usermanager;
import com.ssm.pojo.Address;
import com.ssm.pojo.Userinfo;
import com.ssm.pojo.Users;
import com.ssm.service.RegestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/dist")
public class RegestController {
    @Autowired
    private RegestService regestService;

    /**
     * @return
     */
    @RequestMapping(value = "/toregest.htm",method = RequestMethod.POST)
    public @ResponseBody String toregest(){
        return "/WEB-INF/page/regest.html";
    }
    /**
     * 用来验证用户名是否存在，打印出来
     */
    @RequestMapping(value = "/yanzheng.htm")
    public void selectUsername(){
        String username="hahahah";
        Boolean state=regestService.selectByName("username");
        System.out.println(state);
    }

    /**
     * 传入的用户名和密码来判断是否正确
     * 登录以后需要用户的user_id存入session中
     */
    @RequestMapping(value = "/denglu.htm")
    @ResponseBody
    public void login(HttpServletRequest request,HttpServletResponse response){
        System.out.println("denglu");
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials","true");
        PrintWriter out=null;
        String user_name=request.getParameter("username");
        String user_password=request.getParameter("password");
        System.out.println("user_name:"+user_name);
        System.out.println("user_password:"+user_password);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("test/html;charset=UTF-8");
        Boolean state = regestService.selectName(user_name,user_password);
        System.out.println("state:"+state);
        int user_id  = regestService.selectuserid(user_name);
        System.out.println(user_id);
        if(state){
            request.getSession().setAttribute("user_id",user_id);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user_id",user_id);
        jsonObject.put("state",state);
        try{
            out=response.getWriter();
            out.print(jsonObject.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }

    //xu显示个人资料
    @RequestMapping("/gerenziliao.htm")
    @ResponseBody
    public void selectInfo(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials","true");
        String user_id=(String)request.getSession().getAttribute("user_id");
        int userid=Integer.parseInt(user_id);
        System.out.print(user_id);
        infomix infoMix =regestService.selectinfo(userid);
        System.out.print(infoMix);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("test/html;charset=UTF-8");
        PrintWriter out=null;
        try{
            out=response.getWriter();
            String s= JSON.toJSONString(infoMix);
            System.out.print(s);
            out.print(s);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            out.close();
        }
        String s = JSON.toJSONString(infoMix);
        System.out.println(s);
    }

    //xu更新个人信息
    @RequestMapping("/gexinxinxi.htm")
    public void insertInfo(){
        Userinfo userinfo = new Userinfo();
        userinfo.setUser_id(2);
        userinfo.setUserinfo_bir(new java.sql.Date(1996-12-2));
        userinfo.setUserinfo_nickname("ninini");
        userinfo.setUserinfo_sign("i will be better");
        regestService.insertInfo(userinfo);
        System.out.println("插入成功！");
    }

    //xu
    @RequestMapping("/shoucang.htm")
    public void collect(){
        int user_id=2;
        List<collectInfo> list= regestService.collect(user_id);
        for (collectInfo collect:list) {
            System.out.println(collect.getPro_shop_desc()+"  "+collect.getPro_shop_pic()+"  "+collect.getPro_shop_price()+"   "+collect.getPro_shop_time());
        }
    }

    //zhang
    @RequestMapping("/dizhi.htm")
    public void address(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials","true");
        PrintWriter out=null;
        String user_id=(String)request.getSession().getAttribute("user_id");
        System.out.println(user_id);
        int user=Integer.parseInt(user_id);
        List<Address> list = regestService.address(user);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("test/html;charset=UTF-8");
        try{
            out=response.getWriter();
            String s= JSON.toJSONString(list);
            out.print(s);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            out.close();
        }
        for (Address address: list) {
            System.out.println(address);
        }
    }

    //xu
    @RequestMapping("/zuji.htm")
    @ResponseBody
    public void feet(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials","true");
        System.out.print("进入");
        PrintWriter out=null;
        String user_id=(String)request.getSession().getAttribute("user_id");
        System.out.println(user_id);
        int user=Integer.parseInt(user_id);
        ArrayList<feetInfo> list = regestService.feet(user);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("test/html;charset=UTF-8");
        try{
            out=response.getWriter();
            String s= JSON.toJSONString(list);
            out.print(s);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            out.close();
        }
    }

    //zhang
    @RequestMapping("/gaimorendizhi.htm")
    public void updateDefaultAddress(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials","true");
        String user_id=(String)request.getSession().getAttribute("user_id");
        String address_id=request.getParameter("address_id");
        int user=Integer.parseInt(user_id);
        int addressid=Integer.parseInt(address_id);
        Address address=new Address();
        address.setUser_id(user);
        address.setAddress_id(addressid);
        regestService.defaultAddress(address);
        System.out.println("ok!");
    }

    //xu
    @RequestMapping("/gaitel.htm")
    @ResponseBody
    public void updateTel(HttpServletRequest request,HttpServletResponse response){
        System.out.println("adsasdas");
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials","true");
        String user_id=(String)request.getSession().getAttribute("user_id");
        String user_tel=request.getParameter("phone");
        System.out.println("电话："+user_tel);
        int userid=Integer.parseInt(user_id);
        Users users = new Users();
        users.setUser_id(userid);
        users.setUser_tel(user_tel);
        System.out.println(users.toString());
        regestService.updateTel(users);
        System.out.println("ok1!");
        try {
            response.getWriter().write("true");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //xu
    @RequestMapping("/gaimima.htm")
    public void updatePass(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials","true");
        String user_id=(String)request.getSession().getAttribute("user_id");
        String new_password=request.getParameter("new_password");
        String old_password=request.getParameter("old_password");
        System.out.println(user_id+" "+new_password+" "+old_password);
        int userid=Integer.parseInt(user_id);
        Users users = new Users();
        users.setUser_id(userid);
        users.setUser_password(old_password);
        System.out.println(users.toString());
        Boolean aBoolean = regestService.updatePass(users, new_password);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(aBoolean){
            writer.write("true");
        }else{
            writer.write("false");
        }
        System.out.println("ok2!");
    }

    //xu
    @RequestMapping("/gerenguanli.htm")
    public void selectManager(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials","true");
        String user_id=(String)request.getSession().getAttribute("user_id");
        int userid=Integer.parseInt(user_id);
        System.out.println(userid);
        usermanager manager=regestService.selectManager(userid);
        PrintWriter pw=null;
        try{
            pw=response.getWriter();
            String userManager=JSON.toJSONString(manager);
            pw.write(userManager);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //zhang
    @RequestMapping("/jiadizhi.htm")
    public void insertAddress(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials","true");
        Address address=new Address();
        String user_id=(String)request.getSession().getAttribute("user_id");
        String address_name=request.getParameter("address_name");
        String address_tel=request.getParameter("address_tel");
        String address_add=request.getParameter("address_add");
        int userid=Integer.parseInt(user_id);
        address.setAddress_add(address_add);
        address.setAddress_tel(address_tel);
        address.setUser_id(userid);
        address.setAddress_name(address_name);
        regestService.insertAddress(address);
        System.out.println("OK!");
    }
}
