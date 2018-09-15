package com.hull.destiny.test.wordCount;

import org.apache.storm.shade.com.google.common.collect.Lists;
import org.apache.storm.shade.org.apache.commons.collections.CollectionUtils;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.trident.operation.TridentCollector;
import org.apache.storm.trident.spout.ITridentSpout;
import org.apache.storm.trident.topology.TransactionAttempt;
import org.apache.storm.tuple.Fields;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 *
 * @author
 * @create 2018-09-12 上午10:00
 **/

public class WordSpout implements ITridentSpout<List<String>> {

    /**
     *
     */
    private static final long serialVersionUID = -954626449213280061L;
    private Logger logger = LoggerFactory.getLogger("Trident Spout");


    private String chars = "abcdefghijklmnopqrstuvwxyz";
    private long preTxid ; //上一个事务ID


    /**
     * 协调器
     * 负责保存重放batch元数据，当重放一个batch时，通过协调器中保存的元数据创建batch
     */
    @Override
    public BatchCoordinator<List<String>> getCoordinator(String txStateId, Map conf, TopologyContext context) {
        return new WordCoordinator();
    }

    @Override
    public Emitter<List<String>> getEmitter(String txStateId, Map conf, TopologyContext context) {
        return new WordEmitter();
    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }

    /**
     * 定义发送的所有字段
     */
    @Override
    public Fields getOutputFields() {
        return new Fields("field1");
    }

    private class WordCoordinator implements BatchCoordinator<List<String>> {

        @Override
        public List<String> initializeTransaction(long txid, List<String> prevMetadata, List<String> currMetadata) {
            logger.info("initializeTransaction txid : {},prevMetadata : {},currMetadata : {}",
                    txid,prevMetadata,currMetadata);

            //事务ID相同，说明是失败重发
            if(Objects.equals(preTxid,txid)){
                return currMetadata;
            }else {
                for(int i=0;i<10;i++){
                    char c = chars.charAt((int)(Math.random() * 26));
                    if(CollectionUtils.isEmpty(currMetadata))
                        currMetadata = Lists.newArrayList();
                    currMetadata.add(c+"");
                }
                preTxid = txid;
                return currMetadata;
            }
        }

        @Override
        public void success(long txid) {
            logger.info("success: " + txid);
        }

        @Override
        public boolean isReady(long txid) {
            logger.info("begin {}", txid);
            return Boolean.TRUE;
        }

        @Override
        public void close() {

        }

    }

    /**
     * 发射器
     * 发送数据流
     *
     */
    private class WordEmitter implements Emitter<List<String>> {

        @Override
        public void success(TransactionAttempt tx) {
            logger.info("emitter success " + tx.getId());
        }

        @Override
        public void close() {
        }


        /**
         * 负责发送 一个批次的tuple 的方法
         * @param tx  每次调用本方法所发送的数据集合被称为batch，batch是Trident中发送数据流的最小单元
         * @param coordinatorMeta 是 Coordinator（协调者）传来的数据
         * @param collector
         */
        @Override
        public void emitBatch(TransactionAttempt tx, List<String> coordinatorMeta, TridentCollector collector) {
            logger.info("TransactionId : {},AttemptId : {},currMetadata : {}",
                    tx.getTransactionId(),tx.getAttemptId(),coordinatorMeta);

            if(CollectionUtils.isEmpty(coordinatorMeta))
                return;

            for(int i = 0;i<coordinatorMeta.size();i++){
                List list = Lists.newArrayList();
                String c = coordinatorMeta.get(i);
                list.add(c);
                collector.emit(list);
            }

        }
    }

}

