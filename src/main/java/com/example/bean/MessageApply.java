package com.example.bean;

import lombok.Data;

@Data
public class MessageApply {
    private String userID;
    private String otherUserID;
    private String otherAvatarUrl;
    private String otherUserName;
    private String latestMessage;
}
