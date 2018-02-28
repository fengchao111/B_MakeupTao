package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.ssm.pojo.Brands;
import com.ssm.pojo.Kinds;
import com.ssm.pojo.Pro_shop;
import com.ssm.pojo.Products;
import com.ssm.service.ProListService;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/dist")
public class ProListController {
    static int start=1;
    @Autowired
    private ProListService proListService;
    @RequestMapping(value="/proList.htm",method = RequestMethod.POST)
    @ResponseBody
    public String pro(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        String brand_name1 = request.getParameter("brand");
        String classify = request.getParameter("classify");
        String sort1 = request.getParameter("sort");
        System.out.println(brand_name1);
        System.out.println(classify);
        System.out.println(sort1);
        System.out.println("-------------------");
        //String brand_name="自然堂";
        if (!"null".equals(brand_name1))
        {
            System.out.println(1);
            String brand_name = request.getParameter("brand");
            List<Pro_shop> list3 = proListService.findProByBrand(brand_name);
            System.out.println(666);
            for(Pro_shop list:list3)
            {
                System.out.println(666);
                System.out.println(list3);
                String pro_shop_pic = list.getPro_shop_pic();
                System.out.println(pro_shop_pic);
                String substring = pro_shop_pic;
                System.out.println("..............");
                System.out.println(substring);
                System.out.println(999);
                list.setPro_shop_pic(substring);
            }

            System.out.println(list3);
            System.out.println(2);//根据品牌id查找对应商品
            String s3 = JSON.toJSONString(list3);
            System.out.println(3);
            PrintWriter printWriter=null;
                System.out.println(4);
            try {
                printWriter = response.getWriter();
                System.out.println(5);
            } catch (IOException e) {
                e.printStackTrace();
            }
                System.out.println(6);
            printWriter.write(s3);
                System.out.println(7);
            System.out.println(s3);
            printWriter.close();
                System.out.println("9");
    //            return s3;

        } else
        if (!"null".equals(classify))
        {
            System.out.println("111111111");
            int kind_id=Integer.parseInt(classify);
            System.out.println(kind_id);
            List<Pro_shop> list4 = proListService.findProByKindMin(kind_id);
            for(Pro_shop list:list4)
            {
                System.out.println(list4);
                String pro_shop_pic = list.getPro_shop_pic();
//                String substring = pro_shop_pic.substring(0, pro_shop_pic.indexOf(";"));//
                String substring = pro_shop_pic;
                System.out.println(substring);
                list.setPro_shop_pic(substring);
            }
            String s4 = JSON.toJSONString(list4);
            PrintWriter printWriter=null;
            try {
              printWriter = response.getWriter();
            } catch (IOException e) {
              e.printStackTrace();
           }
           printWriter.write(s4);
           printWriter.close();
//            return s4;
        } else
        if (!"null".equals(sort1))
        {
            System.out.println("=============");
//            String sort11 = request.getParameter("sort"); //点击哪个排序方法 传最近上市
//            String sort11="最近上市";
//            System.out.println(sort11);
//        String sort="111";

            if (sort1.equals("最近上市")) {
                List<Pro_shop> list7 = proListService.findProMarket();
                for(Pro_shop list:list7)
                {
                    System.out.println(list7);
                    String pro_shop_pic = list.getPro_shop_pic();
//                    String substring = pro_shop_pic.substring(0, pro_shop_pic.indexOf(";"));
                    String substring = pro_shop_pic;
                    System.out.println(substring);
                    list.setPro_shop_pic(substring);
                }
                String s = JSON.toJSONString(list7);
                System.out.println(s);
                PrintWriter printWriter=null;
                try {
                    printWriter = response.getWriter();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                printWriter.write(s);
                printWriter.close();

//                return s;
            } else
            if (sort1.equals("销量排序"))
            {
                List<Pro_shop> list8 = proListService.findProSale();
                for(Pro_shop list:list8)
                {
                    System.out.println(list8);
                    String pro_shop_pic = list.getPro_shop_pic();
//                    String substring = pro_shop_pic.substring(0, pro_shop_pic.indexOf(";"));
                    String substring = pro_shop_pic;
                    System.out.println(substring);
                    list.setPro_shop_pic(substring);
                }
                String s2 = JSON.toJSONString(list8);
                PrintWriter printWriter=null;
                try {
                    printWriter = response.getWriter();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                printWriter.write(s2);
                printWriter.close();

            } else
            if (sort1.equals("价格升序"))
            {
                List<Pro_shop> list5 = proListService.sortByPrice();
                for(Pro_shop list:list5)
                {
                    System.out.println(list5);
                    String pro_shop_pic = list.getPro_shop_pic();
//                    String substring = pro_shop_pic.substring(0, pro_shop_pic.indexOf(";"));
                    String substring = pro_shop_pic;
                    System.out.println(substring);
                    list.setPro_shop_pic(substring);
                }
                String s5 = JSON.toJSONString(list5);
                PrintWriter printWriter=null;
                try {
                    printWriter = response.getWriter();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                printWriter.write(s5);
                printWriter.close();
//                return s5;
            } else
            {
                List<Pro_shop> list6 = proListService.sortByPriced();
                for(Pro_shop list:list6)
                {
                    System.out.println(list6);
                    String pro_shop_pic = list.getPro_shop_pic();
//                    String substring = pro_shop_pic.substring(0, pro_shop_pic.indexOf(";"));
                    String substring = pro_shop_pic;
                    System.out.println(substring);
                    list.setPro_shop_pic(substring);
                }
                String s6 = JSON.toJSONString(list6);
                PrintWriter printWriter=null;
                try {
                    printWriter = response.getWriter();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                printWriter.write(s6);
                printWriter.close();
//                return s6;
            }


        } else {

        }
    return null;
    }
    @RequestMapping("/brand.htm")
    @ResponseBody
    public String brand(HttpServletRequest request,HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        List<Brands> list2=proListService.findBrand();//查出所有品牌的名字
        String s2= JSON.toJSONString(list2);
        PrintWriter printWriter = null;
        try {
        printWriter = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printWriter.write(s2);
        printWriter.close();
        System.out.println(s2+"000000000000000000000000");
        return s2;
    }
    @RequestMapping(value="/kind.htm",method = RequestMethod.POST)
    @ResponseBody
    public String kind(HttpServletRequest request,HttpServletResponse response){
        System.out.println("0000000000000");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        // List<Kinds> list = proListService.findKindMax();//找出所有大类名字
        //String s = JSON.toJSONString(list);
        System.out.println("大类名字-------");
        String kind = request.getParameter("kind_max");//根据大类名字查找对应小类
        //String kind="底妆";
        System.out.println(kind);
        System.out.println("kind1");
        List<Kinds> list1 = proListService.findKindMin(kind);
        System.out.println("kind2");
        String s1 = JSON.toJSONString(list1);
//        PrintWriter printWriter = null;
//         try {
//            printWriter = response.getWriter();
//         } catch (IOException e) {
//              e.printStackTrace();
//           }
//             printWriter.write(s1);
//             printWriter.close();

        return s1;
    }
    @RequestMapping("/load.htm")
    @ResponseBody
    //查出数据库有多少条商品信息，判断start增加到一定大时，数据库没有商品信息如何返回。
    public String load(HttpServletRequest request,HttpServletResponse response){
//        response.setContentType("text/html;charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "http://192.168.0.183" +
                ":8081");
        response.setHeader("Access-Control-Allow-Credentials", "true");
//         start++;
        List<Pro_shop> list1=proListService.findPage((start-1)*8);//分页方法
        for(Pro_shop list:list1)
        {
            System.out.println(list1);
            String pro_shop_pic = list.getPro_shop_pic();
//            String substring = pro_shop_pic.substring(0, pro_shop_pic.indexOf(";"));
            String substring = pro_shop_pic;
            System.out.println(substring);
            list.setPro_shop_pic(substring);
        }
        String s1 = JSON.toJSONString(list1);
        System.out.println(s1);
//        PrintWriter printWriter = null;
//        try {
//            printWriter = response.getWriter();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//      printWriter.write(s1);
        if(list1.size()==0) return null;
        return s1;
    }
}








//        String leiXing = request.getParameter("aaa");
//        if (leiXing.equals(null)) {
//            return null;
//        } else {
//            if (leiXing.equals("分类")) {
//                List<Kinds> list = proListService.findKindMax();//找出所有大类
//                String s = JSON.toJSONString(list);
//                System.out.println("大类名字-------");
//                String kind = request.getParameter("kind_max");//根据大类名字查找对应小类
//                //String kind="底妆";
//                List<Kinds> list1 = proListService.findKindMin(kind);
//                String s1 = JSON.toJSONString(list1);
//                PrintWriter printWriter = null;
//                try {
//                    printWriter = response.getWriter();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                printWriter.write(s1);
//                printWriter.close();
//
//            } else if (leiXing.equals("品牌")) {
//                List<Brands> list2=proListService.findBrand();//查出所有品牌的名字
//                String s2= JSON.toJSONString(list2);
//                PrintWriter printWriter = null;
//                try {
//                    printWriter = response.getWriter();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                printWriter.write(s2);
//                printWriter.close();
//
//                String brand_name = request.getParameter("brand_name");
////     String brand_name="自然堂";
//               List<Pro_shop> list3= proListService.findProByBrand(brand_name);//查出对应品牌下的商品
//               String s3 = JSON.toJSONString(list3);
//                try {
//                    printWriter = response.getWriter();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                printWriter.write(s2);
//                printWriter.close();
//
//            }else if(leiXing.equals("排序")){
//                String sort = request.getParameter("sort"); //点击哪个排序方法
//                System.out.println(sort);
////              String sort="111";
//                if (sort.equals("最近上市")) {
//                    List<Pro_shop> list4 = proListService.findProMarket();
//                    String s4 = JSON.toJSONString(list4);
//                    System.out.println(s4);
//                    return s4;
//                } else if (sort.equals("销量排序")) {
//                    List<Pro_shop> list5 = proListService.findProSale();
//                    String s5 = JSON.toJSONString(list5);
//                    return s5;
//                } else if (sort.equals("价格升序")) {
//                    List<Pro_shop> list6 = proListService.sortByPrice();
//                    String s6 = JSON.toJSONString(list6);
//                    return s6;
//                } else {
//                    List<Pro_shop> list7 = proListService.sortByPriced();
//                    String s7 = JSON.toJSONString(list7);
//                    return s7;
//                }
//
//
//            }else{
//
//            }
//        }
//        return null;
//    }
//}



//分页====================
////      int start=0;
////        String start = request.getParameter("bbb");
//
////        int m = Integer.parseInt(start);
//        int  m=1;
//        List<Pro_shop> list1=proListService.findPage((m-1)*8);//分页方法
//        String s1 = JSON.toJSONString(list1);
//
//        PrintWriter printWriter = null;
//        try {
//            printWriter = response.getWriter();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        printWriter.write(s);
//
//        printWriter.write(s1);
//
//        System.out.println(s);
//        System.out.println("--------------");
//        System.out.println(s1);
//
//
//        printWriter.close();
//
//
//        return null;
//    }
////根据小类查找对应商品
//    public String testfindKindMin(HttpServletRequest request,HttpServletResponse response) {
//        response.setContentType("text/html;charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        response.setHeader("Access-Control-Allow-Origin", "http://192.168.0.183:8081");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        String kind = request.getParameter("kind_max");
////        String kind="底妆";
//        List<Kinds> list1 = proListService.findKindMin(kind);
//        String s1 = JSON.toJSONString(list1);
//        PrintWriter printWriter = null;
//        try {
//            printWriter = response.getWriter();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        printWriter.write(s1);
//        printWriter.close();
//        return null;
//    }
////品牌
//    public String testfindBrand(HttpServletRequest request, HttpServletResponse response){
//        response.setContentType("text/html;charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
//        response.setHeader("Access-Control-Allow-Credentials","true");
//        String brand_name = request.getParameter("brand_name");
//        List<Brands> list2=proListService.findBrand();
//        String s1= JSON.toJSONString(list2);
//        PrintWriter printWriter = null;
//        try {
//            printWriter = response.getWriter();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        printWriter.write(s1);
//        printWriter.close();
//        return null;
//    }
////品牌下商品
//
//    public String testfindProByBrand(HttpServletRequest request,HttpServletResponse response){
//        response.setContentType("text/html;charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.101:8080");
//        response.setHeader("Access-Control-Allow-Credentials","true");
//        String brand_name = request.getParameter("brand_name");
////      String brand_name="自然堂";
//        List<Pro_shop> list4 = proListService.findProByBrand(brand_name);
//        String s2 = JSON.toJSONString(list4);
//        PrintWriter printWriter = null;
//        try {
//            printWriter = response.getWriter();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        printWriter.write(s2);
//        printWriter.close();
//        return null;
//    }
////分类
//
//    public String testSort (HttpServletRequest request, HttpServletResponse response) {
//        response.setHeader("Access-Control-Allow-Origin", "http://192.168.0.183:8081");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        String sort = request.getParameter("sort"); //点击哪个排序方法 传最近上市
//        System.out.println(sort);
////        String sort="111";
//
//        if (sort.equals("最近上市")) {
//            List<Pro_shop> list = proListService.findProMarket();
//            String s = JSON.toJSONString(list);
//            System.out.println(s);
//            return s;
//        } else if (sort.equals("销量排序")) {
//            List<Pro_shop> list = proListService.findProSale();
//            String s = JSON.toJSONString(list);
//            return s;
//        } else if (sort.equals("价格升序")) {
//            List<Pro_shop> list5 = proListService.sortByPrice();
//            String s5 = JSON.toJSONString(list5);
//            return s5;
//        } else {
//            List<Pro_shop> list6 = proListService.sortByPriced();
//            String s6 = JSON.toJSONString(list6);
//            return s6;
//        }
//
//    }
//}






