package com.example;

import com.example.bean.*;
import com.example.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecruitApplicationTests {

    @Resource
    private BrowsedService browsedService;
    @Resource
    private CollectedJobService collectedJobService;
    @Resource
    private DeliverService deliverService;
    @Resource
    private JobService jobService;
    @Resource
    private MessageApplyService messageApplyService;
    @Resource
    private MessageRecruitService messageRecruitService;
    @Resource
    private ResumeService resumeService;
    @Resource
    private UserService userService;

    @Test
    void UserTest() {
        User user=new User();
        user.setUserID("deliver1");
        user.setUserName("张铁林");
        assertEquals(false,userService.Insert(user));
        user.setUserName("王安");
        assertEquals(true,userService.Update(user));
        user.setUserName("张铁林");
        assertEquals(true,userService.Update(user));
        assertEquals(user,userService.Select("deliver1"));
    }
    @Test
    void DeliverTest() {
        Deliver deliver = new Deliver();
        deliver.setJobID(1);
        deliver.setUserID("123456a");
        assertEquals(false,deliverService.Insert(deliver));
//        deliver=deliverService.Select("123456a").get(0);
//        assertEquals(true,deliverService.Update(deliver));
//        assertEquals(deliver,deliverService.Select("123456a").get(0));
    }
    @Test
    void CollectedJobTest() {
        CollectedJob collectedJob = new CollectedJob();
        collectedJob.setJobID(1);
        collectedJob.setUserID("123456a");
        assertEquals(true,collectedJobService.Insert(collectedJob));
        collectedJob=collectedJobService.Select("123456a").get(0);
        assertEquals(true,collectedJobService.Update(collectedJob));
        assertEquals(collectedJob,collectedJobService.Select("123456a").get(0));
    }
    @Test
    void JobTest() {
        Job job = jobService.Select(1);
        job.setRecruitPosition("保安");
        job.setMinWages(4000);
        job.setUserID("123456a");
        assertEquals(true,jobService.Insert(job));
        job=jobService.Select(1);
        assertEquals(true,jobService.Update(job));
        assertEquals(job,jobService.Select(1));
    }
    @Test
    void MessageApplyTest() {
        List<MessageApply> tem=messageApplyService.Select("123455a");
        MessageApply messageApply = tem.size()>0?tem.get(0):new MessageApply();
        messageApply.setOtherID("deliver1");
        messageApply.setUserID("123455a");
        assertEquals(true,messageApplyService.Insert(messageApply));
        messageApply=messageApplyService.Select("123455a").get(0);
        assertEquals(true,messageApplyService.Update(messageApply));
        assertEquals(messageApply,messageApplyService.Select("123455a").get(0));
    }
    @Test
    void MessageRecruitTest() {
        List<MessageRecruit> tem=messageRecruitService.Select("deliver1");
        MessageRecruit messageRecruit = tem.size()>0?tem.get(0):new MessageRecruit();
        messageRecruit.setUserID("deliver1");
        messageRecruit.setOtherID("123455a");
        assertEquals(true,messageRecruitService.Insert(messageRecruit));
        messageRecruit=messageRecruitService.Select("deliver1").get(0);
        assertEquals(true,messageRecruitService.Update(messageRecruit));
        assertEquals(messageRecruit,messageRecruitService.Select("deliver1").get(0));
    }
    @Test
    void ResumeTest() {
        Resume resume = new Resume();
        resume.setUserID("deliver1");
        resume.setRealName("王安");
        assertEquals(false,resumeService.Insert(resume));
        resume=resumeService.Select("deliver1");
        assertEquals(true,resumeService.Update(resume));
        assertEquals(resume,resumeService.Select("deliver1"));
    }
    @Test
    void BroseTest() {
        Browsed browsed = new Browsed();
        browsed.setJobID(1);
        browsed.setUserID("123456a");
        assertEquals(true,browsedService.Insert(browsed));
        browsed=browsedService.Select("123456a").get(0);
        assertEquals(true,browsedService.Update(browsed));
        assertEquals(browsed,browsedService.Select("123456a").get(0));
    }
}
