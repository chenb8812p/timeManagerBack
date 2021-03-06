package com.pandawork.mapper;

import com.pandawork.common.entity.Thing;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chant
 * @time: 16/3/21 下午9:22
 */
public interface ThingMapper {
    /**
     * 生成一天的事情列表
     * @return
     * @throws Exception
     */
    public List<Thing> listThingsByUserId(int userId) throws Exception;

    /**
     * 添加新鲜事
     * @param thing
     * @throws Exception
     */
    public void newThing(@Param("thing")Thing thing) throws Exception;

    /**
     * 改变状态
     * @param id
     * @throws Exception
     */
    public void updateThingStatus(@Param("id")int id,
                                  @Param("status")int status) throws Exception;

    /**
     * 删除事件
     * @param id
     * @throws Exception
     */
    public void delThing(int id) throws Exception;

    /**
     * 根据type获取Thing的List
     * @param userId
     * @param type
     * @return
     * @throws Exception
     */
    public List<Thing> queryThingsByType(@Param("userId")int userId,
                                         @Param("type")int type) throws Exception;

    /**
     * 获取当天事情List
     * @param userId
     * @return
     * @throws Exception
     */
    public List<Thing> queryTodayThingList(int userId) throws Exception;

}
