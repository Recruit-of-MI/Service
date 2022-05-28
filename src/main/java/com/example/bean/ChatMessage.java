package com.example.bean;

import lombok.Data;

@Data
public class ChatMessage {
    private Integer ID;
    private String userID;
    private String otherID;
    private String otherAvatarUrl;
    private String contentType;
    private String content;
    private String createTime;
}
