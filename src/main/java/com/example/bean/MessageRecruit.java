package com.example.bean;

import lombok.Data;

@Data
public class MessageRecruit {
    private Integer ID;
    private String userID;
    private String otherID;
    private String otherAvatarUrl;
    private String otherUserName;
    private String latestMessage;
    private String latestMessageTime;
}
