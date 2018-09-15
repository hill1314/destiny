package com.hull.destiny.api.lottery;

import com.hull.destiny.common.bean.dto.RespDTO;
import com.hull.destiny.dto.BaseRPCResponse;
import com.hull.destiny.dto.LotteryDTO;

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
