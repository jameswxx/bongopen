package cn.bong.test;

import cn.bong.dao.beans.AppInfo;
import cn.bong.dao.beans.UserAuth;
import cn.bong.dao.db.AppInfoDao;
import cn.bong.dao.db.UserAuthDao;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: xiaoxue.wangxx
 * Date: 14-1-17
 * Time: 下午3:29
 * To change this template use File | Settings | File Templates.
 */
public class UserAuthTest extends TestCase {
    UserAuthDao dao = new UserAuthDao();

    @Test
    public void testAll() {
        dao.addUserAuth(1001L, 2001L);

        boolean flag = dao.isExist(1001L, 2001L);
        assertTrue(flag);

        //test delete
        dao.delete(1001L, 2001L);
        flag = dao.isExist(1001L, 2001L);
        assertFalse(flag);
    }
}