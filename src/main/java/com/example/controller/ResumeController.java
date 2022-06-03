package com.example.controller;

import com.example.bean.Resume;
import com.example.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @ResponseBody
    @RequestMapping(value= {"/getResume"}, method={RequestMethod.GET})
    public Resume GetResume(@RequestParam("userID") String id) {
        return resumeService.Select(id);
    }

    @ResponseBody
    @RequestMapping(value= {"/createResume"}, method={RequestMethod.POST})
    public boolean PostResume(@RequestParam("userID") String userID,
                                   @RequestParam("realName") String realname,
                                   @RequestParam("phoneNum") String phonenum,
                                   @RequestParam("birthYear") String birthYear,
                                   @RequestParam("education") String education,
                                   @RequestParam("workYear") String workYear,
                                   @RequestParam("intentionJob") String intentionJob,
                                   @RequestParam("privacy") Integer privacy) {
        Resume resume = new Resume();
        resume.setUserID(userID);
        resume.setRealName(realname);
        resume.setPhoneNum(phonenum);
        resume.setBirthYear(birthYear);
        resume.setEducation(education);
        resume.setWorkYear(workYear);
        resume.setIntentionJob(intentionJob);
        resume.setPrivacy(privacy);
        return resumeService.Insert(resume);
    }

    @ResponseBody
    @RequestMapping(value= {"/updateResume"}, method={RequestMethod.PUT})
    public boolean PutResume(@RequestParam("userID") String userID,
                                  @RequestParam("realName") String realname,
                                  @RequestParam("phoneNum") String phonenum,
                                  @RequestParam("birthYear") String birthYear,
                                  @RequestParam("education") String education,
                                  @RequestParam("workYear") String workYear,
                                  @RequestParam("intentionJob") String intentionJob,
                                  @RequestParam("privacy") Integer privacy) {
        Resume resume = resumeService.Select(userID);
        resume.setRealName(realname);
        resume.setPhoneNum(phonenum);
        resume.setBirthYear(birthYear);
        resume.setEducation(education);
        resume.setWorkYear(workYear);
        resume.setIntentionJob(intentionJob);
        resume.setPrivacy(privacy);
        return resumeService.Update(resume);
    }
}