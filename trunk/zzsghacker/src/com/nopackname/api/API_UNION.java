package com.nopackname.api;

public class API_UNION extends API {

    // /api_union.php?jsonpcallback=jsonp1416379292181&_=1416379777606&
    // key=740e978717d64de3a6476c90ff2695cd&action=my&_l=chs&_p=ZZ-DROID-CHS-TTGW
    // HTTP/1.0

    // /api_union.php?jsonpcallback=jsonp1416379292182&_=1416379778980&
    // key=740e978717d64de3a6476c90ff2695cd&action=member&page=1&_l=chs&_p=ZZ-DROID-CHS-TTGW
    // HTTP/1.0
    private String action;
    private int page;

    public static final String API_UNION_ACTION_MY = "my";
    public static final String API_UNION_ACTION_MEMBER = "member";

    // get page good list
    public API_UNION(String action, int page) {
        super();
        path = "/api_union.php?";
        this.action = action;
        this.page = page;
    }

    public API_UNION(String action) {
        super();
        path = "/api_goods.php?";
        this.action = action;
    }

    @Override
    public String toString() {
        StringBuilder uriBuilder = new StringBuilder();
        uriBuilder.append(path).append(JSONPCALLBACK).append(EQUAL)
                .append(jsonpcallback);
        uriBuilder.append(AND).append(_).append(EQUAL).append(tag_);
        uriBuilder.append(AND).append(KEY).append(EQUAL).append(key);
        uriBuilder.append(AND).append(ACTION).append(EQUAL).append(action);
        if (API_UNION_ACTION_MEMBER.equals(action)) {
            uriBuilder.append(AND).append(PAGE).append(EQUAL).append(page);
        }
        uriBuilder.append(AND).append(_L).append(EQUAL).append(_l);
        uriBuilder.append(AND).append(_P).append(EQUAL).append(_p);
        return uriBuilder.toString();
    }

    // setter & getter

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

}
