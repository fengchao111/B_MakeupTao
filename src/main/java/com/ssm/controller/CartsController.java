package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.ssm.pojo.Carts;
import com.ssm.service.CartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
//查询所有商品
public class CartsController {
    @Autowired
    private CartsService cartsService;

//    @RequestMapping("/gouwuche.htm")
//    public String tocart() {
//        return "WEB-INF/page/Cart.jsp";
//    }
//    @RequestMapping("/carts.htm")
//    public String cart1(HttpServletRequest request, HttpServletResponse response) {
//        List<Carts> lists = cartsService.selectAll();
//        response.setHeader("Access-Control-Allow-Origin", "http://192.168.0.183:8081");
//        response.setHeader("Assess-Control-Allow-Credentials","true");
//        String s=null;
//        try {
//            request.setCharacterEncoding("utf-8");
//            response.setContentType("text/html;charset=utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//             s=JSON.toJSONString(lists);
//            System.out.println(s);
//
//        String str=" {\"data\": [{\"pro_shop_pic\": \"1.jpg\",\"pro_shop_price\":\"23.2\",\"cart_num\": \"2\",\"pro_shop_desc\": \"商品描述\",\"pro_shop_spec\": \"商品规格\"},{\"pro_shop_pic\": \"2.jpg\",\"pro_shop_price\": \"212\",\"cart_num\": \"3\",\"pro_shop_desc\": \"商品描述\",\"pro_shop_spec\": \"商品规格\"},{\"pro_shop_pic\": \"3.jpg\",\"pro_shop_price\": \"27.2\",\"cart_num\":\"1\",\"pro_shop_desc\": \"商品描述\",\"pro_shop_spec\": \"商品规格\"}]}\n" +
//                "\n ";
//        return s;
//
//
//    }
//

    //1.自定义类型
//        Carts c=new Carts();
//        c.setUser_id(3);
//        c.setPro_shop_id(31);
//        c.setCart_num(5888888);
//        cartsService.addCarts(c);
//        System.out.println(c.toString());
//        return "WEB-INF/page/Cart.jsp";

    //2.从本地json获取资源
    //    @RequestMapping("/success.htm")
//    public String addCarts(HttpServletRequest request, HttpServletResponse response) {
//        String jsonstr = "{\"user_id\": \"3\",\"pro_shop_id\": \"7\",\"cart_num\": \"2\"}";
//        Carts carts = new JSONObject().parseObject(jsonstr, Carts.class);
//        System.out.println(carts.toString());
//        cartsService.addCarts(carts);
//
//        return "WEB-INF/page/successjsp.jsp";
//    }

//    @RequestMapping("/success1.htm")
//    public String nativeCarts(HttpServletRequest request, HttpServletResponse response) {
//        String jsonstr = "{\"user_id\": \"3\",\"pro_shop_id\": \"7\",\"cart_num\": \"2\"}";
//        Carts carts = new JSONObject().parseObject(jsonstr, Carts.class);
//
//        cartsService.addCarts(carts);
//        System.out.println(carts.toString());
//        return "WEB-INF/page/successjsp.jsp";
//    }

//3.从前端获取json数据
    @ResponseBody
    @RequestMapping(value="/success.htm",method = RequestMethod.POST)
    public String addCarts(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials","true");
        System.out.println("success");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");
        String user_id=request.getParameter("user_id");
        String pro_shop_id=request.getParameter("pro_shop_id");
        String cart_num=request.getParameter("cart_num");
        System.out.println(user_id+"--"+pro_shop_id+"--"+cart_num);
        Object object=request.getSession().getAttribute("user_id");
        if(object==null){
            return null;
        }
        String id=object.toString();
        int i=Integer.parseInt(user_id);
        int j=Integer.parseInt(pro_shop_id);
        int k=Integer.parseInt(cart_num);

        Carts cart=new Carts();

        //判断购物车中有没有一样的商品
        List<Carts> list = cartsService.selectAll();
        int tag=0;
        for (Carts l : list) {
            if(l.getUser_id()==i&&l.getPro_shop_id()==j){
                System.out.println("发现相同的商品");

                //修改商品的数量
                System.out.println(i);
                System.out.println(j);
                cart.setPro_shop_id(j);
                cart.setUser_id(i);
                cart.setCart_num(k);
                cartsService.updataNum(cart);
                System.out.println("修改成功");
                tag=1;
//                carts.setUser_id(l.getUser_id());
//                carts.setPro_shop_id(l.getPro_shop_id());
//                cartsService.updataNum();
//                System.out.println("修改数量Test");
//               tag=1;
            }
        }
        if(tag==0) {
           Carts carts= new Carts();
            carts.setUser_id(i);
            carts.setPro_shop_id(j);
            carts.setCart_num(k);
            cartsService.addCarts(carts);
        }
        return id;
    }

    //修改购物车中的商品数量
    @ResponseBody
    @RequestMapping(value="/updateNum.htm",method = RequestMethod.POST)
    public  String updateNum(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        response.setHeader("Access-Control-Allow-Origin", "http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials","true");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
    String user_id=request.getParameter("user_id");
    System.out.println(user_id);
    String pro_shop_id= request.getParameter("pro_shop_id");
    String cart_num=request.getParameter("cart_num");
    System.out.println(user_id+"----"+pro_shop_id+"---"+cart_num);
    int user=Integer.parseInt(user_id);
    int pro=Integer.parseInt(pro_shop_id);
    int num=Integer.parseInt(cart_num);
    System.out.println("cart_num ="+cart_num);
    Carts carts1=new Carts();
    carts1.setUser_id(user);
    carts1.setPro_shop_id(pro);
    carts1.setCart_num(num);
    cartsService.updateNum(carts1);
    System.out.println("修改数量成功");


        return null;
    }
    //传递给前端所需要的购物车信息
    @ResponseBody
    @RequestMapping("/selectCarts.htm")
    public String  selectCarts(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
//        String id=request.getParameter("user_id");
//        Pro_shop pro_shop=new Pro_shop();
//
//        System.out.println(pro_shop.getPro_shop_desc());
//        Carts carts=new Carts();
//
//        int i=Integer.parseInt(id);
////        carts.setUser_id(i);
//        System.out.println(i);
//        List<Carts> carts2=cartsService.selectCarts();
//        System.out.println("ok");
//
//            System.out.println(carts2);
        response.setHeader("Access-Control-Allow-Origin", "http://192.168.0.101:8080");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

//
//        int user_id = 1;
//        request.getSession().setAttribute("user_id", user_id);
        String id = request.getSession().getAttribute("user_id").toString();
        System.out.println(id);
        if (id != null) {
            int i = Integer.parseInt(id);
            Carts carts2 = new Carts();
            carts2.setUser_id(i);
            System.out.println(i);
            List<Carts> carts = cartsService.selectCarts(carts2);
            String s = JSON.toJSONString(carts);
            //        List<Address> addresses=cartsService.selectAddress(i);
            //        String address=JSON.toJSONString(addresses);
            //        StringBuffer t1=new StringBuffer(s);
            //        StringBuffer t2=new StringBuffer(address);
            //        t1.append(t2);
            //        String meg=t1.toString();
            System.out.println(s);
            return s;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/deleteCarts.htm")
    public void deleteCarts(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials","true");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String user_id=request.getParameter("user_id");
        String pro_shop_id=request.getParameter("pro_shop_id");
        int user=Integer.parseInt(user_id);
        int pro_shop=Integer.parseInt(pro_shop_id);
        Carts deletecart=new Carts();
        deletecart.setUser_id(user);
        deletecart.setPro_shop_id(pro_shop);
        cartsService.deleteCarts(deletecart);
        System.out.println("删除物品成功");
    }
    @RequestMapping("/selectOrders.htm")
    @ResponseBody
    public String selectOrders(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.200:8080");
        response.setHeader("Access-Control-Allow-Credentials","true");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//
//    int user_id=1;
//    request.getSession().setAttribute("user_id",user_id);
        String id=request.getSession().getAttribute("user_id").toString();
        if(id!=null) {
            int i = Integer.parseInt(id);
            Carts carts2 = new Carts();
            carts2.setUser_id(i);
            System.out.println(carts2.getUser_id());
            List<Carts> carts = cartsService.selectOrders(i);
            String p = JSON.toJSONString(carts);

            System.out.println(p);
            return p;
        }
        return  null;
    }

}


