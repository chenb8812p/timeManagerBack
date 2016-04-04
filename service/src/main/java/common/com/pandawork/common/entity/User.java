package com.pandawork.common.entity;

import com.pandawork.core.common.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
*
*
*@author  chenyaoyu
*@time: 16/3/21 下午3:37
*/


@Table(name = "t_user")
@Entity
public class User extends AbstractEntity {
    @Id
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "oassword")
    private String password;

    @Column(name = "real_name")
    private String realName;

    @Column(name = "week_point")
    private int weekPoint;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "news")
    private String news;

    public int getWeekPoint() {
        return weekPoint;
    }

    public void setWeekPoint(int weekPoint) {
        this.weekPoint = weekPoint;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
