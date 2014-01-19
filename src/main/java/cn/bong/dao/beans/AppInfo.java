package cn.bong.dao.beans;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: xiaoxue.wangxx
 * Date: 14-1-17
 * Time: 上午9:27
 * To change this template use File | Settings | File Templates.
 */
public class AppInfo implements Serializable {

    private long id;

    private long appKey;

    private String appName;

    private String secret;

    private String owner;

    public AppInfo() {

    }

    public AppInfo(String appName, long appKey, String secret, String owner) {
        this.appName = appName;
        this.appKey = appKey;
        this.secret = secret;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAppKey() {
        return appKey;
    }

    public void setAppKey(long appKey) {
        this.appKey = appKey;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
