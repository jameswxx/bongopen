package cn.bong.web;

import cn.bong.api.ApiMapping;
import cn.bong.api.ApiProcessor;
import cn.bong.api.ApiResult;
import cn.bong.api.ErrorInfo;
import com.alibaba.fastjson.JSON;

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
        Map map = request.getParameterMap();
        String apiName = request.getParameter("api");
        String apiVersion = request.getParameter("v");
        String appKey = request.getParameter("key");
        String sign = request.getParameter("sign");
        String data = request.getParameter("data");


        ApiResult result = null;
        if (!verify(apiName, apiVersion, appKey, data, sign)) {
            result = new ApiResult(apiVersion, apiName, ErrorInfo.VERIFY_ERROR);
        } else {
            ApiProcessor api = ApiMapping.getApi(apiName, apiVersion);
            if (api == null) {
                result = new ApiResult(apiVersion, apiName, ErrorInfo.NO_THIS_API);
            } else {
                result = api.process(new HashMap<String, String>());
                result.setApiName(apiName);
                result.setApiVersion(apiVersion);
            }
        }

        response.setContentType("text/html;charset=GBk");
        print(response.getWriter(), result);
    }

    private boolean verify(String apiName, String apiVersion, String appKey, String data, String sign) {
        return true;
    }

    private void print(PrintWriter out, ApiResult result) {
        out.println(JSON.toJSON(result));
        out.flush();
        out.close();
    }
}
