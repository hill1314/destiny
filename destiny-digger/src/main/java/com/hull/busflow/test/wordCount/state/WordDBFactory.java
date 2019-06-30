package com.hull.busflow.test.wordCount.state;

import org.apache.storm.task.IMetricsContext;
import org.apache.storm.trident.state.State;
import org.apache.storm.trident.state.StateFactory;

import java.util.Map;

/**
 *
 *
 * @author
 * @create 2018-09-12 下午3:54
 **/

public class WordDBFactory implements StateFactory{

    @Override
    public State makeState(Map conf, IMetricsContext metrics, int partitionIndex, int numPartitions) {

        return new WordStateDB();
    }
}
