package com.example.bean;

import lombok.Data;

@Data
public class ChatMessage {
    private String userID;
    private String otherUserID;
    private String avatarUrl;
    private String message;
    private String createTime;
}
