package cn.bong.dao.beans;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: xiaoxue.wangxx
 * Date: 14-1-17
 * Time: 上午9:21
 * To change this template use File | Settings | File Templates.
 */
public class UserAuth implements Serializable {

    private long userId;

    private long appKey;

    public UserAuth() {

    }

    public UserAuth(long userId, long appKey) {
        this.userId = userId;
        this.appKey = appKey;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAppKey() {
        return appKey;
    }

    public void setAppKey(long appKey) {
        this.appKey = appKey;
    }
}
