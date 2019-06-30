package com.hull.busflow.digger;

import org.apache.storm.Config;
import org.apache.storm.utils.DRPCClient;

/**
 *
 *
 * @author
 * @create 2018-08-03 下午4:30
 **/

public class DRPCTest {


    public static void test() {
        try {
            Config conf = new Config();
            conf.setMessageTimeoutSecs(120); //消息超时时间
            conf.setDebug(true);

            DRPCClient client = new DRPCClient(conf,"localhost", 3772);
            System.out.println(client.execute("words", "cat dog the man"));
        }catch (Exception e){
            System.err.println(e);
        }

    }
}
