package com.pandawork.web.controller;

import com.alibaba.fastjson.JSON;
import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.web.spring.AbstractController;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * @author chant
 * @time: 16/4/3 上午11:31
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController extends AbstractController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        return "login/login_home";
    }

    @RequestMapping(value = "/loginAjax", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject loginAjax(@RequestParam("userName") String username, @RequestParam("password") String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        try {
            if (userService.checkLogin(user)){
                user = userService.queryByUserName(username);
                session.setAttribute("user", user);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code",0);//成功登录

                return jsonObject;
            }else {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code",1);//用户名密码错误
                return jsonObject;
            }

        } catch (Exception e) {
            LogClerk.errLog.error(e);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",2);//系统内部错误
            return jsonObject;
        }
    }
}
