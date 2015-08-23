package com.nopackname.api;

public class API_GET_CITYINFO extends API {

    // /api_get_cityinfo.php?jsonpcallback=jsonp1416379292190&_=1416379796398&
    // key=740e978717d64de3a6476c90ff2695cd&action=trade_out&city=91739&uid_to=89880&city_to=89844&_l=chs&_p=ZZ-DROID-CHS-TTGW
    // HTTP/1.0

    public static final String UID_TO = "uid_to";
    public static final String CITY_TO = "city_to";
    private int uid_to;
    private int city_to;
    private String action;

    public static final String API_GET_CITYINFO_ACTION_TRADE_OUT = "trade_out";

    /**
     * trade
     * 
     * @param myCity
     * @param uid_to
     * @param city_to
     */
    public API_GET_CITYINFO(String action, int myCity, int uid_to, int city_to) {
        super();
        path = "/api_get_cityinfo.php?";
        this.action = action;
        this.city = myCity;
        this.uid_to = uid_to;
        this.city_to = city_to;
    }

    @Override
    public String toString() {
        StringBuilder uriBuilder = new StringBuilder();
        uriBuilder.append(path).append(JSONPCALLBACK).append(EQUAL)
                .append(jsonpcallback);
        uriBuilder.append(AND).append(_).append(EQUAL).append(tag_);
        uriBuilder.append(AND).append(KEY).append(EQUAL).append(key);
        uriBuilder.append(AND).append(ACTION).append(EQUAL).append(action);
        if (API_GET_CITYINFO_ACTION_TRADE_OUT.equals(action)) {
            uriBuilder.append(AND).append(CITY).append(EQUAL).append(city);
            uriBuilder.append(AND).append(UID_TO).append(EQUAL).append(uid_to);
            uriBuilder.append(AND).append(CITY_TO).append(EQUAL)
                    .append(city_to);
        }
        uriBuilder.append(AND).append(_L).append(EQUAL).append(_l);
        uriBuilder.append(AND).append(_P).append(EQUAL).append(_p);
        return uriBuilder.toString();
    }

    public int getUid_to() {
        return uid_to;
    }

    public void setUid_to(int uid_to) {
        this.uid_to = uid_to;
    }

    public int getCity_to() {
        return city_to;
    }

    public void setCity_to(int city_to) {
        this.city_to = city_to;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
