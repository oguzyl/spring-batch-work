package com.work.springbatchwork.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Context;
import javax.naming.InitialContext;

@RestController
public class TestController {

    @GetMapping("/check")
    @ResponseBody
    public String test() {
        return "success";
    };

}
