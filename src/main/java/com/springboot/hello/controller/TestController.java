package com.springboot.hello.controller;

import com.springboot.hello.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // 제어의 역전(객체의 관리 권한을 외부 컨테이너에 위힘함)
    @Autowired
    TestService testService;

    @RequestMapping("/getAnimalNums")
    public String getAnimalNums() {
        String str = testService.getNums();
        System.out.println("가지고 온 데이터: "+str);
        return str;
    }

    @RequestMapping("/getAllAnimals")
    public String getAllAnimals() {
        String str = testService.getAllAnimals();
        System.out.println("가지고 온 데이터: "+str);
        return str;
    }
}