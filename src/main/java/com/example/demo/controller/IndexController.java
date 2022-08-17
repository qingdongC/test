package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * xx类
 *
 * @Author chenqingdong
 * @Date 2021/3/29
 * @Version 1.0.0
 */
@Controller
public class IndexController {

    @RequestMapping(value = "index")
    public String index(){
        System.out.println("111");
        return "nav.html";
    }

}
