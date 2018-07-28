package com.mljr.destiny.lottery.service;

import com.mljr.destiny.annotations.IntfLog;
import com.mljr.destiny.api.lottery.LotteryApi;
import com.mljr.destiny.common.bean.dto.RespDTO;
import com.mljr.destiny.dto.BaseRPCResponse;
import com.mljr.destiny.dto.LotteryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 抽奖服务提供
 *
 * @author
 * @create 2018-07-07 下午7:09
 **/
@Service
public class LotteryServiceImpl implements LotteryApi{
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 抽奖
     * @param userId
     * @param activityId
     * @return
     */
    @Override
    @IntfLog(url = "doLotteryUrl",desc = "抽奖")
    public BaseRPCResponse<LotteryDTO> doLottery(String userId,Long activityId) {
        logger.info("执行抽奖：activityId={}，userId={}",activityId,userId);
        BaseRPCResponse<LotteryDTO> response = new BaseRPCResponse<>();
        LotteryDTO lotteryDTO = new LotteryDTO();
        lotteryDTO.setUserId(userId);
        lotteryDTO.setActivityId(activityId);
        lotteryDTO.setWin(true);
        lotteryDTO.setLipId(1000L);
        response.setData(lotteryDTO);
        return response;
    }
}
