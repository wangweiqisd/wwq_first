package com.zy.tow.Controller;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@EnableCaching
@Slf4j
@Controller
@RequestMapping
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);
    @RequestMapping("hello")
    @ResponseBody
    public String say(){
        log.info("hello,小宝贝");
        System.out.println("hello,小宝sa贝");
        return "225";
    }
}
