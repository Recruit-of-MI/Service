package com.example.service;

import com.example.bean.MessageRecruit;
import com.example.mapper.MessageRecruitMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageRecruitService {
    @Autowired
    MessageRecruitMapper messageRecruitMapper;

    public MessageRecruit Sel(String id) {
        return messageRecruitMapper.Select(id);
    }
}
