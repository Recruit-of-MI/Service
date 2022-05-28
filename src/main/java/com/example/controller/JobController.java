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
    public List<Job> GetAllJob() {
        return jobService.SelectAll();
    }

    @ResponseBody
    @RequestMapping(value= {"/searchJob"}, method={RequestMethod.GET})
    public List<Job> GetJob(@RequestParam("jobKeyWord") String jobKeyWord) {
        return jobService.SelectAll();
    }

    @ResponseBody
    @RequestMapping(value= {"/getHotJob"}, method={RequestMethod.GET})
    public List<Job> GetHotJob(@RequestParam("region") String region) {
        return jobService.SelectAll();
    }

    @ResponseBody
    @RequestMapping(value= {"/getUrgentJob"}, method={RequestMethod.GET})
    public List<Job> GetUrgentJob() {
        return jobService.SelectAll();
    }

    @ResponseBody
    @RequestMapping(value= {"/getDriver"}, method={RequestMethod.GET})
    public List<Job> GetDriver() {
        return jobService.SelectAll();
    }

    @ResponseBody
    @RequestMapping(value= {"/getDailyJob"}, method={RequestMethod.GET})
    public List<Job> GetDailyJob() {
        return jobService.SelectAll();
    }

    @ResponseBody
    @RequestMapping(value= {"/getHighPayJob"}, method={RequestMethod.GET})
    public List<Job> GetHighPayJob() {
        return jobService.SelectAll();
    }

    @ResponseBody
    @RequestMapping(value= {"/getSpecificJob"}, method={RequestMethod.GET})
    public List<Job> GetSpecificJob(@RequestParam("JobID") Integer JobID) {
        return jobService.SelectAll();
    }

    @ResponseBody
    @RequestMapping(value= {"/getFamousJob"}, method={RequestMethod.GET})
    public List<Job> GetFamousJob() {
        return jobService.SelectAll();
    }

    @ResponseBody
    @RequestMapping(value= {"/getSend"}, method={RequestMethod.GET})
    public List<Job> GetSend(@RequestParam("userID") Integer userID) {
        return jobService.SelectAll();
    }

    @ResponseBody
    @RequestMapping(value= {"/createJob"}, method={RequestMethod.POST})
    public boolean PostJob(@RequestParam("recruitPosition") String recruitPosition,
                            @RequestParam("jobTitle") String jobTitle,
                            @RequestParam("maxWages") Integer maxWages,
                            @RequestParam("minWages") Integer minWages,
                            @RequestParam("region") String region,
                            @RequestParam("specificLocation") String specificLocation,
                            @RequestParam("corporateName") String corporateName,
                            @RequestParam("minEducation") String minEducation,
                            @RequestParam("mode") String mode,
                            @RequestParam("jobDescription") String jobDescription,
                            @RequestParam("recruitNum") Integer recruitNum,
                            @RequestParam("userID") String userID,
                            @RequestParam("publisherName") String publisherName,
                            @RequestParam("publisherAvatarUrl") String publisherAvatarUrl,
                            @RequestParam("welfare1") String welfare1,
                            @RequestParam("welfare2") String welfare2,
                            @RequestParam("welfare3") String welfare3,
                            @RequestParam("welfare4") String welfare4,
                            @RequestParam("welfare5") String welfare5,
                            @RequestParam("label1") String label1,
                            @RequestParam("label2") String label2,
                            @RequestParam("label3") String label3) {
        Job job = new Job();
        job.setRecruitPosition(recruitPosition);
        job.setJobTitle(jobTitle);
        job.setMaxWages(maxWages);
        job.setMinWages(minWages);
        job.setRegion(region);
        job.setSpecificLocation(specificLocation);
        job.setCorporateName(corporateName);
        job.setMinEducation(minEducation);
        job.setMode(mode);
        job.setJobDescription(jobDescription);
        job.setRecruitNum(recruitNum);
        job.setUserID(userID);
        job.setPublisherName(publisherName);
        job.setPublisherAvatarUrl(publisherAvatarUrl);
        if(welfare1!=null) job.setWelfare1(welfare1);
        if(welfare2!=null) job.setWelfare1(welfare2);
        if(welfare3!=null) job.setWelfare1(welfare3);
        if(welfare4!=null) job.setWelfare1(welfare4);
        if(welfare5!=null) job.setWelfare1(welfare5);
        if(label1!=null) job.setWelfare1(label1);
        if(label2!=null) job.setWelfare1(label2);
        if(label3!=null) job.setWelfare1(label3);
        return jobService.Insert(job);
    }
    @ResponseBody
    @RequestMapping(value= {"/updateJob"}, method={RequestMethod.PUT})
    public boolean PutJob(@RequestParam("recruitPosition") String recruitPosition,
                           @RequestParam("jobTitle") String jobTitle,
                           @RequestParam("maxWages") Integer maxWages,
                           @RequestParam("minWages") Integer minWages,
                           @RequestParam("region") String region,
                           @RequestParam("specificLocation") String specificLocation,
                           @RequestParam("corporateName") String corporateName,
                           @RequestParam("minEducation") String minEducation,
                           @RequestParam("mode") String mode,
                           @RequestParam("jobDescription") String jobDescription,
                           @RequestParam("recruitNum") Integer recruitNum,
                           @RequestParam("userID") String userID,
                           @RequestParam("publisherName") String publisherName,
                           @RequestParam("publisherAvatarUrl") String publisherAvatarUrl,
                           @RequestParam("welfare1") String welfare1,
                           @RequestParam("welfare2") String welfare2,
                           @RequestParam("welfare3") String welfare3,
                           @RequestParam("welfare4") String welfare4,
                           @RequestParam("welfare5") String welfare5,
                           @RequestParam("label1") String label1,
                           @RequestParam("label2") String label2,
                           @RequestParam("label3") String label3) {
        Job job = new Job();
        job.setRecruitPosition(recruitPosition);
        job.setJobTitle(jobTitle);
        job.setMaxWages(maxWages);
        job.setMinWages(minWages);
        job.setRegion(region);
        job.setSpecificLocation(specificLocation);
        job.setCorporateName(corporateName);
        job.setMinEducation(minEducation);
        job.setMode(mode);
        job.setJobDescription(jobDescription);
        job.setRecruitNum(recruitNum);
        job.setUserID(userID);
        job.setPublisherName(publisherName);
        job.setPublisherAvatarUrl(publisherAvatarUrl);
        if(welfare1!=null) job.setWelfare1(welfare1);
        if(welfare2!=null) job.setWelfare1(welfare2);
        if(welfare3!=null) job.setWelfare1(welfare3);
        if(welfare4!=null) job.setWelfare1(welfare4);
        if(welfare5!=null) job.setWelfare1(welfare5);
        if(label1!=null) job.setWelfare1(label1);
        if(label2!=null) job.setWelfare1(label2);
        if(label3!=null) job.setWelfare1(label3);
        return jobService.Update(job);
    }
}
