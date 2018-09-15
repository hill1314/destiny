package com.hull.destiny.test.wordCount;

import org.apache.storm.topology.FailedException;
import org.apache.storm.trident.operation.BaseFunction;
import org.apache.storm.trident.operation.TridentCollector;
import org.apache.storm.trident.tuple.TridentTuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 * @author
 * @create 2018-09-12 上午10:01
 **/

public class WordFunction extends BaseFunction {

    /**
     *
     */
    private static final long serialVersionUID = 735468688795780833L;
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 接收数据流 每次接收batch中一条数据
     */
    @Override
    public void execute(TridentTuple tuple, TridentCollector collector) {
        String value = tuple.getValueByField("field1").toString();
        logger.info("function value : " + value);
        if (value.charAt(0) > 'h' && value.charAt(0) < 'j') {
            throw new FailedException();
        }
    }
}
