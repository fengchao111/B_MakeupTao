package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
    @RequestMapping(value = "/dist.htm",method = RequestMethod.GET)
    public String toregist()
    {
        System.out.println("iiiii");
        return "/WEB-INF/dist/dist.html";
    }
}
