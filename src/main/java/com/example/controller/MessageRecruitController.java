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
    public List<MessageRecruit> GetMessageRecruitList(@RequestParam("userID") String id) {
        return messageRecruitService.Select(id);
    }
    @ResponseBody
    @RequestMapping(value= {"/createRecruit"}, method={RequestMethod.POST})
    public boolean PostMessageRecruit(@RequestParam("userID") String userID,
                            @RequestParam("otherID") String otherID,
                            @RequestParam("otherAvatarUrl") String otherAvatarUrl,
                            @RequestParam("otherUserName") String otherUserName,
                            @RequestParam("latestMessage") String latestMessage,
                            @RequestParam("latestMessageTime") String latestMessageTime) {
        MessageRecruit messageRecruit = new MessageRecruit();
        messageRecruit.setUserID(userID);
        messageRecruit.setOtherID(otherID);
        messageRecruit.setOtherAvatarUrl(otherAvatarUrl);
        messageRecruit.setOtherUserName(otherUserName);
        messageRecruit.setLatestMessage(latestMessage);
        messageRecruit.setLatestMessageTime(latestMessageTime);
        return messageRecruitService.Insert(messageRecruit);
    }
    @ResponseBody
    @RequestMapping(value= {"/updateRecruit"}, method={RequestMethod.PUT})
    public boolean PutMessageRecruit(@RequestParam("userID") String userID,
                           @RequestParam("otherID") String otherID,
                           @RequestParam("otherAvatarUrl") String otherAvatarUrl,
                           @RequestParam("otherUserName") String otherUserName,
                           @RequestParam("latestMessage") String latestMessage,
                           @RequestParam("latestMessageTime") String latestMessageTime) {
        MessageRecruit messageRecruit = new MessageRecruit();
        messageRecruit.setUserID(userID);
        messageRecruit.setOtherID(otherID);
        messageRecruit.setOtherAvatarUrl(otherAvatarUrl);
        messageRecruit.setOtherUserName(otherUserName);
        messageRecruit.setLatestMessage(latestMessage);
        messageRecruit.setLatestMessageTime(latestMessageTime);
        return messageRecruitService.Update(messageRecruit);
    }
    @ResponseBody
    @RequestMapping(value= {"/deleteRecruit"}, method={RequestMethod.DELETE})
    public boolean DelMessageRecruit(@RequestParam("ID") Integer ID){
        return messageRecruitService.Delete(ID);
    }
}
