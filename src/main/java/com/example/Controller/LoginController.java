package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession httpSession) {

        //具体业务!StringUtils.isEmpty(username)&&
        if("1".equals(password)) {
            System.out.println("登陆成功");
            //HttpSession
            httpSession.setAttribute("loginUser",username);
            System.out.println(username);
            return "redirect:http://localhost:8081/#/1";

        }else {
            model.addAttribute("msg","登陆密码错误");
            return "index";
        }
    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/index.html";
    }
}


