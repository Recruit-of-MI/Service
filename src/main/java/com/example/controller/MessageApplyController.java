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
    public List<MessageApply> GetMessageApplyList(@RequestParam("userID") String id) {
        return messageApplyService.Select(id);
    }
    @ResponseBody
    @RequestMapping(value= {"/createApply"}, method={RequestMethod.POST})
    public boolean PostMessageApply(@RequestParam("userID") String userID,
                            @RequestParam("otherID") String otherID,
                            @RequestParam("otherAvatarUrl") String otherAvatarUrl,
                            @RequestParam("otherUserName") String otherUserName,
                            @RequestParam("latestMessage") String latestMessage,
                            @RequestParam("latestMessageTime") String latestMessageTime) {
        MessageApply messageApply = new MessageApply();
        messageApply.setUserID(userID);
        messageApply.setOtherID(otherID);
        messageApply.setOtherAvatarUrl(otherAvatarUrl);
        messageApply.setOtherUserName(otherUserName);
        messageApply.setLatestMessage(latestMessage);
        messageApply.setLatestMessageTime(latestMessageTime);
        return messageApplyService.Insert(messageApply);
    }
    @ResponseBody
    @RequestMapping(value= {"/updateApply"}, method={RequestMethod.PUT})
    public boolean PutMessageApply(@RequestParam("userID") String userID,
                           @RequestParam("otherID") String otherID,
                           @RequestParam("otherAvatarUrl") String otherAvatarUrl,
                           @RequestParam("otherUserName") String otherUserName,
                           @RequestParam("latestMessage") String latestMessage,
                           @RequestParam("latestMessageTime") String latestMessageTime) {
        MessageApply messageApply = new MessageApply();
        messageApply.setUserID(userID);
        messageApply.setOtherID(otherID);
        messageApply.setOtherAvatarUrl(otherAvatarUrl);
        messageApply.setOtherUserName(otherUserName);
        messageApply.setLatestMessage(latestMessage);
        messageApply.setLatestMessageTime(latestMessageTime);
        return messageApplyService.Update(messageApply);
    }
    @ResponseBody
    @RequestMapping(value= {"/deleteApply"}, method={RequestMethod.DELETE})
    public boolean DelMessageApply(@RequestParam("ID") Integer ID){
        return messageApplyService.Delete(ID);
    }
}
