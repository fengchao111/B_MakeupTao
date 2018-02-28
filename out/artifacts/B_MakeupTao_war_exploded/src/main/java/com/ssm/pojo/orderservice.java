package com.ssm.pojo;

public class orderservice {
    private int order_id;
    private int pro_shop_order_id;
    private String pro_shop_pic;
    private String pro_shop_desc;
    private int pro_shop_order_price;
    private int pro_shop_order_oldprice;
    private int pro_shop_order_number;
    private String shop_name;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getPro_shop_order_id() {
        return pro_shop_order_id;
    }

    public void setPro_shop_order_id(int pro_shop_order_id) {
        this.pro_shop_order_id = pro_shop_order_id;
    }

    public String getPro_shop_pic() {
        return pro_shop_pic;
    }

    public void setPro_shop_pic(String pro_shop_pic) {
        this.pro_shop_pic = pro_shop_pic;
    }

    public String getPro_shop_desc() {
        return pro_shop_desc;
    }

    public void setPro_shop_desc(String pro_shop_desc) {
        this.pro_shop_desc = pro_shop_desc;
    }

    public int getPro_shop_order_price() {
        return pro_shop_order_price;
    }

    public void setPro_shop_order_price(int pro_shop_order_price) {
        this.pro_shop_order_price = pro_shop_order_price;
    }

    public int getPro_shop_order_oldprice() {
        return pro_shop_order_oldprice;
    }

    public void setPro_shop_order_oldprice(int pro_shop_order_oldprice) {
        this.pro_shop_order_oldprice = pro_shop_order_oldprice;
    }

    public int getPro_shop_order_number() {
        return pro_shop_order_number;
    }

    public void setPro_shop_order_number(int pro_shop_order_number) {
        this.pro_shop_order_number = pro_shop_order_number;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    @Override
    public String toString() {
        return "orderservice{" +
                "order_id=" + order_id +
                ", pro_shop_order_id=" + pro_shop_order_id +
                ", pro_shop_pic='" + pro_shop_pic + '\'' +
                ", pro_shop_desc='" + pro_shop_desc + '\'' +
                ", pro_shop_order_price=" + pro_shop_order_price +
                ", pro_shop_order_oldprice=" + pro_shop_order_oldprice +
                ", pro_shop_order_number=" + pro_shop_order_number +
                ", shop_name='" + shop_name + '\'' +
                '}';
    }
//                List<orderservice> someorder=new ArrayList<>();
//                System.out.println(someOrders.size());
//                System.out.println(someOrders.get(1));
//        for(int i=0;i<=someOrders.size()-1;i++){
//            Orders orders1 = someOrders.get(i);
//            System.out.println(orders1);
//            orderservice orderservice1=new orderservice();
//            orderservice1.setOrder_id(orders1.getOrder_id());
//            orderservice1.setPro_shop_order_number(orders1.getPro_shop_orders().get(i).getPro_shop_order_number());
//            orderservice1.setPro_shop_pic(orders1.getPro_shops().get(i).getPro_shop_pic());
//            orderservice1.setPro_shop_desc(orders1.getPro_shops().get(i).getPro_shop_desc());
//            orderservice1.setPro_shop_order_price(orders1.getPro_shop_orders().get(i).getPro_shop_order_price());
//            orderservice1.setPro_shop_order_oldprice(orders1.getPro_shop_orders().get(i).getPro_shop_order_oldprice());
//            orderservice1.setShop_name(orders1.getPro_shops().get(i).getShops().getShop_name());
//            System.out.println(orders1);
//           someorder.add(orderservice1);
//        }

}
