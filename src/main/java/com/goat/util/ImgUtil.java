package com.goat.util;/**
 * @author lwj
 * @date 2021/7/12 10:13
 * @version 1.0
 */

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassNameImgUpUtil
 * @Descriprion
 * @AuthorLenovo
 * @Date 2021/7/1210:13
 * @Version 1.0
 */
public class ImgUtil {

   public static String upload(MultipartFile file){
      //构造一个带指定 Region 对象的配置类
      Configuration cfg = new Configuration(Region.region1());
   //...其他参数参考类注释
      UploadManager uploadManager = new UploadManager(cfg);
   //...生成上传凭证，然后准备上传
      String accessKey = "t-qbmYxRs7SJuNpBrhubkixHcZY-g5VNTuV0uGF_";
      String secretKey = "d8YeB-sCBuLfEnwfeCFkZqtJg6nPMKTK2dGatyCg";
      String bucket = "goat-blog";
      String url = "http://qw40kzo92.hb-bkt.clouddn.com/";

      Date date = new Date();
      SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
      String key = df.format(date)+file.getOriginalFilename();
      Auth auth = Auth.create(accessKey, secretKey);
      String upToken = auth.uploadToken(bucket);
      try {
         Response response = uploadManager.put(file.getBytes(), key, upToken);
         //解析上传成功的结果
         DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);


         System.out.println(putRet.key);
         System.out.println(putRet.hash);
         return url+putRet.key;
      } catch (QiniuException ex) {
         Response r = ex.response;
         System.err.println(r.toString());
         try {
            System.err.println(r.bodyString());
         } catch (QiniuException ex2) {
            //ignore
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }
}
