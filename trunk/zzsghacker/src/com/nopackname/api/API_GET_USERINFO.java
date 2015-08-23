package com.nopackname.api;

public class API_GET_USERINFO extends API {
    // /api_get_userinfo.php?jsonpcallback=jsonp1411542452515&_=1411542456494&
    // key=a1515c0cba99d6f4336f4d88d73bf93b&_l=chs&_p=ZZ-DROID-CHS-TTGW
    public API_GET_USERINFO() {
        super();
        path = "/api_get_userinfo.php?";
    }

    @Override
    public String toString() {
        StringBuilder uriBuilder = new StringBuilder();
        uriBuilder.append(path).append(JSONPCALLBACK).append(EQUAL).append(jsonpcallback);
        uriBuilder.append(AND).append(_).append(EQUAL).append(tag_);
        uriBuilder.append(AND).append(KEY).append(EQUAL).append(key);
        uriBuilder.append(AND).append(_L).append(EQUAL).append(_l);
        uriBuilder.append(AND).append(_P).append(EQUAL).append(_p);
        return uriBuilder.toString();
    }

    public static void main(String[] args) {
        API_GET_USERINFO api_get_userinfo = new API_GET_USERINFO();
        System.out.println(api_get_userinfo.toString());
    }
}
