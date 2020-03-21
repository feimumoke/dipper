package com.dipper.phecda.controller;

import com.dipper.phecda.entity.MenuTree;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.HashMap;

@RequestMapping
@Controller
public class MenuController {

    @GetMapping("/leftmenu")
    @ResponseBody
    public HashMap<String, MenuTree> getMenu() {
        HashMap<String, MenuTree> result = new HashMap<>();
        try {
            File file = ResourceUtils.getFile("classpath:menu.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            MenuTree menuTree1 = mapper.readValue(file, MenuTree.class);
            System.out.println(mapper.writeValueAsString(menuTree1));
            result.put("data", menuTree1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
