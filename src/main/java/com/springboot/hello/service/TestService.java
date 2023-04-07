package com.springboot.hello.service;

import com.springboot.hello.dao.TestDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// dao를 관리입
@Service
public class TestService {
    @Autowired
    TestDAO testDAO;

    public String getNums(){
        Long num = testDAO.getNumber();
        String ans;
        ans = "총 동물의 수는 " + num.toString() + "마리 입니다.";

        return ans;
    }

    public String getAllAnimals(){
        String ans;
        ans = testDAO.getCat() + " " + testDAO.getDog() + " " + testDAO.getQuokka();
        return ans;
    }
}