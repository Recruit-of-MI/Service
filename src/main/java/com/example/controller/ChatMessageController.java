package com.example.controller;

import com.example.bean.ChatMessage;
import com.example.service.ChatMessageService;
import com.example.service.MessageApplyService;
import com.example.service.MessageRecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/message")
public class ChatMessageController {
    @Resource
    private MessageApplyService messageApplyService;

    @Resource
    private MessageRecruitService messageRecruitService;

    @Autowired
    private ChatMessageService chatMessageService;

    @ResponseBody
    @RequestMapping(value= {"/getChat"}, method={RequestMethod.GET})
    public List<ChatMessage> GetChatMessageList(@RequestParam("userID") String userID,
                                                @RequestParam("otherID") String otherID) {
        return chatMessageService.Select(userID,otherID);
    }

    @ResponseBody
    @RequestMapping(value= {"/createChat"}, method={RequestMethod.POST})
    public boolean PostChatMessage(@RequestParam("userID") String userID,
                                    @RequestParam("otherID") String otherID,
                                    @RequestParam("avatarUrl") String avatarUrl,
                                    @RequestParam("otherAvatarUrl") String otherAvatarUrl,
                                    @RequestParam("userName") String userName,
                                    @RequestParam("otherUserName") String otherUserName,
                                    @RequestParam("speaker") String speaker,
                                    @RequestParam("contentType") String contentType,
                                    @RequestParam("content") String content) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUserID(userID);
        chatMessage.setOtherID(otherID);
        chatMessage.setOtherUserName(otherUserName);
        chatMessage.setOtherAvatarUrl(otherAvatarUrl);
        chatMessage.setSpeaker(speaker);
        chatMessage.setContentType(contentType);
        chatMessage.setContent(content);
        messageApplyService.UpdateByChat(userID, otherID, otherAvatarUrl, otherUserName, content);
        messageRecruitService.UpdateByChat(userID, otherID, otherAvatarUrl, otherUserName, content);
        return chatMessageService.Insert(chatMessage)&&PostChatMessage(chatMessage,avatarUrl,userName);
    }
    public boolean PostChatMessage(ChatMessage chatMessage,String avatarUrl,String userName) {
        String tem=chatMessage.getUserID();
        chatMessage.setUserID(chatMessage.getOtherID());
        chatMessage.setOtherID(tem);
        chatMessage.setOtherUserName(userName);
        chatMessage.setOtherAvatarUrl(avatarUrl);
        messageApplyService.UpdateByChat(chatMessage.getUserID(), chatMessage.getOtherID(), avatarUrl, userName, chatMessage.getContent());
        messageRecruitService.UpdateByChat(chatMessage.getUserID(), chatMessage.getOtherID(), avatarUrl, userName, chatMessage.getContent());
        return chatMessageService.Insert(chatMessage);
    }

    @ResponseBody
    @RequestMapping(value= {"/updateChat"}, method={RequestMethod.PUT})
    public boolean PutChatMessage(@RequestParam("userID") String userID,
                                   @RequestParam("otherID") String otherID,
                                   @RequestParam("otherAvatarUrl") String otherAvatarUrl,
                                   @RequestParam("contentType") String contentType,
                                   @RequestParam("content") String content) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUserID(userID);
        chatMessage.setOtherID(otherID);
        chatMessage.setOtherAvatarUrl(otherAvatarUrl);
        chatMessage.setContentType(contentType);
        chatMessage.setContent(content);
        return chatMessageService.Update(chatMessage);
    }
}
