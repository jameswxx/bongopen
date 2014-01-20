package cn.bong.api;

/**
 * Created with IntelliJ IDEA.
 * User: xiaoxue.wangxx
 * Date: 14-1-18
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */
public enum ErrorInfo {
    SYSTEM_ERROR("-1", "系统错误"),
    VERIFY_ERROR("-2", "权限校验未通过"),
    NO_THIS_API("-3", "没有这个API");

    private ErrorInfo(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;

    private String msg;

    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
