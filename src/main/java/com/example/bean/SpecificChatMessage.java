package com.example.bean;

import lombok.Data;

@Data
public class SpecificChatMessage {
    private String userID;
    private String otherUserID;
    private String avatarUrl;
    private String message;
    private String createTime;
}
