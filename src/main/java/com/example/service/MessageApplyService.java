package com.example.service;

import com.example.bean.MessageApply;
import com.example.mapper.MessageApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageApplyService {
    @Autowired
    MessageApplyMapper messageApplyMapper;

    public MessageApply Sel(String id) {
        return messageApplyMapper.Select(id);
    }

    public Boolean Ins(MessageApply params) {
        try{
            messageApplyMapper.Insert(params);
            String insertId = params.getUserID();
            System.out.println("插入数据的ID: " + insertId);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
    public Boolean Upd(MessageApply params) {
        try{
            messageApplyMapper.Update(params);
            String insertId = params.getUserID();
            System.out.println("更新数据的ID: " + insertId);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
}
