package com.hull.destiny.lottery.controller;

import com.hull.destiny.api.lottery.LotteryApi;
import com.hull.destiny.dto.BaseRPCResponse;
import com.hull.destiny.dto.LotteryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 抽奖服务提供
 *
 * @author
 * @create 2018-07-07 下午7:09
 **/

@RestController
@RequestMapping("/lotteryProvider")
@Slf4j
public class LotteryProviderController {
    @Resource
    private LotteryApi lotteryApi;

    @RequestMapping("/doLottery")
    public BaseRPCResponse<LotteryDTO> doLottery(HttpServletRequest request, String userId, Long activityId){
        log.info("====<call destiny-lottery-provider doLottery >===");
        log.info("X-B3-TraceId={},X-B3-SpanId={}",request.getHeader("X-B3-TraceId"),request.getHeader("X-B3-SpanId"));
        return lotteryApi.doLottery(userId,activityId);
    }

}
