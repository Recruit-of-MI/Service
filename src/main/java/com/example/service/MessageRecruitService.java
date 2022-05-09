package com.example.service;

import com.example.bean.MessageRecruit;
import com.example.mapper.MessageRecruitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageRecruitService {
    @Autowired
    MessageRecruitMapper messageRecruitMapper;

    public MessageRecruit Sel(String id) {
        return messageRecruitMapper.Select(id);
    }

    public Boolean Ins(MessageRecruit params) {
        try{
            messageRecruitMapper.Insert(params);
            String insertId = params.getUserID();
            System.out.println("插入数据的ID: " + insertId);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
    public Boolean Upd(MessageRecruit params) {
        try{
            messageRecruitMapper.Update(params);
            String insertId = params.getUserID();
            System.out.println("更新数据的ID: " + insertId);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
}
