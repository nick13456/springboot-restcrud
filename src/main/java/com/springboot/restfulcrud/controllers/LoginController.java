package com.springboot.restfulcrud.controllers;

import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/userlogin")
    public String login(@RequestParam String username, @RequestParam String password, Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username)&&"123456".equals(password)){
            session.setAttribute("loggedUser",username);
            return "redirect:/main.html";
        }else{
            map.put("msg","用户名或密码错误");
            return "login";
        }
    }

    /**
     * 测试form表单多个相同name的input值是否会被拼成字符串
     * 可以直接用字符串String来接收，也可以用String[] 数组来接收。
     * 如通过是用Integer来接收多个数字，则必须是 Integer[] 数组来接收
     * @param lastName
     * @param ages
     * @return
     */
    @GetMapping("/showStats")
    public String login(@RequestParam("lastName") String lastName,@RequestParam("ages") Integer[] ages){
        System.out.println(lastName);
        System.out.println(Arrays.toString(ages));
        return "success";
    }

    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}
