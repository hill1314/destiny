package com.mljr.destiny.api.lottery;

import com.mljr.destiny.common.bean.dto.RespDTO;
import com.mljr.destiny.dto.BaseRPCResponse;
import com.mljr.destiny.dto.LotteryDTO;

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
