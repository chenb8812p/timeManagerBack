package com.pandawork.service.impl;

import com.pandawork.common.entity.User;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.core.common.util.CommonUtil;
import com.pandawork.core.framework.dao.CommonDao;
import com.pandawork.mapper.UserMapper;
import com.pandawork.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserServiceImpl
 *
 * @author: mayuan
 * @time: 2015/8/26 16:13
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    @Qualifier("commonDao")//commonDao别名
    private CommonDao commonDao;


    @Override
    public User queryById(@Param("id") int id) throws SSException {
        if (Assert.lessOrEqualZero(id)) {
            return null;
        }
        try {
            return userMapper.queryById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void newUser(@Param("user") User user) throws SSException {
        if (Assert.isNull(user)) {
            return ;
        }
        // 判断用户名和密码是否为空
        Assert.isNotNull(user.getUserName(), NFException.UserNameNotNull);
        Assert.isNotNull(user.getPassword(), NFException.PasswordNotNull);
        try {
            user.setPassword(CommonUtil.md5(user.getPassword()));
            userMapper.newUser(user);
            return ;
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void updateNews(int id, String news) throws SSException {
        if (Assert.isNull(id)&&Assert.isNotNull(news)) {
            return ;
        }
        try {
            userMapper.updateNews(id, news);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void deleteById(@Param("id") int id) throws SSException {
        if (Assert.lessOrEqualZero(id)) {
            return;
        }
        try {
            userMapper.deleteById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public List<User> listAll() throws SSException {
        try {
            return userMapper.listAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public boolean checkLogin(User user) throws SSException {
        if (Assert.isNull(user)) {
            return false;
        }
        try {
            user.setPassword(CommonUtil.md5(user.getPassword()));
            return userMapper.countByUserNameAndPassword(user.getUserName(), user.getPassword()) > 0 ? true : false;
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void updateWeekPoint(@Param("id") int id, @Param("weekPoint") int weekPoint) throws SSException {
        if (Assert.isNull(id)&&Assert.isNotNull(weekPoint)) {
            return ;
        }
        try {
            userMapper.updateWeekPoint(id,weekPoint);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public int countByUserId(int id) throws SSException {
        try {
            return userMapper.countByUserId(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public int countByUserName(String userName) throws SSException {
        try {
            return userMapper.countByUserName(userName);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    public void updatePassword(int id, String password) throws SSException {
        password = CommonUtil.md5(password);
        try {
            userMapper.updatePassword(id,password);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }


    @Override
    public User queryByUserName( String userName) throws Exception {
        try {
            return userMapper.queryByUserName(userName);

        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }




}
