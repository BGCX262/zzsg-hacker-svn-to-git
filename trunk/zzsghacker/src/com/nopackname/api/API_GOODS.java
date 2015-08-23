package com.nopackname.api;

public class API_GOODS extends API {

    // /api_goods.php?jsonpcallback=jsonp1411869878198&_=1411870358831&
    // key=7359fe71b7ab9f074a56e8612f3d26f0&action=list&type=0&city=91739&page=1&_l=chs&_p=ZZ-DROID-CHS-TTGW

    // /api_goods.php?jsonpcallback=jsonp1411869878197&_=1411870358646&
    // key=7359fe71b7ab9f074a56e8612f3d26f0&id=9047976&city=91739&action=sale&num=1&_l=chs&_p=ZZ-DROID-CHS-TTGW

    private int id;
    private int num;
    private int type;
    private String action;
    private int city;
    private int page;

    public static final String API_GOODS_ACTION_LIST = "list";
    public static final String API_GOODS_ACTION_SALE = "sale";
    public static final int API_GOODS_TYPE_0 = 0;

    // get page good list
    public API_GOODS(int type, String action, int city, int page) {
        super();
        path = "/api_goods.php?";
        this.type = type;
        this.action = action;
        this.city = city;
        this.page = page;
    }

    public API_GOODS(int id, int num, String action, int city) {
        super();
        path = "/api_goods.php?";
        this.id = id;
        this.num = num;
        this.action = action;
        this.city = city;
    }

    @Override
    public String toString() {
        StringBuilder uriBuilder = new StringBuilder();
        uriBuilder.append(path).append(JSONPCALLBACK).append(EQUAL).append(jsonpcallback);
        uriBuilder.append(AND).append(_).append(EQUAL).append(tag_);
        uriBuilder.append(AND).append(KEY).append(EQUAL).append(key);
        uriBuilder.append(AND).append(ACTION).append(EQUAL).append(action);
        if (API_GOODS_ACTION_LIST.equals(action)) {
            uriBuilder.append(AND).append(TYPE).append(EQUAL).append(type);
        }
        if (API_GOODS_ACTION_SALE.equals(action)) {
            uriBuilder.append(AND).append(ID).append(EQUAL).append(id);
            uriBuilder.append(AND).append(NUM).append(EQUAL).append(num);
        }
        uriBuilder.append(AND).append(CITY).append(EQUAL).append(city);
        uriBuilder.append(AND).append(_L).append(EQUAL).append(_l);
        uriBuilder.append(AND).append(_P).append(EQUAL).append(_p);
        return uriBuilder.toString();
    }

    // setter & getter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

}
