package com.mljr.destiny.business.service;


import com.mljr.destiny.business.facade.LotteryFacade;
import com.mljr.destiny.dto.BaseRPCResponse;
import com.mljr.destiny.dto.LotteryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 抽奖相关服务
 *
 * @author
 * @create 2018-07-09 下午1:44
 **/
@Service
public class LotteryService {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private LotteryFacade lotteryFacade;

    /**
     * 抽奖
     * @param userId
     * @param activityId
     * @return
     */
    public BaseRPCResponse<LotteryDTO> doLottery(String userId, Long activityId) {
        log.info("抽奖 请求参数:userId={},activityId={}",userId,activityId);
        BaseRPCResponse<LotteryDTO> resp = lotteryFacade.doLottery(userId,activityId);
        //判断返回结果
        log.info("抽奖 返回参数:"+resp.getData());
        return resp;
    }


}
