package com.example.controller;

import com.example.bean.MessageRecruit;
import com.example.service.MessageRecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageRecruitController {
    @Autowired
    private MessageRecruitService messageRecruitService;

    @ResponseBody
    @RequestMapping(value= {"/getRecruit"}, method={RequestMethod.GET})
    public List<MessageRecruit> GetIndexresume(@RequestParam("userID") String id) {
        return messageRecruitService.Select(id);
    }
    @ResponseBody
    @RequestMapping(value= {"/createRecruit"}, method={RequestMethod.POST})
    public boolean PostUser(@RequestParam("userID") String id,
                            @RequestParam("otherUserID") String otherUserID,
                            @RequestParam("otherAvatarUrl") String otherAvatarUrl,
                            @RequestParam("otherUserName") String otherUserName,
                            @RequestParam("latestMessage") String latestMessage) {
        MessageRecruit messageRecruit = new MessageRecruit();
        messageRecruit.setUserID(id);
        messageRecruit.setOtherUserID(otherUserID);
        messageRecruit.setOtherAvatarUrl(otherAvatarUrl);
        messageRecruit.setOtherUserName(otherUserName);
        messageRecruit.setLatestMessage(latestMessage);
        return messageRecruitService.Insert(messageRecruit);
    }
    @ResponseBody
    @RequestMapping(value= {"/updateRecruit"}, method={RequestMethod.PUT})
    public boolean PutUser(@RequestParam("userID") String id,
                           @RequestParam("otherUserID") String otherUserID,
                           @RequestParam("otherAvatarUrl") String otherAvatarUrl,
                           @RequestParam("otherUserName") String otherUserName,
                           @RequestParam("latestMessage") String latestMessage) {
        MessageRecruit messageRecruit = new MessageRecruit();
        messageRecruit.setUserID(id);
        messageRecruit.setOtherUserID(otherUserID);
        messageRecruit.setOtherAvatarUrl(otherAvatarUrl);
        messageRecruit.setOtherUserName(otherUserName);
        messageRecruit.setLatestMessage(latestMessage);
        return messageRecruitService.Update(messageRecruit);
    }
}
