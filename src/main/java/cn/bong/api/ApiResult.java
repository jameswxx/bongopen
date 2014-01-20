package cn.bong.api;

/**
 * Created with IntelliJ IDEA.
 * User: xiaoxue.wangxx
 * Date: 14-1-18
 * Time: 下午4:04
 * To change this template use File | Settings | File Templates.
 */
public class ApiResult {

    private String apiVersion;

    private String apiName;

    private boolean isSuccess;

    private String errorCode;

    private String errorMsg;

    private Object data;

    public ApiResult(String apiVersion, String apiName) {
        this.apiVersion = apiVersion;
        this.apiName = apiName;
    }

    public ApiResult(String apiVersion, String apiName, Object data) {
        this.apiVersion = apiVersion;
        this.apiName = apiName;
        this.data = data;
        isSuccess = true;
    }

    public ApiResult(String apiVersion, String apiName, ErrorInfo error) {
        this.apiVersion = apiVersion;
        this.apiName = apiName;
        this.errorCode = error.getCode();
        this.errorMsg = error.getMsg();
        this.isSuccess = false;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setError(ErrorInfo errorInfo) {
        this.errorCode = errorInfo.getCode();
        this.errorMsg = errorInfo.getMsg();
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
