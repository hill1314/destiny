import com.google.common.collect.Maps;

import java.util.Iterator;
import java.util.Map;

/**
 *
 *
 * @author
 * @create 2018-09-16 上午11:10
 **/

public class SimpleTest {

    public static void main(String[] args) {
        Map map = Maps.newHashMap();
        map.put("a","1");
        map.put("b","2");
        System.out.println(resolveParam(map));
    }


    public static String resolveParam(Map<String, String[]> parameterMap) {
        StringBuffer buffer = new StringBuffer();
        Iterator<String> iterator = parameterMap.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            buffer.append("'"+key+"':"+parameterMap.get(key)+";");
        }
        return buffer.toString();
    }
}
