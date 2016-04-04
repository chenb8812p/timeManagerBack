package com.pandawork.service.impl;

import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.mapper.FriendMapper;
import com.pandawork.service.FriendService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author chant
 * @time: 16/3/24 上午11:32
 */
@Service("FriendService")
public class FriendServiceImpl implements FriendService {
    @Autowired
    FriendMapper friendMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void newFriend(int userId, int friendId) throws SSException {
        try {
            friendMapper.newFriend(userId,friendId);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void delFriend(int userId, int friendId) throws SSException {
        try {
            friendMapper.delFriend(userId,friendId);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public List<Integer> queryFriendIdByUserId(int userId) throws SSException {
        try {
            return friendMapper.queryFriendIdByUserId(userId);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public List<Integer> queryCommonFriend(@Param("userId") int userId, @Param("friendId") int friendId) throws SSException {
        try {
            return friendMapper.queryCommonFriend(userId,friendId);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public List<Integer> queryFriendIdOrderByPoint(int userId) throws SSException {
        try {
            return friendMapper.queryFriendIdOrderByPoint(userId);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }
}
