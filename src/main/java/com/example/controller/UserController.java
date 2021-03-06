package com.example.controller;

import com.example.bean.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value= {"/getUser"}, method={RequestMethod.GET})
    public User GetUser(@RequestParam("userID") String id) {//@PathVariable int id
        return userService.Select(id);
    }

    @ResponseBody
    @RequestMapping(value= {"/createUser"}, method={RequestMethod.POST})
    public boolean PostUser(@RequestParam("userID") String id,
                            @RequestParam("userName") String username,
                            @RequestParam("avatarUrl") String avatarurl) {
        User user = new User();
        user.setUserID(id);
        user.setUserName(username);
        user.setAvatarUrl(avatarurl);
        return userService.Insert(user);
    }
    @ResponseBody
    @RequestMapping(value= {"/updateUser"}, method={RequestMethod.PUT})
    public boolean PutUser(@RequestParam("userID") String id,
                           @RequestParam("userName") String username,
                           @RequestParam("avatarUrl") String avatarurl) {
        User user = userService.Select(id);
        user.setUserName(username);
        user.setAvatarUrl(avatarurl);
        return userService.Update(user);
    }
}