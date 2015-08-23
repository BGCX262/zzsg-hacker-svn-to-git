package com.nopackname.response;

public class API_BASE_RESPONSE {
    private int code;
    private API_SUB_RESPONSE ret;// json

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public API_SUB_RESPONSE getRet() {
        return ret;
    }

    public void setRet(API_SUB_RESPONSE ret) {
        this.ret = ret;
    }

}
