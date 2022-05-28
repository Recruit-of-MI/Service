package com.example.bean;

import lombok.Data;

@Data
public class Resume {
    private String userID;
    private String realName;
    private String phoneNum;
    private String birthYear;
    private String education;
    private String workYear;
    private String intentionJob;
    private Integer privacy;
}