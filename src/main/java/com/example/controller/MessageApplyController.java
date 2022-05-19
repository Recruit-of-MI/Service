package com.example.controller;

import com.example.bean.MessageApply;
import com.example.service.MessageApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageApplyController {
    @Autowired
    private MessageApplyService messageApplyService;

    @ResponseBody
    @RequestMapping(value= {"/getApply"}, method={RequestMethod.GET})
    public List<MessageApply> GetIndexresume(@RequestParam("userID") String id) {
        return messageApplyService.Select(id);
    }
    @ResponseBody
    @RequestMapping(value= {"/createApply"}, method={RequestMethod.POST})
    public boolean PostUser(@RequestParam("userID") String id,
                            @RequestParam("otherUserID") String otherUserID,
                            @RequestParam("otherAvatarUrl") String otherAvatarUrl,
                            @RequestParam("otherUserName") String otherUserName,
                            @RequestParam("latestMessage") String latestMessage) {
        MessageApply messageApply = new MessageApply();
        messageApply.setUserID(id);
        messageApply.setOtherUserID(otherUserID);
        messageApply.setOtherAvatarUrl(otherAvatarUrl);
        messageApply.setOtherUserName(otherUserName);
        messageApply.setLatestMessage(latestMessage);
        return messageApplyService.Insert(messageApply);
    }
    @ResponseBody
    @RequestMapping(value= {"/updateApply"}, method={RequestMethod.PUT})
    public boolean PutUser(@RequestParam("userID") String id,
                           @RequestParam("otherUserID") String otherUserID,
                           @RequestParam("otherAvatarUrl") String otherAvatarUrl,
                           @RequestParam("otherUserName") String otherUserName,
                           @RequestParam("latestMessage") String latestMessage) {
        MessageApply messageApply = new MessageApply();
        messageApply.setUserID(id);
        messageApply.setOtherUserID(otherUserID);
        messageApply.setOtherAvatarUrl(otherAvatarUrl);
        messageApply.setOtherUserName(otherUserName);
        messageApply.setLatestMessage(latestMessage);
        return messageApplyService.Update(messageApply);
    }
}
