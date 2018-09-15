package com.hull.destiny.test.wordCount.state;

import org.apache.storm.shade.com.google.common.collect.Lists;
import org.apache.storm.trident.operation.TridentCollector;
import org.apache.storm.trident.state.BaseStateUpdater;
import org.apache.storm.trident.tuple.TridentTuple;

import java.util.List;

/**
 *
 *
 * @author
 * @create 2018-09-13 下午1:41
 **/

public class WordStateUpdate extends BaseStateUpdater<WordStateDB> {

    @Override
    public void updateState(WordStateDB state, List<TridentTuple> tuples, TridentCollector collector) {
        List<String> stateList = Lists.newArrayList();
        List<String> words = Lists.newArrayList();

        for(TridentTuple tuple : tuples){
            stateList.add((String) tuple.get(0));
            words.add((String) tuple.get(1));
        }

        state.setWordStateBatch(words,stateList);
    }
}
