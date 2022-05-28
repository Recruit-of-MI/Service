package com.example.bean;

import lombok.Data;

@Data
public class Deliver {
    private Integer ID;
    private String userID;
    private Integer jobID;
    private String userName;
    private Integer isAgree;
    private String createTime;
}
