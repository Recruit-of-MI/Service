package com.example.bean;

import lombok.Data;

@Data
public class ChatMessage {
    private Integer ID;
    private String userID;
    private String otherID;
    private String otherUserName;
    private String otherAvatarUrl;
    private String speaker;
    private String contentType;
    private String content;
    private String createTime;
}
