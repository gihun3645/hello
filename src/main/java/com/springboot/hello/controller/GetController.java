package com.springboot.hello.controller;


import com.springboot.hello.dto.MemberDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    //http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello(){
        return "Hello World";
    }


    //http://localhost:8080/api/v1/get-api/name
    @GetMapping(value="/name")
    public String getName() {
        return "Flature";
    }


//    ### @PathVariable을 활용한 GET 메서드 구현
//    웹 통신의 기본 목적은 데이터를 주고 받는 것 → 대부분 매개변수를 받는 메서드를 작성
//    매개변수를 받을 때 자주 쓰이는 방법 중 하나 → URL 자체에 값을 담아 요청하는 것
    //http://localhost:8080/api/v1/get-api/variable1/{String 값}
    @GetMapping(value="/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }


    //http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    @GetMapping(value="/request1")
    public String getRequestParam1(@RequestParam String name,
                                   @RequestParam String email,
                                   @RequestParam String organization){
        return "이름 : " + name + " " + "이메일 : " + email + " " + "조직 : "+ organization;
    }

    // 쿼리 스트링에 어떤 값이 들어올지 모른다면 Map객체를 활용할 수도 있습니다.
    //http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    @GetMapping(value="/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() +"\n");
        });
        return sb.toString();
    }

    //http://localhost:8080/api/v1/get-api/request3?name=value1&email=value2&organization=value3
    @GetMapping(value="/request3")
    public String getRequestParam3(MemberDto memberDto){
        //return memberDto.getName() + " " + memberDto.getEmail() + " " + memberDto.getOrganization();
        return memberDto.toString();
    }

    //http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    @ApiOperation(value ="GET 메소드 예제", notes = "@RequestParam을 활용한 GET Method")
    @GetMapping(value="/request4")
    public String getRequestParam(
            @ApiParam(value = "이름", required = true)@RequestParam String name,
            @ApiParam(value = "이메일", required = true)@RequestParam String email,
            @ApiParam(value = "회사", required = true)@RequestParam String organization
    )
    {
        return name + " " + email + " " + organization;
    }
}
//클래스 수준에서 @RequestMapping을 선언하면 내부에 선언한 메서드의 URL 리소스 앞에 @RequestMapping의 값이 공통 값으로 추가됨
