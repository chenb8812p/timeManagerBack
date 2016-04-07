package com.pandawork.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pandawork.common.entity.Thing;
import com.pandawork.common.entity.User;
import com.pandawork.common.utils.DateDiff;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.web.spring.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by chant on 2016/4/4.
 */
@Controller
@RequestMapping(value = "/plan")
public class PlanController extends AbstractController {
    public final long totalTime = 86400;


    @RequestMapping(value = "/ajaxGetPlan", method = RequestMethod.POST)
    public JSONObject ajaxGetPlan(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        JSONObject jsonObject = new JSONObject();
        JSONObject planTimeList = new JSONObject();
        JSONArray planTimeSList = new JSONArray();

        long studyTime = 0;
        long restTime = 0;
        long sleepTime = 0;
        long resetTime = 0;
        try {
            List<Thing> thingList = thingService.listThingsByUserId(user.getId());
            List<Thing> todayThingList = thingService.queryTodayThingList(user.getId());
            Thing thing = new Thing();

            for (int i = 0; i < todayThingList.size();i++){
                thing = todayThingList.get(i);
                if (thing.getType() == 0){
                    studyTime += DateDiff.getDiff(thing.getEndTime(),thing.getStartTime());
                }
                if (thing.getType() == 1){
                    restTime += DateDiff.getDiff(thing.getEndTime(),thing.getStartTime());
                }
                if (thing.getType() == 2){
                    sleepTime += DateDiff.getDiff(thing.getEndTime(),thing.getStartTime());
                }
            }
            resetTime = totalTime - studyTime - sleepTime - restTime;
            planTimeList.put("P_study",DateDiff.getBFB(studyTime,totalTime));
            planTimeList.put("P_rest",DateDiff.getBFB(restTime,totalTime));
            planTimeList.put("P_sleep",DateDiff.getBFB(sleepTime,totalTime));
            planTimeList.put("P_reset",DateDiff.getBFB(resetTime,totalTime));
            jsonObject.put("planTimeList",planTimeList);

            JSONObject json = new JSONObject();
            for (int i = 0; i < thingList.size();i++){
                thing = thingList.get(i);
                json.put("planId",thing.getId());
                json.put("time",thing.getStartTime());
                json.put("type",thing.getType());
                json.put("content",thing.getName());
                json.put("state",thing.getStatus());
                planTimeSList.add(json);
            }
            jsonObject.put("planTimeSList",planTimeSList);
        } catch (SSException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
