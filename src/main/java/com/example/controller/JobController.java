package com.example.controller;

import com.example.bean.Job;
import com.example.bean.JobSpecific;
import com.example.service.CollectedJobService;
import com.example.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/recruit")
public class JobController {
    @Resource
    private CollectedJobService collectedJobService;

    @Autowired
    private JobService jobService;

    @ResponseBody
    @RequestMapping(value= {"/getJob"}, method={RequestMethod.GET})
    public List<Job> GetAllJob() {
        return jobService.SelectAll();
    }

    @ResponseBody
    @RequestMapping(value= {"/searchJob"}, method={RequestMethod.GET})
    public List<Job> GetJob(@RequestParam("jobKeyWord") String key) {
        return jobService.SelectIncludeKey("%"+key+"%");
    }

    @ResponseBody
    @RequestMapping(value= {"/getHotJob"}, method={RequestMethod.GET})
    public List<Job> GetHotJob(@RequestParam("region") String region) {
        return jobService.SelectNearLatest("%"+region+"%");
    }

    @ResponseBody
    @RequestMapping(value= {"/getLatestJob"}, method={RequestMethod.GET})
    public List<Job> GetLatestJob() {
        return jobService.SelectLatest();
    }

    @ResponseBody
    @RequestMapping(value= {"/getSubsidyJob"}, method={RequestMethod.GET})
    public List<Job> GetSubsidyJob() {
        return jobService.SelectIncludeKey("%补%");
    }

    @ResponseBody
    @RequestMapping(value= {"/getUrgentJob"}, method={RequestMethod.GET})
    public List<Job> GetUrgentJob() {
        return jobService.SelectIncludeKey("%急%");
    }

    @ResponseBody
    @RequestMapping(value= {"/getPartJob"}, method={RequestMethod.GET})
    public List<Job> GetPartJob() {
        return jobService.SelectIncludeKey("%兼职%");
    }

    @ResponseBody
    @RequestMapping(value= {"/getDriver"}, method={RequestMethod.GET})
    public List<Job> GetDriver() {
        return jobService.SelectIncludeKey("%司机%");
    }

    @ResponseBody
    @RequestMapping(value= {"/getSecurity"}, method={RequestMethod.GET})
    public List<Job> GetSecurity() {
        return jobService.SelectIncludeKey("%保安%");
    }

    @ResponseBody
    @RequestMapping(value= {"/getTakeOutClerk"}, method={RequestMethod.GET})
    public List<Job> GetTakeOutClerk() {
        return jobService.SelectIncludeKey("%外卖%");
    }

    @ResponseBody
    @RequestMapping(value= {"/getDaily"}, method={RequestMethod.GET})
    public List<Job> GetDailyJob() {
        return jobService.SelectIncludeKey("%日结%");
    }

    @ResponseBody
    @RequestMapping(value= {"/getHighPayJob"}, method={RequestMethod.GET})
    public List<Job> GetHighPayJob() {
        return jobService.SelectHighPay();
    }

    @ResponseBody
    @RequestMapping(value= {"/getSpecificJobOfUser"}, method={RequestMethod.GET})
    public JobSpecific GetSpecificJob(@RequestParam("userID") String userID,
                                      @RequestParam("JobID") Integer JobID) {
        Job job=jobService.Select(JobID);
        JobSpecific jobSpecific=new JobSpecific();
        jobSpecific.job=job;
        jobSpecific.isCollect=collectedJobService.SelectSpecific(userID, JobID)!=null;
        return jobSpecific;
    }

    @ResponseBody
    @RequestMapping(value= {"/getFamousJob"}, method={RequestMethod.GET})
    public List<Job> GetFamousJob() {
        return jobService.SelectLatest();
    }

    @ResponseBody
    @RequestMapping(value= {"/getSend"}, method={RequestMethod.GET})
    public List<Job> GetSend(@RequestParam("userID") String userID) {
        return jobService.SelectSend(userID);
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
        if(!Objects.equals(welfare1, "")) job.setWelfare1(welfare1);
        if(!Objects.equals(welfare2, "")) job.setWelfare2(welfare2);
        if(!Objects.equals(welfare3, "")) job.setWelfare3(welfare3);
        if(!Objects.equals(welfare4, "")) job.setWelfare4(welfare4);
        if(!Objects.equals(welfare5, "")) job.setWelfare5(welfare5);
        if(!Objects.equals(label1, "")) job.setLabel1(label1);
        if(!Objects.equals(label2, "")) job.setLabel2(label2);
        if(!Objects.equals(label3, "")) job.setLabel3(label3);
        return jobService.Insert(job);
    }
    @ResponseBody
    @RequestMapping(value= {"/updateJob"}, method={RequestMethod.PUT})
    public boolean PutJob( @RequestParam("jobID") Integer jobID,
                           @RequestParam("recruitPosition") String recruitPosition,
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
        Job job = jobService.Select(jobID);
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
        if(!Objects.equals(welfare1, "")) job.setWelfare1(welfare1);
        if(!Objects.equals(welfare2, "")) job.setWelfare2(welfare2);
        if(!Objects.equals(welfare3, "")) job.setWelfare3(welfare3);
        if(!Objects.equals(welfare4, "")) job.setWelfare4(welfare4);
        if(!Objects.equals(welfare5, "")) job.setWelfare5(welfare5);
        if(!Objects.equals(label1, "")) job.setLabel1(label1);
        if(!Objects.equals(label2, "")) job.setLabel2(label2);
        if(!Objects.equals(label3, "")) job.setLabel3(label3);
        return jobService.Update(job);
    }
}
