package alipay.api.domain;

import com.alipay.api.domain.ExtendParams;
import com.alipay.api.domain.GoodsDetail;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.model.builder.AlipayTradePrecreateRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FPrecreateResult;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class paysss {
    public String testAlipaytradeprecreat(String price){
        String qrcode=null;
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
        System.out.println(price);
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(uuid);
        AlipayTradePrecreateRequestBuilder builder =new AlipayTradePrecreateRequestBuilder()
                .setSubject("妆淘旗舰店")
                .setTotalAmount(price)
                .setOutTradeNo(uuid)
                .setUndiscountableAmount("2")
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
                qrcode=res.getQrCode();

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
        return qrcode;
    }
    public void erweima(String qrcode){
        int width=300;
        int height=300;
        String format ="png";
        String content=qrcode;
        //定义二维码参数
        HashMap hints=new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN,2);
        try {
            BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height,hints);
            Path path=new File("D:/code/img0066.png").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix,format,path);
        } catch (Exception e) {
            System.out.println("崔佳欢是煞笔");
        }
    }
    public static void  erwm(int i){

    }
}
