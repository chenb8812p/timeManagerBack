package com.pandawork.service;

import com.pandawork.core.common.exception.SSException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chant
 * @time: 16/3/24 上午11:30
 */
public interface FriendService {
    /**
     * 新增朋友关系
     * @param userId
     * @param friendId
     * @throws SSException
     */
    public void newFriend(int userId, int friendId) throws SSException;

    /**
     * 绝交
     * @param userId
     * @param friendId
     * @throws SSException
     */
    public void delFriend(int userId,int friendId) throws SSException;

    /**
     * 根据userId查询其朋友
     * @param userId
     * @return
     * @throws SSException
     */
    public List<Integer> queryFriendIdByUserId(int userId) throws SSException;

    /**
     * 查找共同好友
     * @param userId
     * @param friendId
     * @return
     * @throws SSException
     */
    public List<Integer> queryCommonFriend(@Param("userId")int userId,
                                           @Param("friendId")int friendId) throws SSException;
    /**
     * 根据分数排序好友
     * @param userId
     * @return
     * @throws SSException
     */
    public List<Integer> queryFriendIdOrderByPoint(int userId) throws SSException;
}
