package com.pandawork.mapper;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
*
*
*@author  chenyaoyu
*@time: 16/3/27 下午6:03
*/
public interface UserMapper {
    /**
     * 通过id查询用户
     * @param id
     * @return
     * @throws Exception
     */
    public User queryById(@Param("id") int id) throws Exception;

    /**
     * 新增用户
     * @param user
     * @throws Exception
     */
    public void newUser(@Param("user")User user) throws Exception;

    /**
     * 更新新鲜事
     * @param id
     * @param news
     * @throws Exception
     */
    public void updateNews(@Param("id")int id,
                           @Param("news")String news) throws Exception;

    /**
     * 更新周赛分数
     * @param id
     * @param weekPoint
     * @throws Exception
     */
    public void updateWeekPoint(@Param("id")int id,
                                @Param("weekPoint")int weekPoint) throws Exception;

    /**
     * 删除用户
     * @param id
     * @throws Exception
     */
    public void deleteById(@Param("id") int id) throws Exception;

    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    public List<User> listAll() throws Exception;

    /**
     * 通过用户名查询user
     * @param userName
     * @return
     * @throws Exception
     */
    public User queryByUserName(String userName) throws Exception;

    /**
     * 检查用户密码是否匹配
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    public int countByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password) throws Exception;

    /**
     * 根据userId查有无此用户
     * @param id
     * @return
     * @throws Exception
     */
    public int countByUserId(int id) throws Exception;

    /**
     * 根据userName查有无此用户
     * @param userName
     * @return
     * @throws Exception
     */
    public int countByUserName(String userName) throws Exception;

    /**
     * 更新密码
     * @param id
     * @param password
     * @throws Exception
     */
    public void updatePassword(@Param("id")int id,
                               @Param("password")String password) throws Exception;
}
