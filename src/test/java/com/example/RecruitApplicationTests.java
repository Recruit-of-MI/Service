package com.example;

import com.example.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecruitApplicationTests {

    @Autowired
    private BrowsedService browsedService;
    @Autowired
    private CollectedJobService collectedJobService;
    @Autowired
    private DeliverService deliverService;
    @Autowired
    private JobService jobService;
    @Autowired
    private MessageApplyService messageApplyService;
    @Autowired
    private MessageRecruitService messageRecruitService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private UserService userService;

    @Test
    void BrosePostTest() {
        assertTrue()
    }
}
