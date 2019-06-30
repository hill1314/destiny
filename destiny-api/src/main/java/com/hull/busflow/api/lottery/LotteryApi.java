package com.hull.busflow.api.lottery;

import com.hull.busflow.dto.BaseRPCResponse;
import com.hull.busflow.dto.LotteryDTO;

/**
 * 抽奖相关服务
 *
 * @author
 * @create 2018-07-07 下午5:16
 **/

public interface LotteryApi{


    /**
     * 抽奖
     * @param activityId
     * @param userId
     * @return
     */
    BaseRPCResponse<LotteryDTO> doLottery(String userId,Long activityId);

}
