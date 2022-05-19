package com.example.controller;

import com.example.bean.Job;
import com.example.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/recruit")
public class JobController {
    @Autowired
    private JobService jobService;

    @ResponseBody
    @RequestMapping(value= {"/getJob"}, method={RequestMethod.GET})
    public List<Job> GetJob() {
        return jobService.SelectAll();
    }
    @ResponseBody
    @RequestMapping(value= {"/createJob"}, method={RequestMethod.POST})
    public boolean PostUser(@RequestParam("jobName") String jobName,
                            @RequestParam("jobHighSalary") Integer jobHighSalary,
                            @RequestParam("jobLowSalary") Integer jobLowSalary,
                            @RequestParam("jobPlace") String jobPlace,
                            @RequestParam("education") String education,
                            @RequestParam("jobType") String jobType,
                            @RequestParam("jobDescribe") String jobDescribe,
                            @RequestParam("jobWelfare") String jobWelfare,
                            @RequestParam("userID") String userID,
                            @RequestParam("avatarUrl") String avatarUrl) {
        Job job = new Job();
        job.setJobName(jobName);
        job.setJobHighSalary(jobHighSalary);
        job.setJobLowSalary(jobLowSalary);
        job.setJobPlace(jobPlace);
        job.setEducation(education);
        job.setJobType(jobType);
        job.setJobDescribe(jobDescribe);
        job.setJobWelfare(jobWelfare);
        job.setUserID(userID);
        job.setAvatarUrl(avatarUrl);
        return jobService.Insert(job);
    }
    @ResponseBody
    @RequestMapping(value= {"/updateJob"}, method={RequestMethod.PUT})
    public boolean PutUser(@RequestParam("jobName") String jobName,
                           @RequestParam("jobHighSalary") Integer jobHighSalary,
                           @RequestParam("jobLowSalary") Integer jobLowSalary,
                           @RequestParam("jobPlace") String jobPlace,
                           @RequestParam("education") String education,
                           @RequestParam("jobType") String jobType,
                           @RequestParam("jobDescribe") String jobDescribe,
                           @RequestParam("jobWelfare") String jobWelfare,
                           @RequestParam("userID") String userID,
                           @RequestParam("avatarUrl") String avatarUrl) {
        Job job = new Job();
        job.setJobName(jobName);
        job.setJobHighSalary(jobHighSalary);
        job.setJobLowSalary(jobLowSalary);
        job.setJobPlace(jobPlace);
        job.setEducation(education);
        job.setJobType(jobType);
        job.setJobDescribe(jobDescribe);
        job.setJobWelfare(jobWelfare);
        job.setUserID(userID);
        job.setAvatarUrl(avatarUrl);
        return jobService.Update(job);
    }
}
