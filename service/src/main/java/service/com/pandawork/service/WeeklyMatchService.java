package com.pandawork.service;

import com.pandawork.core.common.exception.SSException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chant
 * @time: 16/4/3 下午5:27
 */
public interface WeeklyMatchService {
    /**
     * 根据userid查找周赛对手
     * @param userId
     * @return
     * @throws SSException
     */
    public List<Integer> listAllOpp(int userId) throws SSException;

    /**
     * 删除所有
     * @throws SSException
     */
    public void delAll() throws SSException;

    /**
     * 新增匹配
     * @param userId
     * @param oppId
     * @throws SSException
     */
    public void newMatch(@Param("userId")int userId,
                         @Param("oppId")int oppId) throws SSException;

    /**
     * 从t_user里面取出随机id
     * @param num
     * @return
     * @throws SSException
     */
    public List<Integer> listRandId(int num) throws SSException;

    /**
     * 根据分数排序对手
     * @param user_id
     * @return
     * @throws SSException
     */
    public List<Integer> queryOppIdOrderByPoint(int user_id) throws SSException;
}
