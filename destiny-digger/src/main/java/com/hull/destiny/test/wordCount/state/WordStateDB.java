package com.hull.destiny.test.wordCount.state;

import org.apache.storm.shade.com.google.common.collect.Lists;
import org.apache.storm.shade.com.google.common.collect.Maps;
import org.apache.storm.trident.state.State;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author
 * @create 2018-09-12 下午3:49
 **/

public class WordStateDB implements State {
    private static volatile Map<String,String> stateMap = Maps.newConcurrentMap();

    @Override
    public void beginCommit(Long txid) {

    }

    @Override
    public void commit(Long txid) {

    }

    public void setWordStateBatch(List<String> wordList, List<String> stateList) {
        // code to access database and set location
        for(int i=0 ; i<wordList.size(); i++){
            stateMap.put(wordList.get(0),stateList.get(0));
        }
    }

    public List<String> getWordStateBatch(List<String> wordList) {
        // code to get location from database
        List<String> stateList = Lists.newArrayList();
        for(String word : wordList){
            stateList.add(stateMap.get(word));
        }
        return stateList;
    }
}
