package com.nopackname.tools;

public class HttpResult {
    /**
     * 返回HTTP状态
     */
    private String status = "-1";

    /**
     * 返回请求结果
     */
    private String response;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponse() {
        int start = response.indexOf("(");
        int end = response.indexOf(")");
        return response.substring(start + 1, end);
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
