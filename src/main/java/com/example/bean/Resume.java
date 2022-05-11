package com.example.bean;

import lombok.Data;

@Data
public class Resume {
    private String userID;
    private String realName;
    private String phoneNum;
    private String birthYear;
    private String education;
    private String exPosition;
    private Integer exSalaryLow;
    private Integer exSalaryHigh;
    private String workArea;
    private Integer isSecret;
}