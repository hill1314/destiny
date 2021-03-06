package com.hull.busflow.business.service;

import com.hull.busflow.api.prize.PrizeApi;
import com.hull.busflow.business.consts.ServerUrlConst;
import com.hull.busflow.common.bean.dto.RespDTO;
import com.hull.busflow.po.lottery.PriPrizeInfoOrg;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * {@link PrizeApi}
 *
 *
 * @author
 * @create 2018-03-25 下午8:09
 **/
@Service
public class PrizeApiProxy implements PrizeApi {

    @Resource
    private RestTemplate restTemplate;


    @Override
    public int addPrize(PriPrizeInfoOrg prize) {
        ResponseEntity respEntity  = restTemplate.postForEntity(
                ServerUrlConst.PRIZE_PROVIDER_URL+"/prizeProvider/add",
                prize,RespDTO.class);
        Integer respDTO = (Integer) respEntity.getBody();
        return respDTO;
    }

    @Override
    public int delPrize(PriPrizeInfoOrg prize) {
        return 0;
    }

    @Override
    public int updatePrize(PriPrizeInfoOrg prize) {
        return 0;
    }

    @Override
    public List<PriPrizeInfoOrg> queryPrize(PriPrizeInfoOrg prize) {
        return null;
    }
}
