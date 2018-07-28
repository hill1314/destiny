package com.mljr.destiny.dto;

/**
 * 抽奖返回
 *
 * @author
 * @create 2018-07-09 下午1:48
 **/

public class LotteryDTO {

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 是否中奖
     */
    private boolean isWin;

    /**
     * 奖项ID
     */
    private Long lipId;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public Long getLipId() {
        return lipId;
    }

    public void setLipId(Long lipId) {
        this.lipId = lipId;
    }

    @Override
    public String toString() {
        return "LottreyResp{" +
                "userId='" + userId + '\'' +
                ", activityId=" + activityId +
                ", isWin=" + isWin +
                ", lipId=" + lipId +
                '}';
    }
}
