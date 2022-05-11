package com.example.controller;

import com.example.bean.Deliver;
import com.example.bean.Job;
import com.example.service.DeliverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/recruit")
public class DeliverController {
    @Autowired
    private DeliverService deliverService;

    @ResponseBody
    @RequestMapping(value= {"/getDelivered"}, method={RequestMethod.GET})
    public List<Job> GetDelivered(@RequestParam("userID") String id) {
        List<Deliver> delivers=deliverService.Select(id);
        List<Job> jobs=new ArrayList<>();
        for (Deliver deliver:delivers) {
            jobs.add(deliverService.Sel(deliver.getJobID()));
        }
        return jobs;
    }
}
