package com.hhstu.thymeleafdemo.controller;

import com.hhstu.thymeleafdemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("msg","SpringBoot集成Thymeleaf");
        //return 就是你页面的路径名称,默认路径在templates路径下（不需要带.html后缀）
        User user = new User();
        user.setId(1);
        user.setNick("李林超博客");
        user.setPhone("123445566");
        user.setEmail("996@163.com");
        user.setAddress("北京朝阳区");
        model.addAttribute("user",user);

        List<User> userList = new ArrayList<>();
        //Map集合
        Map<String,Object> userMap = new HashMap<>();

        for(int i=0;i<10;i++){
            User user1 = new User();
            user1.setId(i);
            user1.setNick("李林超博客"+i);
            user1.setPhone("12344556"+i);
            user1.setEmail(i+"996@163.com");
            user1.setAddress("北京朝阳区"+i);
            userList.add(user1);
            userMap.put(String.valueOf(i),user1);
        }
        model.addAttribute("userList",userList);
        model.addAttribute("userMap",userMap);

        model.addAttribute("sex",1);
        return "index";
    }
}
