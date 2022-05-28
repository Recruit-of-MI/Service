package com.example.bean;

import lombok.Data;

@Data
public class CollectedJob {
    private Integer ID;
    private String userID;
    private Integer jobID;
    private String createTime;
}