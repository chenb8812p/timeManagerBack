package com.pandawork.service;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserService
 *
 * @author: mayuan
 * @time: 2015/3/26 19:25
 */
public interface UserService {

    /**
     * 新用户
     * @param user
     * @throws SSException
     */
    public void newUser( User user) throws SSException;

    /**
     * 更新新鲜事
     * @param id
     * @param news
     * @throws SSException
     */
    public void updateNews(int id, String news) throws SSException;

    /**
     * 删除用户
     * @param id
     * @throws SSException
     */
    public void deleteById( int id) throws SSException;

    /**
     * 所有用户
     * @return
     * @throws SSException
     */
    public List<User> listAll() throws SSException;

    /**
     * 通过id查询
     * @param id
     * @return
     * @throws SSException
     */
    public User queryById( int id) throws SSException;

    /**
     * 通过用户名查
     * @param userName
     * @return
     * @throws Exception
     */
    public User queryByUserName( String userName) throws Exception;

    /**
     * 检查登录
     * @param user
     * @return
     * @throws SSException
     */
    public boolean checkLogin(User user) throws SSException;

    /**
     * 更新周赛分数
     * @param id
     * @param weekPoint
     * @throws SSException
     */
    public void updateWeekPoint(@Param("id")int id,
                                @Param("weekPoint")int weekPoint) throws SSException;

    /**
     * 根据userId查有无此用户
     * @param id
     * @return
     * @throws SSException
     */
    public int countByUserId(int id) throws SSException;
    /**
     * 根据userName查有无此用户
     * @param userName
     * @return
     * @throws SSException
     */
    public int countByUserName(String userName) throws SSException;

    /**
     * 更新密码
     * @param id
     * @param password
     * @throws SSException
     */
    public void updatePassword(int id, String password) throws SSException;
}
