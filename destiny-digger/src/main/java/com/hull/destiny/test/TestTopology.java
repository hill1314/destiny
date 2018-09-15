package com.hull.destiny.test;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.generated.StormTopology;
import org.apache.storm.trident.TridentState;
import org.apache.storm.trident.TridentTopology;
import org.apache.storm.trident.operation.builtin.Count;
import org.apache.storm.trident.operation.builtin.MapGet;
import org.apache.storm.tuple.Fields;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 * @author
 * @create 2018-08-30 下午2:54
 **/

public class TestTopology {

    static Logger logger = LoggerFactory.getLogger(TestTopology.class);

    public static void main(String[] args) {
        try {
            //构建 storm topology
            StormTopology builder = buildTopology();
            //配置启动storm
            startUp(builder,args);

        }catch (Exception e){
            logger.error("storm启动失败,",e);
        }
    }

    /**
     * 构建 storm topology
     * @return
     */
    public static StormTopology buildTopology() {
        TridentTopology topology = new TridentTopology();

//        TridentState urlToTweeters =
//                topology.newStaticState(getUrlToTweetersState());
//        TridentState tweetersToFollowers =
//                topology.newStaticState(getTweeterToFollowersState());

        topology.newDRPCStream("reach")
//                .stateQuery(urlToTweeters, new Fields("args"), new MapGet(), new Fields("tweeters"))
//                .each(new Fields("tweeters"), new ExpandList(), new Fields("tweeter"))
//                .shuffle()
//                .stateQuery(tweetersToFollowers, new Fields("tweeter"), new MapGet(), new Fields("followers"))
//                .parallelismHint(200)
//                .each(new Fields("followers"), new ExpandList(), new Fields("follower"))
//                .groupBy(new Fields("follower"))
//                .aggregate(new One(), new Fields("one"))
                .parallelismHint(20)
                .aggregate(new Count(), new Fields("reach"));

        return topology.build();
    }

    /**
     * 配置启动storm
     * @param builder
     * @param args
     */
    private static void startUp(StormTopology builder, String[] args) throws Exception {
        Config conf = new Config();
        conf.setMessageTimeoutSecs(120); //消息超时时间
        conf.setDebug(true);

        // 本地模式
        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("goldDigger", conf, builder);
//            Thread.sleep(10000);
//            cluster.shutdown();
    }
}
