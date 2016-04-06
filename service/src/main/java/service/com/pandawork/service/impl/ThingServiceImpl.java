package com.pandawork.service.impl;

import com.pandawork.common.entity.Thing;
import com.pandawork.common.utils.DateDiff;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.mapper.ThingMapper;
import com.pandawork.service.ThingService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author chant
 * @time: 16/3/23 下午8:40
 */
@Service("ThingService")
public class ThingServiceImpl implements ThingService {
    @Autowired
    ThingMapper thingMapper;

    @Override
    public List<Thing> listThingsByUserId(int userId) throws SSException {
        try {
            return thingMapper.listThingsByUserId(userId);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void newThing(Thing thing) throws SSException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            if (DateDiff.getDays(thing.getEndTime(),thing.getStartTime()) == 0){
                thingMapper.newThing(thing);
            }else{
                Thing thing1 = new Thing();

                Thing thing2 = new Thing();

                String endTime = df.format(thing.getStartTime());
                String startTime = df.format(thing.getEndTime());
                df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                thing1.setEndTime(df.parse(endTime+" 23:59:59"));
                thing1.setStartTime(thing.getStartTime());
                thing2.setStartTime(df.parse(startTime+" 00:00:00"));
                thing2.setEndTime(thing.getEndTime());
                thing.setStartTime(thing1.getStartTime());
                thing.setEndTime(thing1.getEndTime());
                thingMapper.newThing(thing);
                thing.setEndTime(thing2.getEndTime());
                thing.setStartTime(thing2.getStartTime());
                thingMapper.newThing(thing);
            }

        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void updateThingStatus(int id, int status) throws SSException {
        try {
            thingMapper.updateThingStatus(id,status);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void delThing(int id) throws SSException {
        try {
            thingMapper.delThing(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public List<Thing> queryThingsByType(@Param("userId") int userId, @Param("type") int type) throws SSException {
        try {
            return thingMapper.queryThingsByType(userId,type);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }
}
