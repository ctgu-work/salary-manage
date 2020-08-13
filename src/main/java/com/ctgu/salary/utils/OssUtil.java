package com.ctgu.salary.utils;


import java.io.*;
import java.util.Properties;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.ctgu.salary.dto.ResultBody;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import static com.ctgu.salary.utils.Md5Salt.Md5SaltCrypt;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-06 10:12
 * @ClassName OssUtil
 * @Version 1.0.0
 */
public class OssUtil {
    private static Properties properties = new Properties();
    // 使用InPutStream流读取properties文件
    private static BufferedReader bufferedReader = null;
    private static String endpoint = null;
    private static String accessKeyId = null;
    private static String accessKeySecret = null;
    private static String bucketName = null;
    private static String oss_filedir = null;
    private static String oss_static_url = null;


    /**
     * @Author wh
     * @Description 获取文件后缀名
     * @Date 2020/8/6 10:27
     * @Param [file]
     * @return java.lang.String
     **/
    public static String getFileExtension(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if(fileName.lastIndexOf(".") != -1) {
            return fileName.substring(fileName.lastIndexOf("."));
        }
        else {
            return null;
        }
    }

    /**
     * @Author wh
     * @Description 获取配置信息
     * @Date 2019/12/18 13:27
     * @Param []
     * @return void
     **/
    public static void getPro(){
        try {
            bufferedReader = new BufferedReader(new FileReader("src\\main\\resources\\oss.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(bufferedReader);
            // 获取key对应的value值
            endpoint = properties.getProperty("endpoint");
            accessKeyId = properties.getProperty("accessKeyId");
            accessKeySecret = properties.getProperty("accessKeySecret");
            bucketName = properties.getProperty("bucketName");
            oss_filedir = properties.getProperty("oss_filedir");
            oss_static_url = properties.getProperty("oss_static_url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author wh
     * @Description 上传文件到Oss
     * @Date 2020/8/6 10:30
     * @Param [fileName, multipartFile]
     * @return java.lang.String
     **/
    public static String upLoadFile(String fileName, MultipartFile multipartFile) {
        getPro();
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId,accessKeySecret);
        // 上传内容到指定的存储空间（bucketName）并保存为指定的文件名称（objectName）。
        String objectName = oss_filedir + Md5SaltCrypt(fileName) + getFileExtension(multipartFile);
        try {
            PutObjectResult putObjectResult = ossClient.putObject(bucketName, objectName, multipartFile.getInputStream());
            System.out.println(putObjectResult);
            ossClient.shutdown();
            return oss_static_url + objectName;
        }
        catch (Exception e){
            // 关闭OSSClient。
            ossClient.shutdown();
            e.printStackTrace();
            return "error";
        }
    }


    public static String testUpLoadFile(String fileName, File file) {
        getPro();
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId,accessKeySecret);
        // 上传内容到指定的存储空间（bucketName）并保存为指定的文件名称（objectName）。
        String objectName = oss_filedir + Md5SaltCrypt(fileName) + ".png";
        System.out.println(bucketName);
        System.out.println(objectName);
        System.out.println(file.getName());
        try {
            PutObjectResult putObjectResult = ossClient.putObject(bucketName, objectName, file);
            // 关闭OSSClient。
            ossClient.shutdown();
            return oss_static_url + objectName;
        }
        catch (Exception e){
            // 关闭OSSClient。
            ossClient.shutdown();
            e.printStackTrace();
            return "error";
        }

    }

//    public static void main(String[] args) {
//        System.out.println(testUpLoadFile("9.png" , new File("src\\main\\resources\\9.png")));
//    }
}
