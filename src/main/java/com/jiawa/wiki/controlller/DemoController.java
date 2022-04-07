package com.jiawa.wiki.controlller;

import com.jiawa.wiki.domain.Demo;
import com.jiawa.wiki.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Cxb
 * @Date 2022-01-13 14:33
 */

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private DemoService demoService;

    @RequestMapping("/list")
    public List<Demo> list(){
        return demoService.list();
    }
}
