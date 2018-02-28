package alipay.api.domain;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import org.junit.Test;


public class paytestttttt {
    @Test
   public void paytest() {
       AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", "2016091200494186", "your private_key", "json", "utf-8", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAymNmy7Xfi1b8TIVKYDwh1W4Iz8hXUSLURXBHkqDzzZaKwguXnTEvipyb8cqeyU2VvXx3oulxNylKRZxZ", "RSA2");
       AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
       request.setBizContent("{" +
               "\"out_trade_no\":\"20150320010101001\"," +
               "\"total_amount\":88.88," +
               "\"subject\":\"Iphone616G\"," +
               "\"body\":\"Iphone616G\"," +
               "}");
        System.out.println(request.getBizContent());
       AlipayTradePrecreateResponse response = null;
       try {
           System.out.println(request);
           response = alipayClient.execute(request);
           System.out.println(response);
       } catch (AlipayApiException e) {
           e.printStackTrace();
       }
       if (response.isSuccess()) {
           System.out.println("调用成功");
       } else {
           System.out.println("调用失败");
       }
   }

}
