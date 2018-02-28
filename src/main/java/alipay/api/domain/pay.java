package alipay.api.domain;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;

import java.util.List;
public class pay {
    public static void main(String[] args){
        AlipayClient alipayClient=new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do","2016091200494186","MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC0Y3qJTPFDR/AbOintERvlA/Ug9Bdcu0eFCMYBdLbmDEIuIg05Afbmxz4STazLfrsMz5mgwo9i6uPXwINodjepaQ04YfL9/UoJXDLF7FvZUvBSIgzG6UHx/MnGe7e11vnXlqPE2yRaJflJYwr4WHp3JFGn7Xmyzf/e8yblJ4bKJLrfBmybwsZPg9nld8szkTc9kp0ghQjNmc0rRTRWQtILxVKuw8fchSx1uRzG8qlBMKN0jczBpn7YyjNISaQd5KrT9BKS1pnXUUGKFNwdkLYlcpEraiNN6wV0Hypht8A5x1R55xBA/ixxUVZtXXfdReNYkjRjBZ40HKrBH3ak1TXlAgMBAAECggEBAKPQ42rk0QUEw2w2efSsYOStn2L5yG2SNfT+brLLx31LDJ7Qlal7uzkBH8GHgLCcukl8DkwL5CM0pQ096xhmo03Z9QOLEBzQdPfjHsjXSOIni89K1Mee9SBJLQRvPfqI7AN47ejMCktDyQt4QnIeB7lC5lTWOHrE0OUrc9sO9j2Daz0T8W7JVX6xvsWlfTNEfsbrxVfT0GHLO2TW6qzConwuIrrvJUMiOMkdrOA0G9c1h8MO/2I5VNlvYLwWHhBQ0ONbZoJNw+6rjlZk1SGiKQiiDxiRnvlslr5dvxwD0LfxO+NOuoUC6mrQfybNEDrG94uUYOhgZuhOmehxKFKJsYECgYEA+E3BB1EOa3oNbX58k1hQ4GJTr85zbpKl7/5PvOnE3IK+PYJlW8FobYiK6sRmrrTHSOzxWRFnj5LuAEuZJIe8fmlSP/yC8evVGtkB8j+JjmDoGR/jjXhLpqQt9N+LYwUbWOdLjTLryYvdTpJ8cKDszImtmjeQQZUh21bUBwox+c0CgYEAufrUf/c6m5hVug2ZDH7VYaEqmzNehvQIijGCI/G+HxvW03pwaxkiyQdofv8MwuiyGkyaDMKZ2i8usKQNRzYEhMQMMif8rDgnmWRgIjjFx8Q3x9mO2ItL/fM2F+PsEGs4z2MBg+Yu8ygYOyopLMdatrACbzRZGKgKXyLymdPatHkCgYAi/yqGsnj60wATf7FlPxxfE9zBubJxUkALHGf2s2gowFC58KgCj7b9QTJ7NmVWmGpCMAswR5C2Hrpm1kDmci8yDfwmwpteJ6QonY91qljj9WqhJ+p1pQ/ck+VaTyuhMDYTiL4QT64GAS2XBnR9l2DozzrlspElfTSBarKFr30tvQKBgBg5K2Rfdyq89K1/B+gwvOoya7I7RpydPF+Dg0fbPMAgiCKTWAEbDQTSCjJAVhEs7cWvJIF090UL0DEBrRkRWBVS06PUwXxM9Btuj3blnh0e2YUWORzLR+KTwv/pl92rmYKpipD7cjIJjt5l52cFsDMLScXiM5iain9Jtf+DMIFBAoGBAKEHQClJUhpQJbhALAZZaFrZgzMPdcL7Gqi8zzyAVU9qLx8Yrp761addbj4iTRFplZhgE7z1vsbzDk54ADehXKWHYXIYsFGdjE4a7ltcMwyIXH4y1e9Q8s7kXT1seSZySf502F/SkMT8rS2XoHsw8Grort/xVXC75DukRMpJVmsW","json","utf-8",
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAymNmy7Xfi1b8TIVKYDwh1W4Iz8hXUSLURXBHkqDzzZaKwguXnTEvipyb8cqeyU2VvXx3oulxNylKRZxZ+BBhkBkxR61HtP3Wb8A3PyIWerCoBDuMTCkWvRWphdHrNXTCmVUzdRYNYw8PPfgvA3oBk/GM+VPomk5QhchXX4/fJ7YeqpcKXT7UKGegKVYj7AU1iJDFmrEPX6G9LUXfwz3Rcai9DHoA2uVPGIlZSJheO1pbJUsN3aj1ECdgx5oR/no3c06ov1TG9RoTl5pkgoxjpyQlr2TFXQqqhu9QW0VCDcKbApxOfYHdP9yFxPLQbAHDyENsjEUP/VGkSM6VmmpmTQIDAQAB","RSA2" );

        AlipayTradePrecreateRequest request=new AlipayTradePrecreateRequest();
        request.setBizContent("{" +
                "\"out_trade_no\":\"20150320010101001\"," +
                "\"total_amount\":88.88," +
                "\"discountable_amount\":8.88," +
                "\"subject\":\"Iphone616G\"," +
                "\"body\":\"Iphone616G\"," +
                "}");
        AlipayTradePrecreateResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.println(response);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        System.out.println(response.getBody());
    }
}
