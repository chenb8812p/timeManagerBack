package com.pandawork.test;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserServiceTest
 *
 * @author: mayuan
 * @time: 2015/8/24 20:02
 */
public class UserServiceTest extends AbstractTestCase {

    @Autowired
    private UserService userService;

    @Test
    public void queryById() throws SSException {

        User user = userService.queryById(2);
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
    }

    @Test
    public void newUser() throws SSException {
        User user = new User();
        user.setUserName("呃呃");
        user.setPassword("12345678");
        user.setRealName("呜呜呜");
        userService.newUser(user);
    }

    @Test
    public  void checkLogin() throws SSException{
        User user = new User();
        user.setUserName("admin");
        user.setPassword("12345678");
        if(userService.checkLogin(user))
       System.out.println("yyyyyyy");
    }

    @Test
    public void testUpdateWeekPoint() throws SSException{
        userService.updateWeekPoint(2, 10);
    }

    @Test
    public void testUpdateNews() throws SSException{
        userService.updateNews(2, "asdasda");
    }

    @Test
    public void testCountByUserId() throws SSException{
        System.out.println(userService.countByUserId(2));
    }

    @Test
    public void testCountByUserName() throws SSException{
        System.out.println(userService.countByUserName("admin"));
    }

    @Test
    public void testUpdatePassword() throws SSException{
        userService.updatePassword(2,"asdw");
    }
}
