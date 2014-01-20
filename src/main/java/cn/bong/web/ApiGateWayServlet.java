package cn.bong.web;

import cn.bong.api.*;
import cn.bong.api.util.ApiHelper;
import cn.bong.api.util.DataEncoder;
import cn.bong.dao.beans.AppInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: xiaoxue.wangxx
 * Date: 14-1-18
 * Time: 下午3:45
 * To change this template use File | Settings | File Templates.
 */
public class ApiGateWayServlet extends HttpServlet {
    public void init() throws ServletException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String apiName = request.getParameter("api");
        String apiVersion = request.getParameter("v");
        String appKey = request.getParameter("key");
        String sign = request.getParameter("sign");
        String data = request.getParameter("data");


        ApiResult result = null;
        try {
            if (!ApiHelper.verify(apiName, apiVersion, appKey, data, sign)) {
                result = new ApiResult(apiVersion, apiName, ErrorInfo.VERIFY_ERROR);
            } else {
                ApiProcessor api = ApiMapping.getApi(apiName, apiVersion);
                if (api == null) {
                    result = new ApiResult(apiVersion, apiName, ErrorInfo.NO_THIS_API);
                } else {
                    data = DataEncoder.decodeUrl(data);
                    result = api.process(JSON.parseObject(data));
                    result.setApiName(apiName);
                    result.setApiVersion(apiVersion);
                }
            }
        } catch (Exception e) {
            result = new ApiResult(apiVersion, apiName, ErrorInfo.SYSTEM_ERROR);
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        response.setContentType("text/html;charset=GBk");
        print(response.getWriter(), result);
    }

    private void print(PrintWriter out, ApiResult result) {
        out.println(JSON.toJSON(result));
        out.flush();
        out.close();
    }
}
