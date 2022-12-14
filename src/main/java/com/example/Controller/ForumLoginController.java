package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin
public class ForumLoginController {
    @RequestMapping("/forum_login")
    @ResponseBody
    public String login(@RequestParam("forum_email") String forum_email, @RequestParam("forum_pwd") String forum_pwd, HttpServletResponse response, HttpServletRequest request) {
        Cookie cookie = new Cookie("userEmail", forum_email);
        //add cookie to response
        response.addCookie(cookie);

        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
            for (Cookie cookie1 : cookies) {
                System.out.println(cookie1.getName());
            }
        }
        return "cookie is OK";
        //System.out.println(username);
    }

    @RequestMapping("/forum_logout")
    public String logout(HttpServletRequest request,HttpServletResponse response) {
        System.out.println(request.getCookies());
        Cookie newCookie=new Cookie("userEmail",""); //假如要删除名称为username的Cookie JSESSIONID是cookie名 记得换成要删除的
        newCookie.setPath("/");
        newCookie.setMaxAge(0); //立即删除型
        response.addCookie(newCookie); //重新写入，将覆盖之前的
        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
            for (Cookie cookie1 : cookies) {
                System.out.println(cookie1.getName());
            }
        }
        return "redirect:/index.html";
    }

    @RequestMapping("/getUserCookie")
    @ResponseBody
    public String getUserCookie(HttpServletRequest request,HttpServletResponse response) {
        System.out.println(request.getCookies());
        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
            for (Cookie cookie1 : cookies) {
                System.out.println(cookie1.getName());
            }
        }
        if(cookies!=null) {
            for (Cookie cookie1 : cookies) {
                if(cookie1.getName().equals("userEmail"))
                    return cookie1.getValue();
            }
        }
        return "no cookie";
    }
}
