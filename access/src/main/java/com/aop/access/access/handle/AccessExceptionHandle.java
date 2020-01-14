package com.aop.access.access.handle;

import com.aop.access.access.exception.AccessException;
import com.aop.access.access.exception.LoginException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author HLX
 * @Date 2018/7/5 14:54
 */
@ControllerAdvice
public class AccessExceptionHandle {

    //拦截登录异常
    @ExceptionHandler(value = LoginException.class)
    @ResponseBody
    public String handlerLoginExecetion(){
        return "还没登录呢！";
    }

    //拦截权限异常
    @ExceptionHandler(value = AccessException.class)
    @ResponseBody
    public String handlerAccessExecetion(){
        return "权限不足，请联系管理员！";
    }
}
