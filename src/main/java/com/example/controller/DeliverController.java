package com.example.controller;

import com.example.bean.Deliver;
import com.example.bean.JobIfAgreed;
import com.example.bean.UserIfAgreed;
import com.example.service.DeliverService;
import com.example.service.JobService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/recruit")
public class DeliverController {
    @Resource
    private JobService jobService;

    @Resource
    private UserService userService;

    @Autowired
    private DeliverService deliverService;

    @ResponseBody
    @RequestMapping(value= {"/getDelivered"}, method={RequestMethod.GET})
    public List<JobIfAgreed> GetDelivered(@RequestParam("userID") String id) {
        List<Deliver> delivers=deliverService.Select(id);
        List<JobIfAgreed> jobs=new ArrayList<>();
        for (Deliver deliver:delivers) {
            JobIfAgreed jobIfAgreed= new JobIfAgreed();
            jobIfAgreed.job=jobService.Select(deliver.getJobID());
            jobIfAgreed.isAgree=deliver.getIsAgree();
            jobs.add(jobIfAgreed);
        }
        return jobs;
    }

    @ResponseBody
    @RequestMapping(value= {"/getDeliveredForJob"}, method={RequestMethod.GET})
    public List<UserIfAgreed> GetDeliveredForJob(@RequestParam("jobID") Integer jobID) {
        List<Deliver> delivers=deliverService.SelectUser(jobID);
        List<UserIfAgreed> users=new ArrayList<>();
        for (Deliver deliver:delivers) {
            UserIfAgreed userIfAgreed= new UserIfAgreed();
            userIfAgreed.user=userService.Select(deliver.getUserID());
            userIfAgreed.isAgree=deliver.getIsAgree();
            users.add(userIfAgreed);
        }
        return users;
    }
    @ResponseBody
    @RequestMapping(value= {"/createDelivered"}, method={RequestMethod.POST})
    public boolean PostDeliver( @RequestParam("jobID") Integer jobID,
                                @RequestParam("userID") String userID,
                                @RequestParam("userName") String userName) {
        Deliver deliver = new Deliver();
        deliver.setJobID(jobID);
        deliver.setUserID(userID);
        deliver.setUserName(userName);
        return deliverService.Insert(deliver);
    }
    @ResponseBody
    @RequestMapping(value= {"/updateDelivered"}, method={RequestMethod.PUT})
    public boolean PutDeliver(@RequestParam("jobID") Integer jobID,
                              @RequestParam("userID") String userID) {
        Deliver deliver = new Deliver();
        deliver.setJobID(jobID);
        deliver.setUserID(userID);
        return deliverService.Update(deliver);
    }
    @ResponseBody
    @RequestMapping(value= {"/agreeDeliver"}, method={RequestMethod.PUT})
    public boolean AgreeDeliver(@RequestParam("jobID") Integer jobID,
                                @RequestParam("userID") String userID) {
        Deliver deliver = deliverService.SelectOne(userID,jobID);
        deliver.setIsAgree(1);
        return deliverService.Update(deliver);
    }
    @ResponseBody
    @RequestMapping(value= {"/disagreeDeliver"}, method={RequestMethod.PUT})
    public boolean DisagreeDeliver(@RequestParam("jobID") Integer jobID,
                                   @RequestParam("userID") String userID) {
        Deliver deliver = deliverService.SelectOne(userID,jobID);
        deliver.setIsAgree(2);
        return deliverService.Update(deliver);
    }
}
