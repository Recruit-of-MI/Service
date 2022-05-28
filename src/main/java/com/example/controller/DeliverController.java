package com.example.controller;

import com.example.bean.Deliver;
import com.example.bean.Job;
import com.example.service.DeliverService;
import com.example.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

class JobIfAgreed extends Job{
    public int isAgree;
}
@Controller
@RequestMapping("/recruit")
public class DeliverController {
    @Resource
    private JobService jobService;

    @Autowired
    private DeliverService deliverService;

    @ResponseBody
    @RequestMapping(value= {"/getDelivered"}, method={RequestMethod.GET})
    public List<JobIfAgreed> GetDelivered(@RequestParam("userID") String id) {
        List<Deliver> delivers=deliverService.Select(id);
        List<JobIfAgreed> jobs=new ArrayList<>();
        for (Deliver deliver:delivers) {
            JobIfAgreed jobIfAgreed= (JobIfAgreed) jobService.Select(deliver.getJobID());
            jobIfAgreed.isAgree=deliver.getIsAgree();
            jobs.add(jobIfAgreed);
        }
        return jobs;
    }
    @ResponseBody
    @RequestMapping(value= {"/createDelivered"}, method={RequestMethod.POST})
    public boolean PostUser(@RequestParam("jobID") Integer jobID,
                            @RequestParam("userID") String userID) {
        Deliver deliver = new Deliver();
        deliver.setJobID(jobID);
        deliver.setUserID(userID);
        return deliverService.Insert(deliver);
    }
    @ResponseBody
    @RequestMapping(value= {"/updateDelivered"}, method={RequestMethod.PUT})
    public boolean PutUser(@RequestParam("jobID") Integer jobID,
                           @RequestParam("userID") String userID) {
        Deliver deliver = new Deliver();
        deliver.setJobID(jobID);
        deliver.setUserID(userID);
        return deliverService.Update(deliver);
    }
}
