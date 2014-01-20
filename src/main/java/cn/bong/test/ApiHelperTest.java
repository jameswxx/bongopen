package cn.bong.test;

import cn.bong.api.util.ApiHelper;
import cn.bong.api.util.DataEncoder;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: jameswxx
 * Date: 14-1-20
 * Time: 下午7:40
 * To change this template use File | Settings | File Templates.
 */
public class ApiHelperTest extends TestCase {

    @Test
    public void testVerify() {
        String apiName = "getAppInfo";
        String apiVersion = "1.0";
        String appKey = "1001";
        String secret = "tttb1001";
        String data = "{\"name\":\"hello\"}";
        String encodedData = DataEncoder.encodeUrl(data);

        String sign = DataEncoder.md5Hex(apiName + "_" + apiVersion + "_" + appKey + "_" + secret + "_" + encodedData);

        boolean result = ApiHelper.verify(apiName, apiVersion, appKey, encodedData, sign);

        assertTrue(result);

    }
}
