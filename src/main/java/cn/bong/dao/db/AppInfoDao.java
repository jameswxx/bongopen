package cn.bong.dao.db;

import cn.bong.dao.beans.AppInfo;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: xiaoxue.wangxx
 * Date: 14-1-17
 * Time: 上午9:55
 * To change this template use File | Settings | File Templates.
 */
public class AppInfoDao extends BaseDBDao {

    public boolean addAppInfo(AppInfo bean) {
        boolean flag = false;

        try {
            Object result = sqlMapClient.insert("AppInfo.addAppInfo", bean);
            if (result != null) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return flag;
    }

    public boolean updateAppInfo(AppInfo bean) {
        boolean flag = true;

        try {
            sqlMapClient.update("AppInfo.updateAppInfo", bean);
        } catch (SQLException e) {
            flag = false;
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return flag;
    }

    public AppInfo getAppInfo(Long appKey) {
        AppInfo app = null;
        try {
            app = (AppInfo) sqlMapClient.queryForObject("AppInfo.selectByAppKey", appKey);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return app;
    }

    public boolean delete(long appKey) {
        boolean flag = true;

        try {
            sqlMapClient.update("AppInfo.deleteByAppKey", appKey);
        } catch (SQLException e) {
            flag = false;
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return flag;
    }

}
