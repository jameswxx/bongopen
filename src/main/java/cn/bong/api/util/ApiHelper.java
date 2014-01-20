package cn.bong.api.util;

import cn.bong.api.AppMapping;
import cn.bong.api.Switcher;
import cn.bong.dao.beans.AppInfo;

/**
 * Created with IntelliJ IDEA.
 * User: jameswxx
 * Date: 14-1-20
 * Time: 下午7:38
 * To change this template use File | Settings | File Templates.
 */
public class ApiHelper {

    public static boolean verify(String apiName, String apiVersion, String appKey, String data, String sign) {
        if (apiName == null || apiVersion == null || appKey == null) {
            return false;
        }

        if (!Switcher.API_VERIFY) {
            return true;
        }

        if (sign == null) {
            return false;
        }

        AppInfo appInfo = AppMapping.get(appKey);
        if (appInfo == null) {
            return false;
        }

        String source = apiName + "_" + apiVersion + "_" + appKey + "_" + appInfo.getSecret();
        if (data != null) {
            source = source + "_" + data;
        }


        return sign.equals(DataEncoder.md5Hex(source));
    }


}
