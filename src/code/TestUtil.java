package code;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyongkang@artspring.com.cn
 * @desc
 * @time 2019-07-02 20:06
 */
public class TestUtil {

    public static void main(String[] args) {
//        TestUtil testUtil = new TestUtil();
        Integer integer = Integer.valueOf(126);
        Integer integer2 = Integer.valueOf(126);
        System.out.println(integer == integer2);
        HashMap<String, Object> hashMap = new HashMap();
        Map<String, Object> map = Collections.synchronizedMap(hashMap);

    }


}
