package com.hull.destiny.test.wordCount.state;

import org.apache.storm.shade.com.google.common.collect.Lists;
import org.apache.storm.trident.operation.TridentCollector;
import org.apache.storm.trident.state.BaseQueryFunction;
import org.apache.storm.trident.tuple.TridentTuple;
import org.apache.storm.tuple.Values;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author
 * @create 2018-09-12 下午4:05
 **/

public class QueryWordState extends BaseQueryFunction<WordStateDB,String> {

    @Override
    public List<String> batchRetrieve(WordStateDB state, List<TridentTuple> inputs) {
        List<String> stateList = new ArrayList();

        List<String> words = Lists.newArrayList();
        for(TridentTuple input: inputs) {
            words.add(input.getString(0));
        }

        stateList = state.getWordStateBatch(words);

        return stateList;
    }

    @Override
    public void execute(TridentTuple tuple, String word, TridentCollector collector) {
        collector.emit(new Values(word));
    }
}
