package com.ssm.service.imp;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.UUID;

@Component
public class Test {
    public static void main(String[] args){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(uuid);
        int width=300;
        int height=300;
        String format ="png";
        String content="罗臭娃是傻逼，玩锤子呢玩";
        //定义二维码参数
        HashMap hints=new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN,2);
        try {
            BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height,hints);
            File file = new File("D:/code/img10247896.png");
            Path path=file.toPath();
            MatrixToImageWriter.toBufferedImage(bitMatrix);
            MatrixToImageWriter.writeToPath(bitMatrix,format,path);
        } catch (Exception e) {
            System.out.println("https://qr.alipay.com/bax05479jvlgwvarmbef00ae");
        }
    }
    public static void  erwm(int i){

    }
}
