package com.example.controller;

import com.example.bean.MessageRecruit;
import com.example.service.MessageRecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Message")
public class MessageRecruitController {
    @Autowired
    private MessageRecruitService messageRecruitService;

    @ResponseBody
    @RequestMapping(value= {"/getMessageRecruit"}, method={RequestMethod.GET})
    public MessageRecruit GetIndexresume(@RequestParam("userID") String id) {
        return messageRecruitService.Sel(id);
    }
}
