package com.aop.access.access.controller;

import com.aop.access.access.entity.Role;
import com.aop.access.access.entity.User;
import com.aop.access.access.repository.UserRepository;
import com.aop.access.access.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author HLX
 * @Date 2018/7/5 9:50
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hello")
    public ModelAndView hello(){
        return new ModelAndView("index");
    }

    @GetMapping("/user")
    @ResponseBody
    public String user(){

        return "user";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin(){
        return "admin";
    }


}
