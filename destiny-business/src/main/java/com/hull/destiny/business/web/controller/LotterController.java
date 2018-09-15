package com.hull.destiny.business.web.controller;

import com.hull.destiny.api.lottery.LotteryApi;
import com.hull.destiny.business.service.LotteryService;
import com.hull.destiny.common.bean.dto.RespDTO;
import com.hull.destiny.dto.BaseRPCResponse;
import com.hull.destiny.dto.LotteryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 *
 *
 * @author
 * @create 2018-07-07 下午7:25
 **/

@RestController
@RequestMapping("lottery")
@Slf4j
public class LotterController {

    @Resource
    private LotteryApi lotteryApi;
    @Autowired
    private LotteryService lotteryService;

    @RequestMapping("/doLottery")
    public BaseRPCResponse<LotteryDTO> doLottery(HttpServletRequest request, String userId, Long activityId){
        log.info("====<call destiny-business doLottery >===");
        log.info("X-B3-TraceId={},X-B3-SpanId={}",request.getHeader("X-B3-TraceId"),request.getHeader("X-B3-SpanId"));
//        return lotteryApi.doLottery(userId,activityId);
        return lotteryService.doLottery(userId,activityId);
    }


}
