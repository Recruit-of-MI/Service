package com.example.bean;

import lombok.Data;

@Data
public class Job extends JobShow{
    private String jobType;
    private String userID;
    private String avatarUrl;
    private String jobDescribe;
}
