package com.example.Service;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import com.example.Utils.HttpRestUtils;


public class Verification {
     public static String postVerification(String code,String name){
        try{
            //api url地址
            String url = "http://43.143.211.83:8080/addCodeList?code="+code+"&name="+name;
            // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
            MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
            params.add("name", name);
            params.add("code", code);
            System.out.println(name);
            System.out.println(code);
            System.out.print("发送数据："+params.toString());
            //发送http请求并返回结果
            String result = HttpRestUtils.sendRequest(url,"GET");
            System.out.print("接收反馈："+result);
            return result;
        }catch (Exception e){
            System.out.println( "----------------出现异常 Exception---------------------");
            System.out.println(e.getMessage());
            return "";
        }
    }


}
