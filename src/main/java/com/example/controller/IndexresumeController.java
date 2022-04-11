package com.example.controller;

import com.example.bean.Indexresume;
import com.example.service.IndexresumeService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/User")
public class IndexresumeController {

    @Autowired
    private IndexresumeService indexresumeService;

    @ResponseBody
    @RequestMapping(value= {"/getIndexresume/{id}"}, method={RequestMethod.GET})
    public Indexresume GetUser(@PathVariable int id) {
        Indexresume result = indexresumeService.Sel(id);
        return result;
    }

    @ResponseBody
    @RequestMapping(value= {"postIndexresume"}, method={RequestMethod.POST})
    public boolean PostUser(@RequestBody String params) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(params);
        Indexresume indexresume = new Indexresume();
        indexresume.setRealName(rootNode.path("userName").asText());
        Boolean result = indexresumeService.Ins(indexresume);
        return result;
    }
}