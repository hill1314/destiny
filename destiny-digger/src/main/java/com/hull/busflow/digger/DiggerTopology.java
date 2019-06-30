package com.hull.busflow.digger;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.StormTopology;
import org.apache.storm.trident.TridentState;
import org.apache.storm.trident.TridentTopology;
import org.apache.storm.trident.operation.builtin.Count;
import org.apache.storm.trident.operation.builtin.FilterNull;
import org.apache.storm.trident.operation.builtin.MapGet;
import org.apache.storm.trident.operation.builtin.Sum;
import org.apache.storm.trident.testing.FixedBatchSpout;
import org.apache.storm.trident.testing.MemoryMapState;
import org.apache.storm.trident.testing.Split;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * storm trident
 *
 * @author
 * @create 2018-08-03 下午4:20
 **/

public class DiggerTopology {

    static Logger logger = LoggerFactory.getLogger(DiggerTopology.class);

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

        FixedBatchSpout spout = new FixedBatchSpout(new Fields("sentence"), 3,
                new Values("the cow jumped over the moon"),
                new Values("the man went to the store and bought some candy"),
                new Values("four score and seven years ago"),
                new Values("how many apples can you eat"));
        spout.setCycle(true);

        TridentState wordCounts =
                topology.newStream("spout1", spout)
                        .each(new Fields("sentence"), new Split(), new Fields("word"))
                        .groupBy(new Fields("word"))
                        .persistentAggregate(new MemoryMapState.Factory(), new Count(), new Fields("count"))
                        .parallelismHint(6);

        topology.newDRPCStream("words")
                .each(new Fields("args"), new Split(), new Fields("word"))
                .groupBy(new Fields("word"))
                .stateQuery(wordCounts, new Fields("word"), new MapGet(), new Fields("count"))
                .each(new Fields("count"), new FilterNull())
                .aggregate(new Fields("count"), new Sum(), new Fields("sum"));


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

        if (args != null && args.length > 0) {
            // 集群模式
            String topologyName = args[0];
            int workerNum = Integer.parseInt(args[1]);
            conf.setNumWorkers(workerNum);
            StormSubmitter.submitTopology(topologyName, conf, builder);

        } else {
            // 本地模式
            LocalCluster cluster = new LocalCluster();
            cluster.submitTopology("goldDigger", conf, builder);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true){
//                String str = reader.readLine();
//                System.err.println("str="+str);
//                if(str.equals("bye")){
                    Thread.sleep(1000);
                System.out.println(new Date());
//                    cluster.shutdown();
//                }
            }
        }
    }
}
