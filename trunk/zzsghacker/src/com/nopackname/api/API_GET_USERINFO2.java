package com.nopackname.api;

public class API_GET_USERINFO2 extends API {
    // /api_get_userinfo2.php?jsonpcallback=jsonp1416379292183&_=1416379781520&key=740e978717d64de3a6476c90ff2695cd&
    // id=90972&_l=chs&_p=ZZ-DROID-CHS-TTGW HTTP/1.0
    public API_GET_USERINFO2(int id) {
        super();
        this.id = id;
        path = "/api_get_userinfo2.php?";
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder uriBuilder = new StringBuilder();
        uriBuilder.append(path).append(JSONPCALLBACK).append(EQUAL)
                .append(jsonpcallback);
        uriBuilder.append(AND).append(_).append(EQUAL).append(tag_);
        uriBuilder.append(AND).append(KEY).append(EQUAL).append(key);
        uriBuilder.append(AND).append(ID).append(EQUAL).append(id);
        uriBuilder.append(AND).append(_L).append(EQUAL).append(_l);
        uriBuilder.append(AND).append(_P).append(EQUAL).append(_p);
        return uriBuilder.toString();
    }

}
