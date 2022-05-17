package com.example.controller;

import com.example.bean.CollectedJob;
import com.example.bean.Job;
import com.example.service.CollectedJobService;
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

@Controller
@RequestMapping("/recruit")
public class CollectedJobController {
    @Resource
    private JobService jobService;

    @Autowired
    private CollectedJobService collectedJobService;

    @ResponseBody
    @RequestMapping(value= {"/getCollect"}, method={RequestMethod.GET})
    public List<Job> GetDelivered(@RequestParam("userID") String id) {
        List<CollectedJob> collectedJobs=collectedJobService.Select(id);
        List<Job> jobs=new ArrayList<>();
        for (CollectedJob collectedJob:collectedJobs) {
            jobs.add(jobService.Select(collectedJob.getJobID()));
        }
        return jobs;
    }
}
