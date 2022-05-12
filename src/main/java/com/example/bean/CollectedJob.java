package com.example.bean;

import lombok.Data;

@Data
public class CollectedJob {
    private String userID;
    private Integer jobID;
    private String createTime;
}