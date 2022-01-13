package com.jiawa.wiki.controlller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Cxb
 * @Date 2022-01-13 14:33
 */

@RestController
public class TestController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String Hello(){
        return "Hello World";
    }

}
