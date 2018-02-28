package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ssm.pojo.*;
import com.ssm.service.AddUserService;
import com.ssm.service.IndexService;
import com.ssm.utils.Add_Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dist")
public class IndexController {
    @Autowired
    private IndexService indexService;
    @Autowired
    private AddUserService addUserService;
    /*
* 给用户id
* */
    @RequestMapping("/index_getUserId.htm")
    @ResponseBody
    public String getUserId(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        Object user_id = session.getAttribute("user_id");
        System.out.println(user_id);
        JSONObject jsonObject = new JSONObject();
        if(null!=user_id){
            jsonObject.put("user_id",user_id);
        }else{
            jsonObject.put("user_id",-1);
        }
        return jsonObject.toString();
    }
/*
*得到大类的信息
* */
    @RequestMapping("/index_kind_max.htm")
    @ResponseBody
    public void getMaxMessage(HttpServletRequest request, HttpServletResponse response){
        try {
            response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
            response.setHeader("Access-Control-Allow-Credentials","true");
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            List<Kinds> maxMessage = indexService.getMaxMessage();
            String s = JSON.toJSONString(maxMessage);
            PrintWriter printWriter = response.getWriter();
            printWriter.write(s);
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
/*
*根据前端传来的大类信息，查询相应的小类的信息，包括小类的照片,id,小类名字
* */
    @RequestMapping("/index_kind_max2.htm")
    @ResponseBody
    public String get_kind_message(@RequestParam("name") String max_name,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials","true");
        System.out.println(max_name);
        List<Kinds> kindMin = indexService.getKindMin(max_name);
        return  JSONObject.toJSONString(kindMin);
    }

/*
* 得到热销商品
* */
    @RequestMapping("/index_kind_max3.htm")
    @ResponseBody
    public String get_host_goods(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials","true");
        List<Pro_shop> host_goods = indexService.get_host_goods();
        String s = JSONObject.toJSONString(host_goods);
        System.out.println(s);
        return s;
    }
/*
* 得到品牌的照片,id
* */
    @RequestMapping("/index_kind_brands.htm")
    @ResponseBody
    public String get_brands(HttpServletResponse response){
        System.out.println("品牌");
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials","true");
        List<Brands> brands = indexService.get_brands();
        String s = JSONObject.toJSONString(brands);
        System.out.println(s);
        return s;
    }
/*
*得到轮播图的信息，包括照片，id
*/
    @RequestMapping("/index_kind_get_slideshow.htm")
    @ResponseBody
    public String get_slideshow(HttpServletResponse response){
        System.out.println("ssssssss");
//        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
//        response.setHeader("Access-Control-Allow-Credentials","true");
        List<Active> slideshow = indexService.get_slideshow();
        String s = JSON.toJSONString(slideshow);
        System.out.println(s);
        return s;
    }

    @RequestMapping("/check.htm")
    @ResponseBody
    public void check_username(@RequestParam("username") String user_name,HttpServletResponse response){
        System.out.println("username:"+user_name);
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials","true");
        PrintWriter writer =null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = addUserService.check_user(user_name);
        if(i==1){
            writer.write("false");
        }else {
            writer.write("true");
        }

        writer.close();
    }

    @RequestMapping(value = "/register.htm",method = RequestMethod.POST)
    @ResponseBody
    public void register_user(@RequestParam(value = "file",required=false)MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        System.out.println("jinru");
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials","true");
        String user_name = request.getParameter("u1");
        String user_card = request.getParameter("u2");
        int sex = request.getParameter("sex").equals("男") ? 1 : 0;
        String user_email = request.getParameter("u4");
        String user_tel = request.getParameter("u5");
        String user_password = request.getParameter("u6");
        Users users = new Users();
        users.setUser_name(user_name);
        users.setUser_password(user_password);
        users.setUser_email(user_email);
        users.setUser_sex(sex);
        users.setUser_card(user_card);
        users.setUser_tel(user_tel);
        System.out.println("用户信息0："+users.toString());
        String user_photo="http://ozxb0em6i.bkt.clouddn.com/rein.jpg";
        if(null!=file && !file.isEmpty()){
            try {
                int i = Add_Picture.addPic(file.getInputStream(), file.getOriginalFilename());
                if(i==1){
                    user_photo="http://ozxb0em6i.bkt.clouddn.com/"+file.getOriginalFilename();
                }

                System.out.println("照片上传成功"+user_photo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        users.setUser_photo(user_photo);
        System.out.println("用户信息："+users.toString());
        try {
            PrintWriter pw = response.getWriter();
            int i = addUserService.insert_user(users);
            if(i==1){
                System.out.println("状态:true");
                pw.write("true");
            }else {
                System.out.println("状态:false");
                pw.write("false");
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}