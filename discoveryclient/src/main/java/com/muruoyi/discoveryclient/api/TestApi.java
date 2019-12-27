package com.muruoyi.discoveryclient.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {

    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello world";
    }

}
