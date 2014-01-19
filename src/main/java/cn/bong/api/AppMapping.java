package cn.bong.api;

import cn.bong.dao.beans.AppInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: jameswxx
 * Date: 14-1-19
 * Time: 上午10:54
 * To change this template use File | Settings | File Templates.
 */
public class AppMapping {
    private static Map<String, AppInfo> mapping = new HashMap<String, AppInfo>();

    static {
        mapping.put("1001", new AppInfo("天天淘宝", 1001, "tttb1001", "天天淘宝科技有限公司"));
    }

    public static AppInfo get(String apiKey) {
        return mapping.get(apiKey);
    }
}
