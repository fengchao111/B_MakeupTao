package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ssm.pojo.Orders;
import com.ssm.pojo.Pro_shop_order;
import com.ssm.pojo.Users;
import com.ssm.pojo.orderservice;
import com.ssm.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dist")
public class OrderController {

    @Autowired
    private UserOrderService userOrderService;




    @RequestMapping("/someOrder.htm")
    @ResponseBody
    public String toSomeOrder(HttpServletRequest request,HttpServletResponse response) {
        //解决跨域
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials","true");

        Users users = new Users();
        users.setUser_id(Integer.parseInt(request.getParameter("user_id")));
        users.setUser_sex(Integer.parseInt(request.getParameter("user_sex")));
        System.out.println(users.getUser_id()+"  "+users.getUser_sex());
        List<Orders> someOrders = userOrderService.querySomeOrder(users);
        String s = JSON.toJSONString(someOrders);
        System.out.println("----------------------------------");
        System.out.println(s);
        return s;
    }


    @RequestMapping("/orderDetails.htm")
    @ResponseBody
    public String toOrderDetails(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials","true");
        System.out.println(request.getParameter("order_id"));
        Orders orders = new Orders();
        orders.setOrder_id(Integer.parseInt((request.getParameter("order_id"))));
        System.out.println(orders.getOrder_id());
        List<Orders> details = userOrderService.queryOrderDetails(orders);
        System.out.println("details");

        String s = JSON.toJSONString(details);
        System.out.println(s);
        return s;
    }




    @RequestMapping("/cancleOrder.htm")
    @ResponseBody
    public String toCancleOrder(HttpServletRequest request,HttpServletResponse response){
        System.out.println("cancle");
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials","true");
        String cancle = request.getParameter("cancle_order_id");
        System.out.println(cancle);
        HashMap<String,Object> cancleMap;
        cancleMap=JSON.parseObject(cancle,new TypeReference<HashMap<String,Object>>() {});
        for(int i=0;i<cancleMap.size();i++){
            String ii= String.valueOf(i);
            System.out.println(cancleMap.get(ii));
            Orders orders = new Orders();
            orders.setOrder_id((Integer) cancleMap.get(ii));
            userOrderService.cancleOrder(orders);
        }

        System.out.println("cancleSuccess");
        return "cancle";
    }


    @RequestMapping("/sureOrder.htm")
    @ResponseBody
    public String toSureOrder(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials","true");
        Orders orders = new Orders();
        orders.setOrder_id(Integer.parseInt(request.getParameter("sure_order_id")));
        System.out.println(orders.getOrder_id());
        userOrderService.sureOrder(orders);
        System.out.println("sure");
        return "sure";
    }


    @RequestMapping("/deleteOrder.htm")
    @ResponseBody
    public String toDeleteOrder(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials","true");

        Orders orders = new Orders();
        orders.setOrder_id(Integer.parseInt(request.getParameter("delete_order_id")));
        userOrderService.deleteOrder(orders);
        System.out.println("delete");
        return "delete";
    }



    public UserOrderService getUserOrderService() {
        return userOrderService;
    }

    public void setUserOrderService(UserOrderService userOrderService) {
        this.userOrderService = userOrderService;
    }
}


