package com.ssm.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ResourceBundle;

public class Add_Picture {
    //构造一个带指定Zone对象的配置类

    //...生成上传凭证，然后准备上传
    private static String accessKey;
    private static String secretKey;
    private static String bucket;

    private static Configuration cfg;
    private static UploadManager uploadManager;
    public static void init(){
        ResourceBundle qiNiuYun = ResourceBundle.getBundle("QiNiuYun");
        accessKey = qiNiuYun.getString("ACCESS_KEY");
        secretKey = qiNiuYun.getString("SECRET_KEY");
        bucket = qiNiuYun.getString("bucketname");
        cfg = new Configuration(Zone.autoZone());
        uploadManager = new UploadManager(cfg);
    }
    public static int addPic(InputStream inputStream, String path) {
        init();
        String key=path;
        try {
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(inputStream, key, upToken,null,null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    return 0;
                }
                return 0;
            }
        } catch (Exception ex) {
            return  0;
        }
        return  1;
    }
}
