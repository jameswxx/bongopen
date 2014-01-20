<%@ page import="cn.bong.api.Switcher" %>
<%

    String ua = request.getParameter("ua");
    String pwd = request.getParameter("pwd");
    if (!ua.equals("bong") || !pwd.equals("hello_bong")) {
        return;
    }

    String method = request.getParameter("m");
    if (method == null) {
        return;
    }

    if (method.equals("switch")) {
        String apiVerify = request.getParameter("apiVerify");
        if (apiVerify != null) {
            Switcher.API_VERIFY = apiVerify.equals("true");
        }
    }
%>