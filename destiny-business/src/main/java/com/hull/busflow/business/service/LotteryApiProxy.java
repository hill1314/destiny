package com.hull.busflow.business.service;

import com.hull.busflow.api.lottery.LotteryApi;
import com.hull.busflow.business.consts.ServerUrlConst;
import com.hull.busflow.common.bean.dto.RespDTO;
import com.hull.busflow.dto.BaseRPCResponse;
import com.hull.busflow.dto.LotteryDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author
 * @create 2018-07-07 下午7:23
 **/

@Service
public class LotteryApiProxy implements LotteryApi{


    @Resource
    private RestTemplate restTemplate;

    @Override
    public BaseRPCResponse<LotteryDTO> doLottery(String userId, Long activityId) {
        BaseRPCResponse<LotteryDTO> response = new BaseRPCResponse<>();
        Map param = new HashMap();
        param.put("activityId",activityId);
        param.put("userId",userId);

        ResponseEntity respEntity  = restTemplate.getForEntity(
                ServerUrlConst.LOTTERY_PROVIDER_URL+"/lotteryProvider/doLottery",
                BaseRPCResponse.class,param);

        BaseRPCResponse<LotteryDTO> respDTO = (BaseRPCResponse<LotteryDTO>) respEntity.getBody();

        return respDTO;
    }


    @HystrixCommand(fallbackMethod = "doLotteryFallback")
    public BaseRPCResponse<LotteryDTO> doLotteryWithHystrix(Long activityId, String userId) {
        BaseRPCResponse<LotteryDTO> respDTO = doLottery(userId,activityId);
        return respDTO;
    }

    public RespDTO<Boolean> doLotteryFallback(){
        return RespDTO.fail("服务调用失败，回调方法");
    }

}
