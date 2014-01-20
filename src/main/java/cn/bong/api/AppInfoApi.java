package cn.bong.api;

import cn.bong.dao.beans.AppInfo;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: xiaoxue.wangxx
 * Date: 14-1-18
 * Time: 下午4:16
 * To change this template use File | Settings | File Templates.
 */
public class AppInfoApi extends ApiProcessor {
    @Override
    public ApiResult process(JSONObject params) {
        AppInfo app = new AppInfo();
        app.setId(123);
        app.setAppKey(123456);
        app.setOwner("xiaoxue");
        app.setSecret("haha");
        app.setAppName("测试用的app");

        ApiResult result = new ApiResult("1.0", "getAppInfo", app);
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
