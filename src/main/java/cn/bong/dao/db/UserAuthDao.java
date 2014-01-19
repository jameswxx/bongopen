package cn.bong.dao.db;

import cn.bong.dao.beans.UserAuth;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: xiaoxue.wangxx
 * Date: 14-1-17
 * Time: 上午9:55
 * To change this template use File | Settings | File Templates.
 */
public class UserAuthDao extends BaseDBDao {

    public boolean addUserAuth(long appKey, long userId) {
        boolean flag = true;
        try {
            sqlMapClient.insert("UserAuth.addUserAuth", new UserAuth(userId, appKey));
        } catch (SQLException e) {
            flag = false;
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return flag;
    }

    public boolean isExist(long appKey, long userId) {
        boolean flag = false;
        try {
            Long count = (Long) sqlMapClient.queryForObject("UserAuth.selectCountByPrimaryKey",
                    new UserAuth(userId, appKey));
            if (count > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    public boolean delete(long appKey, long userId) {
        boolean flag = true;

        try {
            sqlMapClient.update("UserAuth.deleteByPrimaryKey", new UserAuth(userId, appKey));
        } catch (SQLException e) {
            flag = false;
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return flag;
    }
}
