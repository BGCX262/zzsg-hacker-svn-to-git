package com.nopackname.api;

public class API_MY_GEN_MOD extends API {

    // /api_my_gen_mod.php?jsonpcallback=jsonp1411542456840&_=1411542466921&key=a1515c0cba99d6f4336f4d88d73bf93b
    // &action=washprice&id=378933&city=91739&_l=chs&_p=ZZ-DROID-CHS-TTGW
    // /api_my_gen_mod.php?jsonpcallback=jsonp1411542456841&_=1411542469673&key=a1515c0cba99d6f4336f4d88d73bf93b
    // &action=reinit&id=378933&city=91739&mode=1&_l=chs&_p=ZZ-DROID-CHS-TTGW
    // /api_my_gen_mod.php?jsonpcallback=jsonp1411542456872&_=1411542493170&key=a1515c0cba99d6f4336f4d88d73bf93b
    // &action=reject&id=378933&city=91739&mode=1&_l=chs&_p=ZZ-DROID-CHS-TTGW
    // /api_my_gen_mod.php?jsonpcallback=jsonp1411542456872&_=1411542493170&key=a1515c0cba99d6f4336f4d88d73bf93b
    // &action=accept&id=378933&city=91739&mode=1&_l=chs&_p=ZZ-DROID-CHS-TTGW
    // /api_my_gen_mod.php?jsonpcallback=jsonp1412059503532&_=1412062681261&key=8e6f2fdcaff0b469a689e3eb2a6b66ac
    // &action=exptrain&mode=0&city=91739&id=378933&_l=chs&_p=ZZ-DROID-CHS-TTGW
    /** for mod gen summary */
    public static final String WASHPRICE = "washprice";
    /** mod gen */
    public static final String REINIT = "reinit";
    public static final String REJECT = "reject";
    public static final String ACCEPT = "accept";
    /** train */
    public static final String EXPTRAIN = "exptrain";

    // constant
    public static final int MODE_EXP = 1;
    public static final int MODE_MONEY = 2;
    public static final int MODE_MONEY2 = 3;
    // 
    String action = WASHPRICE;
    int id;
    int city;
    int mode = MODE_EXP;

    public API_MY_GEN_MOD() {
        super();
        this.path = "/api_my_gen_mod.php?";
    }

    public API_MY_GEN_MOD(String action, int id, int city, int mode) {
        super();
        this.path = "/api_my_gen_mod.php?";
        this.action = action;
        this.id = id;
        this.city = city;
        this.mode = mode;
    }

    public API_MY_GEN_MOD(String action, int id, int city) {
        super();
        this.path = "/api_my_gen_mod.php?";
        this.action = action;
        this.id = id;
        this.city = city;
    }

    @Override
    public String toString() {
        StringBuilder uriBuilder = new StringBuilder();
        uriBuilder.append(path).append(JSONPCALLBACK).append(EQUAL).append(jsonpcallback);
        uriBuilder.append(AND).append(_).append(EQUAL).append(tag_);
        uriBuilder.append(AND).append(KEY).append(EQUAL).append(key);
        //
        uriBuilder.append(AND).append(ACTION).append(EQUAL).append(action);
        uriBuilder.append(AND).append(ID).append(EQUAL).append(id);
        uriBuilder.append(AND).append(CITY).append(EQUAL).append(city);
        if (!WASHPRICE.equals(action)) {
            uriBuilder.append(AND).append(MODE).append(EQUAL).append(mode);
        }
        //
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

}
