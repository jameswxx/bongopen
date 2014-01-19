package cn.bong.test;

import cn.bong.dao.beans.AppInfo;
import cn.bong.dao.db.AppInfoDao;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: xiaoxue.wangxx
 * Date: 14-1-17
 * Time: 上午11:33
 * To change this template use File | Settings | File Templates.
 */
public class AppInfoDaoTest extends TestCase {
    AppInfoDao dao = new AppInfoDao();

    @BeforeClass
    public void setUp() {

    }

    @AfterClass
    public void tearDown() {

    }

    @Test
    public void testAll() {
        AppInfo insertApp = new AppInfo();

        //test insert
        insertApp.setAppKey(1001);
        insertApp.setAppName("name1");
        insertApp.setOwner("owner1");
        insertApp.setSecret("secret1");
        dao.addAppInfo(insertApp);

        AppInfo app = dao.getAppInfo(1001L);
        assertEquals(1001L, app.getAppKey());
        assertEquals("name1", app.getAppName());
        assertEquals("owner1", app.getOwner());
        assertEquals("secret1", app.getSecret());

        //test update
        app.setAppName("name1_updated");
        dao.updateAppInfo(app);
        app = dao.getAppInfo(1001L);
        assertEquals("name1_updated", app.getAppName());

        //test delete
        dao.delete(1001L);
        app = dao.getAppInfo(1001L);
        assertNull(app);
    }
}
