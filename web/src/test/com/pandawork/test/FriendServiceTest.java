package com.pandawork.test;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.FriendService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author chant
 * @time: 16/3/24 上午11:55
 */
public class FriendServiceTest extends AbstractTestCase {
    @Autowired
    FriendService friendService;

    @Test
    public void testNewFriend() throws SSException{
        friendService.newFriend(2,4);
    }

    @Test
    public void testQueryFriendByUserId() throws SSException{
        List<Integer> friendIdList = friendService.queryFriendIdByUserId(2);
        for(int i = 0; i < friendIdList.size(); i++){
            System.out.println(friendIdList.get(i));
        }
    }

    @Test
    public void testDelFriend() throws SSException{
        friendService.delFriend(2,4);
    }

    @Test
    public void testQueryCommonFriend() throws SSException{
        List<Integer> commonIdList = friendService.queryCommonFriend(2, 1);
        for (int i = 0;i < commonIdList.size();i++){
            System.out.println(commonIdList.get(i));
        }
    }

    @Test
    public void testQueryFriendIdOrderByPoint() throws SSException{
        List<Integer> list = friendService.queryFriendIdOrderByPoint(2);
        for (int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
