package alipay.api.domain;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
public class Test {
    public static void main(String[] args){
        int width=300;
        int height=300;
        String format ="png";
        String content="昨晚通宵写了个这个二维码生成,特地给你秀一秀,想骂谁给我发,我给你封装在二维码里面";
        //定义二维码参数
        HashMap hints=new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN,2);
        try {
            BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height,hints);
            Path path=new File("D:/code/img0018.png").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix,format,path);
        } catch (Exception e) {
            System.out.println("崔佳欢是煞笔");
        }
    }
    public static void  erwm(int i){

    }
}
