package com.pandawork.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.pandawork.common.entity.Thing;
import com.pandawork.common.entity.User;
import com.pandawork.web.spring.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by chant on 2016/4/4.
 */
@Controller
@RequestMapping(value = "/plan")
public class PlanController extends AbstractController {
    @RequestMapping(value = "/ajaxGetPlan", method = RequestMethod.POST)
    public JSONObject ajaxGetPlan(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Thing thing = new Thing();
        JSONObject jsonObject = new JSONObject();

        return jsonObject;
    }

}
