package com.example.bean;

import lombok.Data;

@Data
public class JobShow {
    private Integer jobID;
    private String jobName;
    private Integer jobHighSalary;
    private Integer jobLowSalary;
    private String jobPlace;
    private String education;
    private String jobType;
    private String jobDescribe;
    private String jobWelfare;
}
