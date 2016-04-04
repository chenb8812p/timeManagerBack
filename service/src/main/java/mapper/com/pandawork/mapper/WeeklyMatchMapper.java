package com.pandawork.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chant
 * @time: 16/4/3 下午5:07
 */
public interface WeeklyMatchMapper {
    /**
     * 根据userid查找周赛对手
     * @param userId
     * @return
     * @throws Exception
     */
    public List<Integer> listAllOpp(int userId) throws Exception;

    /**
     * 删除所有
     * @throws Exception
     */
    public void delAll() throws Exception;

    /**
     * 新增匹配
     * @param userId
     * @param oppId
     * @throws Exception
     */
    public void newMatch(@Param("userId")int userId,
                         @Param("oppId")int oppId) throws Exception;

    /**
     * 取出随机id
     * @param num
     * @return
     * @throws Exception
     */
    public List<Integer> listRandId(int num) throws Exception;

    /**
     * 根据分数排序对手
     * @param user_id
     * @return
     * @throws Exception
     */
    public List<Integer> queryOppIdOrderByPoint(int user_id) throws Exception;
}
