package cn.bong.api;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: xiaoxue.wangxx
 * Date: 14-1-18
 * Time: 下午4:15
 * To change this template use File | Settings | File Templates.
 */
public class UserApi extends ApiProcessor {
    @Override
    public ApiResult process(JSONObject params) {
        String userId = params.getString("userId");
        ApiResult result = new ApiResult("1.0", "getAppInfo", "hello " + userId);
        return result
                ;
    }


    public static void test(Long key) {
        System.out.print(key.hashCode());
    }

    public static void main(String[] args) {
//        HashMap<Long, String> test = new HashMap<Long, String>();
//        test.put(0L, "");

        Long a = 0L;
        Integer b = 0;
        Object c = a;
        Object d = b;
        System.out.print(c.hashCode()) ;
        System.out.print(d.hashCode()) ;
        System.out.print((a == c));

    }
}
