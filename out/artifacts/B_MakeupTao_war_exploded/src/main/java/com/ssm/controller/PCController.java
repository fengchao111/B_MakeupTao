package com.ssm.controller;

import com.ssm.pojo.Kinds;
import com.ssm.service.SmallClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dist")
public class PCController {

    @Autowired
    private SmallClassService smallClassService;
    @RequestMapping("login.htm")
    public String toregist()
    {
        return "/WEB-INF/page/han.jsp";
    }
//    新建小类
    @RequestMapping("/newSmallClass.htm")
	public String newSmallClass()
	{
//        List<Products> pro=productsService.SelectAll();
//        for (Products pro1:pro) {
//            System.out.println(pro1.getProduct_name());
//        }
        Kinds kinds = new Kinds();
        kinds.setKind_max("口红");
        kinds.setKind_min("女士口红");
        System.out.println(kinds.getKind_max()+"  "+kinds.getKind_min());
        smallClassService.newSmallClass(kinds);
        return "/WEB-INF/page/newSmallClass.jsp";
	}
    //删除小类
    @RequestMapping("/deleteSmallClass.htm")
    public String deleteSmallClass()
    {
        String s1="女士口红";
        smallClassService.deleteSmallClass(s1);
//        Products products=new Products();
//        products.setProduct_name("面膜");
//        System.out.println(products.getProduct_name());
//        productsService.InsertPro(products);
        return "/WEB-INF/page/deleteSmallClass.jsp";
    }
    //查询小类
    @RequestMapping("/selectSmallClass.htm")
    public String selectSmallClass()
    {
        String s="眼妆";
        List<String> pro=smallClassService.selectSmallClass(s);
        for (String pro1:pro) {
          System.out.println(pro1);
        }
        return "/WEB-INF/page/selectSmallClass.jsp";
    }

//    public static void main(String[] args) {
//        System.out.println();
//    }

}
