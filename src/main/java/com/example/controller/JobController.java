package com.example.controller;

import com.example.bean.Job;
import com.example.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/recruit")
public class JobController {
    @Autowired
    private JobService jobService;

    @ResponseBody
    @RequestMapping(value= {"/getJob"}, method={RequestMethod.GET})
    public Job GetJob() {
        return jobService.Sel();
    }
}