package com.example.controller;

import com.example.bean.Indexresume;
import com.example.service.IndexresumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/User")
public class IndexresumeController {

    @Autowired
    private IndexresumeService indexresumeService;

    @ResponseBody
    @RequestMapping(value= {"/getIndexresume"}, method={RequestMethod.GET})
    public Indexresume GetIndexresume(@RequestParam("userID") String id) {
        return indexresumeService.Sel(id);
    }

    @ResponseBody
    @RequestMapping(value= {"createIndexresume"}, method={RequestMethod.POST})
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
        Indexresume indexresume = new Indexresume();
        indexresume.setUserID(id);
        indexresume.setRealName(realname);
        indexresume.setPhoneNum(phonenum);
        indexresume.setBirthYear(birthYear);
        indexresume.setEducation(education);
        indexresume.setExPosition(exPosition);
        indexresume.setExSalaryLow(exSalaryLow);
        indexresume.setExSalaryHigh(exSalaryHigh);
        indexresume.setWorkArea(workArea);
        indexresume.setIsSecret(isSecret);
        return indexresumeService.Ins(indexresume);
    }

    @ResponseBody
    @RequestMapping(value= {"updateIndexresume"}, method={RequestMethod.PUT})
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
        Indexresume indexresume = new Indexresume();
        indexresume.setUserID(id);
        indexresume.setRealName(realname);
        indexresume.setPhoneNum(phonenum);
        indexresume.setBirthYear(birthYear);
        indexresume.setEducation(education);
        indexresume.setExPosition(exPosition);
        indexresume.setExSalaryLow(exSalaryLow);
        indexresume.setExSalaryHigh(exSalaryHigh);
        indexresume.setWorkArea(workArea);
        indexresume.setIsSecret(isSecret);
        return indexresumeService.Upd(indexresume);
    }
}