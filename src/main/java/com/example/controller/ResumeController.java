package com.example.controller;

import com.example.bean.Resume;
import com.example.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/User")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @ResponseBody
    @RequestMapping(value= {"/getResume"}, method={RequestMethod.GET})
    public Resume GetIndexresume(@RequestParam("userID") String id) {
        return resumeService.Select(id);
    }

    @ResponseBody
    @RequestMapping(value= {"createResume"}, method={RequestMethod.POST})
    public boolean PostIndexresume(@RequestParam("userID") String id,
                                   @RequestParam("realName") String realname,
                                   @RequestParam("phoneNum") String phonenum,
                                   @RequestParam("birthYear") String birthYear,
                                   @RequestParam("education") String education,
                                   @RequestParam("exPosition") String exPosition,
                                   @RequestParam("exSalaryLow") Integer exSalaryLow,
                                   @RequestParam("exSalaryLow") Integer exSalaryHigh,
                                   @RequestParam("exSalaryLow") String workArea,
                                   @RequestParam("exSalaryLow") Integer isSecret) {
        Resume resume = new Resume();
        resume.setUserID(id);
        resume.setRealName(realname);
        resume.setPhoneNum(phonenum);
        resume.setBirthYear(birthYear);
        resume.setEducation(education);
        resume.setExPosition(exPosition);
        resume.setExSalaryLow(exSalaryLow);
        resume.setExSalaryHigh(exSalaryHigh);
        resume.setWorkArea(workArea);
        resume.setIsSecret(isSecret);
        return resumeService.Insert(resume);
    }

    @ResponseBody
    @RequestMapping(value= {"updateResume"}, method={RequestMethod.PUT})
    public boolean PutIndexresume(@RequestParam("userID") String id,
                                  @RequestParam("realName") String realname,
                                  @RequestParam("phoneNum") String phonenum,
                                  @RequestParam("birthYear") String birthYear,
                                  @RequestParam("education") String education,
                                  @RequestParam("exPosition") String exPosition,
                                  @RequestParam("exSalaryLow") Integer exSalaryLow,
                                  @RequestParam("exSalaryLow") Integer exSalaryHigh,
                                  @RequestParam("exSalaryLow") String workArea,
                                  @RequestParam("exSalaryLow") Integer isSecret) {
        Resume resume = new Resume();
        resume.setUserID(id);
        resume.setRealName(realname);
        resume.setPhoneNum(phonenum);
        resume.setBirthYear(birthYear);
        resume.setEducation(education);
        resume.setExPosition(exPosition);
        resume.setExSalaryLow(exSalaryLow);
        resume.setExSalaryHigh(exSalaryHigh);
        resume.setWorkArea(workArea);
        resume.setIsSecret(isSecret);
        return resumeService.Update(resume);
    }
}