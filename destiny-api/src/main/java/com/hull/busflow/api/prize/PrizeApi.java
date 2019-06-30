package com.hull.busflow.api.prize;

import com.hull.busflow.po.lottery.PriPrizeInfoOrg;

import java.util.List;

/**
 * 奖品相关服务
 *
 * @author
 * @create 2018-07-07 下午5:15
 **/

public interface PrizeApi {
    /**
     * 增
     * @param prize
     * @return
     */
    int addPrize(PriPrizeInfoOrg prize);

    /**
     * 删
     * @param prize
     * @return
     */
    int delPrize(PriPrizeInfoOrg prize);

    /**
     * 改
     * @param prize
     * @return
     */
    int updatePrize(PriPrizeInfoOrg prize);

    /**
     * 查
      * @param prize
     * @return
     */
    List<PriPrizeInfoOrg> queryPrize(PriPrizeInfoOrg prize);

}
