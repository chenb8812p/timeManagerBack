package com.pandawork.common.entity;

import com.pandawork.core.common.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author chant
 * @time: 16/4/3 下午5:05
 */
@Entity
@Table(name = "t_weekly_match")
public class WeeklyMatch extends AbstractEntity{
    @Id
    private Integer id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "opponent_id")
    private int opponentId;

    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOpponentId() {
        return opponentId;
    }

    public void setOpponentId(int opponentId) {
        this.opponentId = opponentId;
    }
}
