package cn.bong.dao.http;


import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: xiaoxue.wangxx
 * Date: 14-1-17
 * Time: 下午3:41
 * To change this template use File | Settings | File Templates.
 */
public class ApacheHttpClient {
    private static final String CHARSET = HTTP.UTF_8;

    /**
     * 每个路由最大连接数
     */
    public final static int MAX_ROUTE_CONNECTIONS = 400;

    /**
     * 最大连接数
     */
    public final static int MAX_TOTAL_CONNECTIONS = 800;
    private static final HttpClient client = initHttpClient();

    private static synchronized HttpClient initHttpClient() {
        HttpParams params = new BasicHttpParams();
        // 设置一些基本参数
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(params, CHARSET);
        HttpProtocolParams.setUseExpectContinue(params, true);

        // 超时设置和最大连接数
        ConnManagerParams.setMaxTotalConnections(params, MAX_TOTAL_CONNECTIONS);
        ConnManagerParams.setTimeout(params, 5000);// 从连接池中取连接的超时时间
        ConnPerRouteBean connPerRoute = new ConnPerRouteBean(
                MAX_ROUTE_CONNECTIONS); // 设置每个路由最大连接数
        ConnManagerParams.setMaxConnectionsPerRoute(params, connPerRoute);

        HttpConnectionParams.setConnectionTimeout(params, 10000);// 通过网络与服务器建立连接的超时时间
        HttpConnectionParams.setSoTimeout(params, 10000);// Socket读数据的超时时间

        // 暂只支持http
        SchemeRegistry schReg = new SchemeRegistry();
        schReg.register(new Scheme("http", PlainSocketFactory
                .getSocketFactory(), 80));

        // 创建线程安全的client
        ClientConnectionManager conMgr = new ThreadSafeClientConnManager(
                params, schReg);

        return new DefaultHttpClient(conMgr, params);
    }

    public static void shutdown() {
        if (client != null && client.getConnectionManager() != null) {
            client.getConnectionManager().shutdown();
        }
    }

    /**
     * @author tianxiang
     * @date 2012-10-9 18:41:46
     */
    public static String executeHttpGet(String url) {
        System.out.println("url:" + url);
        InputStream in = null;
        BufferedReader reader = null;
        String result = null;
        HttpGet request = null;
        try {
            request = new HttpGet(url);
            HttpResponse r = client.execute(request);
            if (r != null && r.getEntity() != null) {
                in = r.getEntity().getContent();
                reader = new BufferedReader(new InputStreamReader(in, "utf-8"));

                if (r.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    StringBuilder sb = new StringBuilder();
                    String inputLine;
                    while ((inputLine = reader.readLine()) != null) {
                        sb.append(inputLine);
                    }
                    result = sb.toString();
                }
            } else {
            }
        } catch (Exception e) {
            if (request != null) {
                request.abort();
            }
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                //Log.e("ApacheHttpClient", "http请求执行错误", e);
            }
        }

        return result;
    }
}

