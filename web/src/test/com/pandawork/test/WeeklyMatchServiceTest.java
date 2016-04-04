package com.pandawork.test;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.WeeklyMatchService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author chant
 * @time: 16/4/3 下午5:31
 */
public class WeeklyMatchServiceTest extends AbstractTestCase {
    @Autowired
    WeeklyMatchService weeklyMatchService;

    @Test
    public void testListAllOpp(){
        try {
            List<Integer> list = weeklyMatchService.listAllOpp(1);
            for (int i = 0; i <list.size(); i++){
                System.out.println(list.get(i));
            }
        } catch (SSException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDellAll(){
        try {
            weeklyMatchService.delAll();
        } catch (SSException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNewMatch(){
        try {
            weeklyMatchService.newMatch(1, 2);
        } catch (SSException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListRandId(){
        try {
            List<Integer> list = weeklyMatchService.listRandId(9);
            for (int i = 0; i <list.size(); i++){
                System.out.println(list.get(i));
            }
        } catch (SSException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryOppIdOrderByPoint(){
        try {
            List<Integer> list = weeklyMatchService.queryOppIdOrderByPoint(1);
            for (int i = 0; i <list.size(); i++){
                System.out.println(list.get(i));
            }
        } catch (SSException e) {
            e.printStackTrace();
        }
    }
}
