package com.nopackname.response;

public class API_GOODS_RESPONSE2 {
    private int code;
    private API_GOODS_SALE_RESPONSE ret;// json

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public API_GOODS_SALE_RESPONSE getRet() {
        return ret;
    }

    public void setRet(API_GOODS_SALE_RESPONSE ret) {
        this.ret = ret;
    }

}
