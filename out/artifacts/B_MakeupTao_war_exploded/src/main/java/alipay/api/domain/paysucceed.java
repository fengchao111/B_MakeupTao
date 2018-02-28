package alipay.api.domain;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.domain.ExtendParams;
import com.alipay.api.domain.GoodsDetail;
import com.alipay.api.request.AlipayFundTransOrderQueryRequest;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayFundTransOrderQueryResponse;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.model.builder.AlipayTradePrecreateRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FPrecreateResult;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;
import com.alipay.demo.trade.utils.ZxingUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class paysucceed {
    private final String SERVER_URL = "https://openapi.alipaydev.com/gateway.do";//支付宝网关（沙箱测试固定）
//  private final String SERVER_URL = "https://openapi.alipay.com/gateway.do";//支付宝网关（固定）

    //应用私钥
    private final String PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCPmE2Fn4rrz+c25VFRhMy+9PprlN4j2bLgu2Ghe4dtz5R6LOVlxeE6Ib92qQ5vHeLEd8h2f9tyUKYo0fA9MpOYYmkpgjeQhncyU2kdoU5hPMU/wC1cl7HbWjcfPI+2GsZRJBxZh9jtv4FelcTTdYBn/WEYIlf/LtVCmhXgRXt+du0huGzvrOnoWu7mUhAKcjFP0PAIP5Q1gfY5CZu3MldPr7/VYI4T8Ws9X1PcOiluw23GL3tGoA3fz80wbCKBSO40iEwt96d8kKzYkeEybzvPQKR4LCLYVmvSfjY5cGa8eRMSJ45d5Frsl0Y1At2L+N/p08v+XJJ+V/StvQd7u3t/AgMBAAECggEALzVZNzcOixxc3ZViuLQ6RAVyVvAoYAzwXCX+oQJlsdpu7APany0BMQVrVu2Zizp+FS10QFEkql6NYhozK0t3br/b5wOilOdARNFbW5xuklVSW/UodKqClKUCPkjAzpPa405F68FXtkIhnCENBqA4yPdqdm7EE2coQa86xfLR+O9KJTtoaOkqMfC6ukU+0K9t+mXRo+pbFKFZE+2PyCOs1skk5j3A4sk2IAD46BYlsJ+QPhrNpwxSa7fEEYHugR5Dtf8ZyI3FzJCixxpdDcOnBBTZAFrNuXeARxv3r4xz7InlZokm4oV/BA0fIOSK/Chzw93Cqrm7vs1mqiJhJh4qgQKBgQD3zdJhvD+bjlZbdMF+WaU12hHrllKbZX0jyqsoHBHJGYilzuRtHB0jqD1yDAJHCAEjcuI+XqZiT3/yGGwFGhlMz0eSpkcrEBrkVcv6AI7oluFm7WqdvTKtInT7uCQSdodJ7Kxr1lLzT6ddUe9FqDKiEYGnHqdqz6K/dIG1yERh4QKBgQCUWCI9bqxoYgPa6UKEpT+5+Ipt3IDWgrxxajoAnqygn1osHcnqcvfv7gRhmUoKxAm8WEF6YhIInp13/IfBKnxmMtFflzxZ/KZEjrBG3RTC0J+4emKuMHDJtNtnYCWgFute0zr1JVm7t1AEec9Sxz3XnMCcxti/Hk8/KXz2HLJJXwKBgQC5WtYbzxCRDZXg0OOO3AUs09IFsypVHEPPiuAdn2laT+Qbijboule9fTGA5iSp9v3LAzrhxjCUZrzgXI4n/s6f2ofB1Oh0+JX054wsk1BR/9HYCIxwMr3+LUDtrF4nBUvK6uJJw0XGw3T/47KjGt3MxmWBmPdHeMpWhRIk5AjqYQKBgBRbF6+4XR4hvQewFHmhN2JskYpLxL4qyHMDsZveKjAMTdJZ8Bgk2JLq5V0DLN7XUcKvlaSWioT2RwNs+q/uBY38kTB9z0FF4wbrUZMXyT6GZDRrTtk6Om/jSmwgDGmwW3HyqFd1XZ/dorRKhsGEJ59Lmj6pJprrLNKs/cHD5E8fAoGBAOXOId6RRAswcGy2RzJq9tj4n9sZpg0GXtGLC3ja/QPTSnQZ+gxJi5FslICqV/KH/YOoEbhZysu3gqjHaX4xUSQiBzss9j9LCOqBBiEYOuspKgenbCB000BFZhCax1Dw+tH7d8U9HBIql3YaV0aJ87bErNJ+315PPRn01jUhA+fX";
    //以下信息不需要修改
    private final String FORMAT = "json";
    private final String CHARSET = "utf-8";
    private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAymNmy7Xfi1b8TIVKYDwh1W4Iz8hXUSLURXBHkqDzzZaKwguXnTEvipyb8cqeyU2VvXx3oulxNylKRZxZ+BBhkBkxR61HtP3Wb8A3PyIWerCoBDuMTCkWvRWphdHrNXTCmVUzdRYNYw8PPfgvA3oBk/GM+VPomk5QhchXX4/fJ7YeqpcKXT7UKGegKVYj7AU1iJDFmrEPX6G9LUXfwz3Rcai9DHoA2uVPGIlZSJheO1pbJUsN3aj1ECdgx5oR/no3c06ov1TG9RoTl5pkgoxjpyQlr2TFXQqqhu9QW0VCDcKbApxOfYHdP9yFxPLQbAHDyENsjEUP/VGkSM6VmmpmTQIDAQAB";
    private final String SIGN_TYPE = "RSA2";

    //当面付
    private final String APP_ID = "2016091200494186";//沙箱APPID(测试)

    private String AUTH_CODE = "286178505080617877";//付款码(一码一用)

    private AlipayClient alipayClient;
    @Before
    public void setUp(){
        alipayClient = new DefaultAlipayClient(SERVER_URL, APP_ID, PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
    }

    @Test
    public void testTradePay() {//当面付
        AlipayTradePayRequest request = new AlipayTradePayRequest();
        AlipayTradePayModel model = new AlipayTradePayModel();

        model.setOutTradeNo(System.currentTimeMillis()+"");//订单号
        model.setSubject("单车");//商品说明
        model.setTotalAmount("10");//金额
        model.setAuthCode(AUTH_CODE);//沙箱钱包中的付款码
        model.setScene("bar_code");//wave_code 声波支付; bar_code 条码支付
        try {
            request.setBizModel(model);
            AlipayTradePayResponse response = alipayClient.execute(request);

            System.out.println(response.getBody());
            System.out.println(response.getTradeNo());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
    }
    public void  testAlipaytradeprecreat(){
        Configs.init("zfbinfo.properties");
        AlipayTradeService tradeService = new AlipayTradeServiceImpl.ClientBuilder().build();
        AlipayTradePrecreateRequest request=new AlipayTradePrecreateRequest();
        //生成 转账信息
        String sellerId = "2088102175297952";

        // 订单描述，可以对交易或商品进行一个详细地描述，比如填写"购买商品2件共15.00元"
        String body = "购买商品2件共15.00元";

        // 商户操作员编号，添加此参数可以为商户操作员做销售统计
        String operatorId = "test_operator_id";

        // (必填) 商户门店编号，通过门店号和商家后台可以配置精准到门店的折扣信息，详询支付宝技术支持
        String storeId = "test_store_id";

        // 业务扩展参数，目前可添加由支付宝分配的系统商编号(通过setSysServiceProviderId方法)，详情请咨询支付宝技术支持
        ExtendParams extendParams = new ExtendParams();
        extendParams.setSysServiceProviderId("2088100200300400500");

        // 支付超时，定义为120分钟
        String timeoutExpress = "120m";

        // 商品明细列表，需填写购买商品详细信息，
        List<GoodsDetail> goodsDetailList = new ArrayList<GoodsDetail>();
        // 创建一个商品信息，参数含义分别为商品id（使用国标）、名称、单价（单位为分）、数量，如果需要添加商品类别，详见GoodsDetail
        //GoodsDetail goods1 = GoodsDetail.newInstance("goods_id001", "全麦小面包", 1500, 1);
        // 创建好一个商品后添加至商品明细列表
       // goodsDetailList.add(goods1);

        // 继续创建并添加第一条商品信息，用户购买的产品为“黑人牙刷”，单价为5.05元，购买了两件
        //GoodsDetail goods2 = GoodsDetail.newInstance("goods_id002", "黑人牙刷", 505, 2);
       // goodsDetailList.add(goods2);
        String bizContent = getBizContent01();
        request.setBizContent(bizContent);
        AlipayTradePrecreateRequestBuilder builder =new AlipayTradePrecreateRequestBuilder()
                .setSubject("崔佳欢是煞笔")
                .setTotalAmount("800")
                .setOutTradeNo("325847691")
                .setUndiscountableAmount("500")
                .setSellerId(sellerId)
                .setBody(body)
                .setOperatorId(operatorId)
                .setStoreId(storeId)
                //.setExtendParams(extendParams)
                .setTimeoutExpress(timeoutExpress);
//              .setNotifyUrl("http://www.test-notify-url.com")//支付宝服务器主动通知商户服务器里指定的页面http路径,根据需要设置
               // .setGoodsDetailList(goodsDetailList);

        AlipayF2FPrecreateResult result = tradeService.tradePrecreate(builder);
        switch (result.getTradeStatus()) {
            case SUCCESS:
                System.out.println("succeed");
                AlipayTradePrecreateResponse res = result.getResponse();
                String qrCode1 = res.getQrCode();
            case FAILED:
               System.out.println("error");
                break;

            case UNKNOWN:
                System.out.println("unknow");
                break;

            default:
                System.out.println("00000");
                break;
        }
    }

    @Test
    public void testTransToaccount(){
        AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
        String bizContent = getBizContent01();
        request.setBizContent(bizContent);

        try {
            AlipayFundTransToaccountTransferResponse response = alipayClient.execute(request);

            System.out.println(response.isSuccess());
            System.out.println(response.getCode());
            System.out.println(response.getBody());
        } catch (AlipayApiException e) {

            e.printStackTrace();
        }
    }
    //qhskwo0031@sandbox.com(买家)  pcbwne3288@sandbox.com(商家)
    //ALIPAY_USERID     ALIPAY_LOGONID
    private String getBizContent01(){

        String outBizNo = System.currentTimeMillis()+"";

        JSONObject object = new JSONObject();
        object.put("out_biz_no", outBizNo);//唯一订单号
        object.put("payee_type", "ALIPAY_LOGONID");//收款账户类型
        object.put("payee_account", "bemhkw1366@sandbox.com");//收款帐号
        object.put("payee_real_name", "沙箱环境");//收款方真实姓名
        object.put("amount", 100);//金额
        object.put("remark", "转账备注");//转账备注
        return object.toJSONString();
    }

    @Test
    public void testTransQuery(){//单条转账记录查询
        AlipayFundTransOrderQueryRequest request = new AlipayFundTransOrderQueryRequest();
        String bizContent = "{out_biz_no:1501047155276}";
        request.setBizContent(bizContent);

        try {
            AlipayFundTransOrderQueryResponse response = alipayClient.execute(request);

            System.out.println(response.isSuccess());
            System.out.println(response.getCode());
            System.out.println(response.getBody());

        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
    }



}
