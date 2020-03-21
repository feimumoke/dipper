package com.dipper.phecda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("febs/views/blog")
@Controller
public class BlogController {
    @GetMapping("/blog")
    public String loginLog() {
        return "febs/views/blog/blog";
    }
}
