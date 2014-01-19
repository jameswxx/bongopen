package cn.bong.api;

import cn.bong.api.ApiProcessor;
import cn.bong.api.AppInfoApi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: xiaoxue.wangxx
 * Date: 14-1-18
 * Time: 下午3:49
 * To change this template use File | Settings | File Templates.
 */
public class ApiMapping {
    private static Map<String, ApiProcessor> mapping = new HashMap<String, ApiProcessor>();

    static {
        mapping.put("getAppInfo/1.0", new AppInfoApi());
    }

    public static ApiProcessor getApi(String apiName, String apiVersion) {
        return mapping.get(apiName + "/" + apiVersion);
    }
}
