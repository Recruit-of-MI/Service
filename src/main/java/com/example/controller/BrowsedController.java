package com.example.controller;

import com.example.bean.Browsed;
import com.example.bean.Job;
import com.example.service.BrowsedService;
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
public class BrowsedController {
    @Resource
    private JobService jobService;

    @Autowired
    private BrowsedService browsedService;

    @ResponseBody
    @RequestMapping(value= {"/getBrowsed"}, method={RequestMethod.GET})
    public List<Job> GetDelivered(@RequestParam("userID") String id) {
        List<Browsed> Browseds=browsedService.Select(id);
        List<Job> jobs=new ArrayList<>();
        for (Browsed Browsed:Browseds) {
            jobs.add(jobService.Select(Browsed.getJobID()));
        }
        return jobs;
    }
}
