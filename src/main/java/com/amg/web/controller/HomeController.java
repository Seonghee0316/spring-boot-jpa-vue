package com.amg.web.controller;

import com.amg.web.common.util.Printer;
import com.amg.web.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HomeController
 */
@Controller
public class HomeController {
    @Autowired CustomerService CustomerService; // 연결됨
    @Autowired Printer p;
    @RequestMapping("/") // 어떤 url과 매핑하는가 "/"는 root url Bean은 빈인데 매핑이라 함. "/"이게 들어오면 밑에껄 하라. "Bean으로
                         // 등록되려면 class만 가능"

    public String index() {
        p.accept("람다 이후 루트 url 경로로 들어옴");
        int count = CustomerService.countAll();

        p.accept("람다가 출력한 고객의 총인원 : " + count);
        return "index";
    }
    
}