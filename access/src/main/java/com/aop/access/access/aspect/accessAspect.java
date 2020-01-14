package com.aop.access.access.aspect;

import com.aop.access.access.entity.Privilage;
import com.aop.access.access.entity.Role;
import com.aop.access.access.entity.User;
import com.aop.access.access.exception.AccessException;
import com.aop.access.access.exception.LoginException;
import com.aop.access.access.utils.SessionUtil;
import javafx.fxml.LoadException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author HLX
 * @Date 2018/7/3 15:16
 */
@Component
@Aspect
public class accessAspect {


    @Autowired
    private HttpServletRequest request;

    //定义在com.aop.access.access.controller.IndexControllee类的任意方法的执行：
    @Pointcut("execution(public * com.aop.access.access.controller.IndexController.*(..)))")
    public void vedify(){}

    /*@Before("vedify()")
    public void doVedify(){
        //1.验证登录状态
        User currentUser = (User) SessionUtil.getSessionAttribute("currentUser");
        if(currentUser == null){
            throw new LoginException();
        }
        //2.验证权限
        String url = request.getRequestURI();
        Set<Role> roles = currentUser.getRoles();

        for(Role role : roles){
            Set<Privilage> privilages = role.getPrivilages();
            SessionUtil.setSessionAttribute("privilages", privilages);
            //权限控制
            for(Privilage privilage : privilages) {
                if (privilage.getRemark().equals(url)) { break; }
                else{ throw new AccessException(); }
            }
        }
    }*/

    //资源控制
    @Before("vedify()")
    public void doVedify(){
        //1.验证登录状态
        User currentUser = (User) SessionUtil.getSessionAttribute("currentUser");
        if(currentUser == null){
            throw new LoginException();
        }
        //2.验证权限
        String url = request.getRequestURI();
        Set<Role> roles = currentUser.getRoles();
        //标记
        boolean flag = false;
        for(Role role : roles){
            Set<Privilage> privilages = role.getPrivilages();
            //资源控制，把权限存放到session，然后前端根据权限显示相应的方法或模块
            SessionUtil.setSessionAttribute("privilages", privilages);
            //权限控制
            if(!url.equals("/access/index/hello")){
                for(Privilage privilage : privilages) {
                    if (privilage.getRemark().equals(url)) { flag = true; }
                }
                if(flag == false){
                    throw new AccessException();
                }
            }
        }
    }
}
