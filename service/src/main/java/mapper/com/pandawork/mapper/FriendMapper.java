package com.pandawork.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chant
 * @time: 16/3/24 上午11:14
 */
public interface FriendMapper {
    /**
     * 新增朋友关系
     * @param userId
     * @param friendId
     * @throws Exception
     */
    public void newFriend(@Param("userId")int userId,
                          @Param("friendId")int friendId) throws Exception;

    /**
     * 绝交
     * @param userId
     * @param friendId
     * @throws Exception
     */
    public void delFriend(@Param("userId")int userId,
                          @Param("friendId")int friendId) throws Exception;

    /**
     * 根据userId查询其朋友
     * @param userId
     * @return
     * @throws Exception
     */
    public List<Integer> queryFriendIdByUserId(int userId) throws Exception;

    /**
     * 查找共同好友
     * @param userId
     * @param friendId
     * @return
     * @throws Exception
     */
    public List<Integer> queryCommonFriend(@Param("userId")int userId,
                                           @Param("friendId")int friendId) throws Exception;

    /**
     * 根据分数排序好友
     * @param userId
     * @return
     * @throws Exception
     */
    public List<Integer> queryFriendIdOrderByPoint(int userId) throws Exception;

}
