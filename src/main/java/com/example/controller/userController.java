package com.example.controller;

import com.example.bean.user;
import com.example.service.userService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/testSpring")
public class userController {

    @Autowired
    private userService userService;

    @ResponseBody
    @RequestMapping(value= {"/getUser/{id}"}, method={RequestMethod.GET})
    public user GetUser(@PathVariable int id) {
        user result = userService.Sel(id);
        return result;
    }

    @RequestMapping(value= {"postUser"}, method={RequestMethod.POST})
    public String PostUser(@RequestBody String params) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(params);
        user user = new user();
        // user.setId(rootNode.path("id").asInt());
        user.setName(rootNode.path("userName").asText());
        Integer result = userService.Ins(user);
        if (result != 0) {
            return "Commit Success";
        } else {
            return "Commit Fail";
        }

    }
}