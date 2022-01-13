package com.jiawa.wiki.controlller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Cxb
 * @Date 2022-01-13 14:33
 */

@RestController
public class TestController {

    @Value("${test.hello:TEST123}")
    private String testHello;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String Hello(){
        return "Hello World " + testHello;
    }

    @RequestMapping(value = "/hello/post",method = RequestMethod.POST)
    public String HelloPost(String name ){
        return "Hello World  " + name;
    }

}
