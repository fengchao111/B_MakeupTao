package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ssm.pojo.*;
import com.ssm.service.ProductsService;
import com.ssm.utils.Add_Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import javax.xml.ws.spi.http.HttpContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

@Controller
@Transactional
@RequestMapping("/dist")
public class ProductsController {
    static String picture=null;//点击上传时获得图片地址，点击确定时给前端传数据
    @Autowired
    private ProductsService productsService;
    @RequestMapping(value = "/loginfengchao.htm",method = RequestMethod.GET)
    public String toregist()
    {
        System.out.println("iiiii");
        return "/WEB-INF/page/fengchao.jsp";
    }
    //多表查询  正在用
    //@RequestMapping(value = "/selectfengchao.htm",method = RequestMethod.POST)
    @RequestMapping("/selectfengchao.htm")
	public String selectAll(HttpServletRequest request,HttpServletResponse response)
	{
        //System.out.println(request.getParameter("user_id"));
        System.out.println("伊凡大佬");
        response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
        response.setHeader("Access-Control-Allow-Credentials","true");
        PrintWriter out=null;
        List<Products> pro=productsService.SelectPro();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
                out= response.getWriter();
                String s=JSON.toJSONString(pro);
                out.print(s);
                out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
	}
	//单表查询
    @RequestMapping("/selefengchao.htm")
    public String selectA()
    {
        List<Products> pro=productsService.SelectAll();
        for (Products pro1:pro) {
            System.out.println(pro1.getProduct_name());
        }

        return "/WEB-INF/page/fengchao.jsp";
    }
    //多表添加Json 正在用的
    @RequestMapping(value = "/insertfengchao.htm",method = RequestMethod.POST)
    public void InsertJson(@RequestParam(value = "file",required=false)MultipartFile file,HttpServletRequest request, HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Origin","http://127.0.0.1:8020");
        response.setHeader("Access-Control-Allow-Credentials","true");
        String name=request.getParameter("name");
        String kind=request.getParameter("kind_id");
        String brand=request.getParameter("brand_id");
        System.out.println(kind+"111");
        int kinds=Integer.parseInt(kind);
        int brands=Integer.parseInt(brand);
        System.out.println(name+"=="+kind+"=="+brand);

        Products products=new Products();
        products.setProduct_name(name);
        products.setKind_id(kinds);
        products.setBrand_id(brands);
        //System.out.println(products.getProduct_name());
        productsService.InsertPro(products);
        System.out.println(products.toString());
        System.out.println("添加成功products");
        System.out.println(products.getProduct_id());


        String price=request.getParameter("price");
        int prices=Integer.parseInt(price);
        String num=request.getParameter("num");
        int nums=Integer.parseInt(num);
        String spec=request.getParameter("spec");
        String desc=request.getParameter("desc");
        String brandname=request.getParameter("brand_name");
        String kindname=request.getParameter("kind_name");
        Pro_shop pro_shop=new Pro_shop();
        pro_shop.setProduct_id(products.getProduct_id());
        pro_shop.setShop_id(1);
        pro_shop.setPro_shop_pic(picture);
        pro_shop.setPro_shop_price(prices);
        pro_shop.setPro_shop_oldprice(prices);
        pro_shop.setPro_shop_num(nums);
        pro_shop.setPro_shop_state(1);
        pro_shop.setPro_shop_spec(spec);
        pro_shop.setPro_shop_desc(desc);
        pro_shop.setPro_shop_sale(0);
        Date feet_time = new Date(System.currentTimeMillis());
        pro_shop.setPro_shop_time(feet_time);
        pro_shop.setPro_shop_look(0);
        pro_shop.setPro_shop_kind(kindname);
        pro_shop.setPro_shop_brand(brandname);
        productsService.InsertShop(pro_shop);
        //return "http://72dde5.natappfree.cc/selectfengchao.htm";
    }
    //多表添加
    @RequestMapping("/insertfengchao1.htm")
    public String Insert()
    {
//        String jsonstr = "{\"product_name\": \"眼影\",\"brand_id\": \"1\",\"kind_id\": \"2\"}";
//        Products products = new JSONObject().parseObject(jsonstr, Products.class);

        Products products=new Products();
        products.setProduct_name("口红666");
        System.out.println(products.getProduct_name());
        productsService.InsertPro(products);
        System.out.println("添加成功products");
        System.out.println(products.getProduct_id());



        Pro_shop pro_shop=new Pro_shop();
        pro_shop.setProduct_id(products.getProduct_id());
        pro_shop.setShop_id(1);
        pro_shop.setPro_shop_desc("大秦帝国");
        pro_shop.setPro_shop_pic("iii");
        pro_shop.setPro_shop_price(25);
        pro_shop.setPro_shop_oldprice(20);
        pro_shop.setPro_shop_num(10000);
        pro_shop.setPro_shop_state(1);
        pro_shop.setPro_shop_spec("规格");
        pro_shop.setPro_shop_desc("你好呀");
        pro_shop.setPro_shop_sale(1);
        pro_shop.setPro_shop_time(new Date(2018-1-1));
        pro_shop.setPro_shop_look(1);
        pro_shop.setPro_shop_kind("12");
        pro_shop.setPro_shop_brand("11");
        productsService.InsertShop(pro_shop);
        return "/WEB-INF/page/fengchao.jsp";
    }
    //单表添加到shop
    @RequestMapping("/shop.htm")
    public String Insertshop()
    {

        Pro_shop pro_shop=new Pro_shop();
        pro_shop.setProduct_id(11);
        pro_shop.setShop_id(1);
        pro_shop.setPro_shop_desc("叫快递覅街机三国假大空");
        pro_shop.setPro_shop_pic("iii");
        pro_shop.setPro_shop_price(25);
        pro_shop.setPro_shop_oldprice(20);
        pro_shop.setPro_shop_num(10000);
        pro_shop.setPro_shop_state(1);
        pro_shop.setPro_shop_spec("规格");
        pro_shop.setPro_shop_desc("你好呀");
        pro_shop.setPro_shop_sale(1);
        pro_shop.setPro_shop_time(new Date(2018-1-1));
        pro_shop.setPro_shop_look(1);
        pro_shop.setPro_shop_kind("12");
        pro_shop.setPro_shop_brand("11");
        productsService.InsertShop(pro_shop);
        return "/WEB-INF/page/fengchao.jsp";
    }
    //得到总条数
    @RequestMapping("/total.htm")
    public String getTotal(){
       int total= productsService.Total();
       System.out.println(total);
        return "/WEB-INF/page/fengchao.jsp";
    }
    //分页显示商品
    @RequestMapping("/page.htm")
    public String getPage(){
        Page page=new Page();
        page.setStart(0);
        page.setSize(2);
        List<Products> pro=productsService.Page(page);

        for (Products p:pro) {
            System.out.println(p.getProduct_name());
        }
        return "/WEB-INF/page/fengchao.jsp";
    }
    //下架
    @RequestMapping("down.htm")
    public String Downshop(){
        productsService.DownShop(1);
        System.out.println("商品已下架");
        return "/WEB-INF/page/fengchao.jsp";
    }
    //删除
    @RequestMapping("delete.htm")
    public String delete(){
        productsService.DeleteShop(1);
        System.out.println("商品已删除");
        return "/WEB-INF/page/fengchao.jsp";
    }
    //重新上架
    @RequestMapping("up.htm")
    public String up(){
        productsService.UpShop(1);
        System.out.println("商品重新上架");
        return "/WEB-INF/page/fengchao.jsp";
    }
    //修改
    @RequestMapping("/update.htm")
    public String update(){
        Pro_shop pro_shop=new Pro_shop();
        pro_shop.setPro_shop_price(10);
        pro_shop.setPro_shop_oldprice(20);
        pro_shop.setProduct_id(1);
        productsService.updatePrice(pro_shop);
        System.out.println("修改成功");
        return "/WEB-INF/page/fengchao.jsp";
    }
    //查询所有品牌
    @RequestMapping("/bbbbbBrand.htm")
    public String select(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","http://127.0.0.1:8020");
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=null;
        List<Brands> list=productsService.selectBrands();
        try {
            out= response.getWriter();
            String s=JSON.toJSONString(list);
            out.print(s);
            //out.print(length);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(list.toString());
        return null;
    }
    //根据大类查询改大类下的所有小类
    @RequestMapping("/selectmin.htm")
    public String selectMin(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","http://127.0.0.1:8020");
        response.setHeader("Access-Control-Allow-Credentials","true");
        String maxKind=request.getParameter("sort");
        System.out.println(maxKind);
        PrintWriter out=null;
        List<Kinds> list=productsService.selectKindMin(maxKind);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        try{
            out=response.getWriter();
            String s=JSON.toJSONString(list);
            out.print(s);
        }catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(list.toString());
        return null;
    }
    //根据小类名查询小类ID
    @RequestMapping("/selectminID.htm")
    public String selectMinId(){
        List<Kinds> list=productsService.selectKindId("洗面奶");
        System.out.println(list.toString());
        return "/WEB-INF/page/fengchao.jsp";
    }
    //上传图片
    @RequestMapping(value="/pic.htm",method = RequestMethod.POST)
    public String Upict( @RequestParam(value = "file",required=false)MultipartFile file,HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println("伊凡伊凡");
        response.setHeader("Access-Control-Allow-Origin","http://127.0.0.1:8020");
        response.setHeader("Access-Control-Allow-Credentials","true");
        try {
           int i= Add_Picture.addPic(file.getInputStream(),file.getOriginalFilename());
            picture="http://ozxb0em6i.bkt.clouddn.com/"+file.getOriginalFilename();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
    @RequestMapping(value="/picsure.htm",method = RequestMethod.POST)
    public String sure(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","http://127.0.0.1:8020");
        response.setHeader("Access-Control-Allow-Credentials","true");
        PrintWriter out=null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        try {
            out=response.getWriter();
            String s=JSON.toJSONString(picture);
            out.print(s);
            System.out.println(s);
            System.out.println("啊啊啊啊啊啊啊啊");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
