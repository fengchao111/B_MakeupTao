package com.ssm.service.imp;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

public class Test1 {
    public static void main(String[] args){
        MultiFormatReader formatreader=new MultiFormatReader();
        File file =new File("D:/code/img.png");
        try {
            BufferedImage image= ImageIO.read(file);
            BinaryBitmap binaryBitmap=new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
            HashMap hints=new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
            Result result=formatreader.decode(binaryBitmap,hints);
            System.out.println("解析结果"+result.toString());
            System.out.println("格式类型"+result.getBarcodeFormat());
            System.out.println("解析内容"+result.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
