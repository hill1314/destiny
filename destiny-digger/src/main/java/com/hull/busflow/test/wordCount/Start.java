package com.hull.busflow.test.wordCount;

import com.hull.busflow.test.wordCount.state.QueryWordState;
import com.hull.busflow.test.wordCount.state.WordDBFactory;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.generated.StormTopology;
import org.apache.storm.trident.TridentState;
import org.apache.storm.trident.TridentTopology;
import org.apache.storm.tuple.Fields;

/**
 *
 *
 * @author
 * @create 2018-09-12 上午10:03
 **/

public class Start {

    public static StormTopology buildTopology() {
        TridentTopology topology = new TridentTopology();
        TridentState state = topology.newStaticState(new WordDBFactory());

        //
        topology.newStream("filter", new WordSpout())
//                .partitionPersist(new WordDBFactory(),new Fields("txid","word"),new WordStateUpdate())
                .stateQuery(state,new Fields("field1"),new QueryWordState(),new Fields("field2"))
                .each(new Fields("field1"), new WordFunction(), new Fields());

        return topology.build();
    }

//    public static void main(String[] args) throws Exception {
//        Config conf = new Config();
//        LocalCluster cluster = new LocalCluster();
//        cluster.submitTopology("MyStorm", conf, buildTopology());
//
//        Thread.sleep(1000 * 30);
//        cluster.shutdown();
//    }

}
