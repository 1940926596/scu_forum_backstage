package com.example.Service;
import java.io.*;
import java.util.Base64;
import java.util.Map;
import java.util.UUID;
import java.util.Base64.Decoder;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class SavePhoto {
    @PostMapping("/uploadImage")
    @ResponseBody
    public String uploadImage(@RequestBody Map<String,String> map) {
//        System.out.println(map);
        String base64Data=map.get("base64Data");
        System.out.println("==上传图片==");
//        System.out.println("==接收到的数据==" + base64Data);

        String dataPrix = ""; //base64格式前头
        String data = "";//实体部分数据

        if (base64Data == null || "".equals(base64Data)) {
            return ("上传失败，上传图片数据为空");
        } else {
            String[] d = base64Data.split("base64,");//将字符串分成数组
            if (d != null && d.length == 2) {
                dataPrix = d[0];
                data = d[1];
            } else {
                return ("上传失败，数据不合法");
            }
        }
        String suffix = "";//图片后缀，用以识别哪种格式数据
        //data:image/jpeg;base64,base64编码的jpeg图片数据
        if ("data:image/jpeg;".equalsIgnoreCase(dataPrix)) {
            suffix = ".jpg";
        } else if ("data:image/x-icon;".equalsIgnoreCase(dataPrix)) {
            //data:image/x-icon;base64,base64编码的icon图片数据
            suffix = ".ico";
        } else if ("data:image/gif;".equalsIgnoreCase(dataPrix)) {
            //data:image/gif;base64,base64编码的gif图片数据
            suffix = ".gif";
        } else if ("data:image/png;".equalsIgnoreCase(dataPrix)) {
            //data:image/png;base64,base64编码的png图片数据
            suffix = ".png";
        } else {
            System.out.println(dataPrix);
            System.out.println(dataPrix);
            return ("上传图片格式不合法");

        }
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String tempFileName = uuid + suffix;
        String imgFilePath = "D:\\Vue\\booksale\\src\\photo\\" + tempFileName;//新生成的图片
        Decoder decoder = Base64.getDecoder();
        try {
            //Base64解码
            byte[] b = decoder.decode(data);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    //调整异常数据
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            String imgurl = tempFileName;
            //imageService.save(imgurl);
            System.out.println(imgurl);
            return imgurl;
        } catch (IOException e) {
            e.printStackTrace();
            return ("上传图片失败");
        }
    }
}
