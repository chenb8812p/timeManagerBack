package com.pandawork.service.impl;

import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.mapper.WeeklyMatchMapper;
import com.pandawork.service.WeeklyMatchService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chant
 * @time: 16/4/3 下午5:28
 */
@Service(value = "WeeklyMatchService")
public class WeeklyMatchServiceImpl implements WeeklyMatchService {
    @Autowired
    WeeklyMatchMapper weeklyMatchMapper;
    @Override
    public List<Integer> listAllOpp(int userId) throws SSException {
        try {
            return weeklyMatchMapper.listAllOpp(userId);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public void delAll() throws SSException {
        try {
            weeklyMatchMapper.delAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public void newMatch(@Param("userId") int userId, @Param("oppId") int oppId) throws SSException {
        try {
            weeklyMatchMapper.newMatch(userId,oppId);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public List<Integer> listRandId(int num) throws SSException {
        try {
            return weeklyMatchMapper.listRandId(num);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public List<Integer> queryOppIdOrderByPoint(int user_id) throws SSException {
        try {
            return weeklyMatchMapper.queryOppIdOrderByPoint(user_id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }
}
