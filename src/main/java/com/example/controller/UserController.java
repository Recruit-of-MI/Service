package com.example.controller;

import com.example.bean.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value= {"getUser"}, method={RequestMethod.GET})
    public User GetUser(@RequestParam("userId") String id) {//@PathVariable int id
        User result = userService.Sel(id);
        return result;
    }

    @ResponseBody
    @RequestMapping(value= {"createregister"}, method={RequestMethod.POST})
    public boolean PostUser(@RequestParam("userId") String id,
                            @RequestParam("userName") String username,
                            @RequestParam("avatarUrl") String avatarurl) {
        User user = new User();
        user.setUserID(id);
        user.setUserName(username);
        user.setAvatarUrl(avatarurl);
        Boolean result = userService.Ins(user);
        return result;
    }
}