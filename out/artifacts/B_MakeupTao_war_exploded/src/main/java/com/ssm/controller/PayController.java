package com.ssm.controller;
import alipay.api.domain.paysss;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.ssm.pojo.Orders;
import com.ssm.service.OrderService;
import com.ssm.service.imp.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/dist")
public class PayController {
	private BufferedImage bufferedImage;

	@Autowired
	private OrderService orderService;

	@ResponseBody
	@RequestMapping(value="/img.htm",method = RequestMethod.GET)
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response){
        paysss pay = new paysss();
        System.out.println("进入方法");
//        finalla.setPrice(request.getParameter("price"));
        //System.out.println(finalla.getPrice());
		response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
		response.setHeader("Access-Control-Aoolw-Credentials","true");
		response.setDateHeader("Expires",0);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
       String s2 = pay.testAlipaytradeprecreat(request.getParameter("price"));
//		String s2 = pay.testAlipaytradeprecreat("566");
        main1(s2);
		BufferedImage bi =bufferedImage;
		System.out.println(bi);
		ServletOutputStream out = null;
		try {
			out = response.getOutputStream();
			ImageIO.write(bi, "jpg", out);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("输出完成");
		return null;
	}
	public void main1(String qrcode){
		int width=300;
		int height=300;
		String content=qrcode;
		//定义二维码参数
		HashMap hints=new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN,2);
		try {
			BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height,hints);
			bufferedImage=MatrixToImageWriter.toBufferedImage(bitMatrix);
		} catch (Exception e) {
			System.out.println("https://qr.alipay.com/bax05479jvlgwvarmbef00ae");
		}
	}
	public static void  erwm(int i){

	}
	@RequestMapping(value="/order.htm",method = RequestMethod.POST)
	@ResponseBody
	public  void regist( HttpServletRequest request, HttpServletResponse response)
	{	response.setHeader("Access-Control-Allow-Origin","http://192.168.0.183:8081");
		response.setHeader("Access-Control-Aoolw-Credentials","true");
		Orders orders = new Orders();
//		System.out.println(orders);
		System.out.println(request.getParameter("user_id"));
		OrderServiceImp orderServiceImp=new OrderServiceImp();
		orders.setAddress_id(Integer.parseInt(request.getParameter("address_id")));
		orders.setUser_id(Integer.parseInt(request.getParameter("user_id")));
		orders.setOrder_state(1);
		orders.setOrder_time(new Date(System.currentTimeMillis()));
		orders.setOrder_message(request.getParameter("order_message"));
		orders.setOrder_money(Integer.parseInt(request.getParameter("order_money")));
		List<Integer>idlist=new ArrayList<>();
		List<Integer>numlist=new ArrayList<>();
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		int number= Integer.parseInt(request.getParameter("number"));
		HashMap<String,Object> nameMap = new HashMap<String,Object>();

		nameMap=JSON.parseObject(request.getParameter("id"),new TypeReference<HashMap<String,Object>>() {});
		int id0 = (int)nameMap.get("id0");
		HashMap<String,Object> numMap = new HashMap<String,Object>();

		numMap=JSON.parseObject(request.getParameter("num"),new TypeReference<HashMap<String,Object>>() {});
		int num0 = (int)numMap.get("num0");
		System.out.println(num0);
		System.out.println(numMap);
		System.out.println("-------------------------------------------");
		for(int i=0;i<number;i++){
			String s = String.valueOf(i);
			idlist.add((int)nameMap.get("id" + s));
			System.out.println((int)nameMap.get("id" + s));
			numlist.add((int)numMap.get("num" + s));
		}
		System.out.println(idlist);
        int orders_id = orderService.order(idlist, numlist, number, user_id, orders);
        JSONObject jsonObject = new JSONObject();
		jsonObject.put("img","http://p07z28qn9.bkt.clouddn.com/IMG_4324.JPG");
		String s = jsonObject.toString();
		try {
			response.getWriter().write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
