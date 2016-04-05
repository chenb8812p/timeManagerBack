package com.pandawork.test;

import com.pandawork.common.entity.Thing;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.ThingService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author chant
 * @time: 16/3/23 下午8:45
 */
public class ThingServiceTest extends AbstractTestCase {
    @Autowired
    private ThingService thingService;

    @Test
    public void testListThingByUserId() {
        try {
            List<Thing> thingList = new ArrayList<Thing>();
            thingList = thingService.listThingsByUserId(1);
            System.out.println();
        } catch (SSException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNewThing() {
        Thing thing = new Thing();
        thing.setName("aaa");
        thing.setType(1);
        thing.setUserId(1);
        thing.setStartTime(new Date());
        thing.setEndTime(new Date());
        try {
            thingService.newThing(thing);
        } catch (SSException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateThingStatus(){
        try {
            thingService.updateThingStatus(1, 1);
        } catch (SSException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelThing(){
        try {
            thingService.delThing(3);
        } catch (SSException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryThingsByType() throws SSException {
        List<Thing> list = thingService.queryThingsByType(1,1);
    }

}
