package com.mljr.destiny.business.facade;


import com.mljr.destiny.dto.BaseRPCResponse;
import com.mljr.destiny.dto.LotteryDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 *
 * @author
 * @create 2018-07-10 上午10:45
 **/

@FeignClient("destiny-lottery-provider")
public interface LotteryFacade {

    /**
     * 执行抽奖动作
     * @param userId
     * @param activityId
     * @return
     */
    @GetMapping({"/lotteryProvider/doLottery"})
    BaseRPCResponse<LotteryDTO> doLottery(@RequestParam("userId") String userId,
                                          @RequestParam("activityId") Long activityId);


}