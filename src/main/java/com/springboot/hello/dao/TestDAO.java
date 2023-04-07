package com.springboot.hello.dao;


import org.springframework.stereotype.Component;

// 데이터를 돌려줌
// 의존성 주입
@Component
public class TestDAO {

    public String getDog(){
        return "강아지";
    }

    public String getCat(){
        return "고양이";
    }

    public String getQuokka(){
        return "쿼카";
    }

    public Long getNumber(){
        return 1L;
    }
}
