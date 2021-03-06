package com.hull.busflow.business.web.controller;

import com.hull.busflow.api.prize.PrizeApi;
import com.hull.busflow.po.lottery.PriPrizeInfoOrg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author
 * @create 2018-07-08 下午3:47
 **/

@RestController
@RequestMapping("prize")
public class PrizeController {

    @Autowired
    private PrizeApi prizeApi;

    @RequestMapping("/add")
    public Integer addPrize(PriPrizeInfoOrg prize){
        return prizeApi.addPrize(prize);
    }
}
