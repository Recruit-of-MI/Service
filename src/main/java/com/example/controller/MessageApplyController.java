package com.example.controller;

import com.example.bean.MessageApply;
import com.example.service.MessageApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/message/apply")
public class MessageApplyController {
    @Autowired
    private MessageApplyService messageApplyService;

    @ResponseBody
    @RequestMapping(value= {"/show"}, method={RequestMethod.GET})
    public MessageApply GetIndexresume(@RequestParam("userID") String id) {
        return messageApplyService.Sel(id);
    }
}
