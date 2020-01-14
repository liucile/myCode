package com.aop.access.access.controller;

import com.aop.access.access.entity.User;
import com.aop.access.access.exception.MyException;
import com.aop.access.access.service.UserService;
import com.aop.access.access.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author HLX
 * @Date 2018/7/3 16:42
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @PostMapping("/login")
    @ResponseBody
    public ModelAndView login(@RequestParam("uname") String uname,
                              @RequestParam("upwd") String upwd){
        User user = userService.findUserByUname(uname);
        if(user == null){
            throw new MyException("账号或密码错误");
        }
        if(!user.getUpwd().equals(upwd)){
            throw new MyException("账号或密码错误");
        }
        SessionUtil.setSessionAttribute("currentUser", user);
        return new ModelAndView("redirect:/index/hello");
    }
}
