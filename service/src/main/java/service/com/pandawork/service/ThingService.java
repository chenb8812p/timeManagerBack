package com.pandawork.service;

import com.pandawork.common.entity.Thing;
import com.pandawork.core.common.exception.SSException;

import java.util.List;

/**
 * @author chant
 * @time: 16/3/23 下午8:31
 */
public interface ThingService {
    /**
     * 生成一天的事情列表
     * @return
     * @throws SSException
     */
    public List<Thing> listThingsByUserId(int userId) throws SSException;

    /**
     * 添加新鲜事
     * @param thing
     * @throws SSException
     */
    public void newThing(Thing thing) throws SSException;

    /**
     * 改变状态
     * @param id
     * @throws SSException
     */
    public void updateThingStatus(int id,int status) throws SSException;

    /**
     * 删除事件
     * @param id
     * @throws SSException
     */
    public void delThing(int id) throws SSException;
}
