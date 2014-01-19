package cn.bong.api;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: xiaoxue.wangxx
 * Date: 14-1-18
 * Time: 下午4:12
 * To change this template use File | Settings | File Templates.
 */
public abstract class ApiProcessor {

    public abstract ApiResult process(Map<String, String> params);
}
