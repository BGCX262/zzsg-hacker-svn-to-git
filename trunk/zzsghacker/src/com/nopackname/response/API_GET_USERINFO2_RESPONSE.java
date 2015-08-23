package com.nopackname.response;

import java.util.ArrayList;
import java.util.List;

import com.nopackname.bean.City;
import com.nopackname.tools.JSONUtil;

public class API_GET_USERINFO2_RESPONSE {
    private int code;
    private API_GET_USERINFO2_RET ret;// json

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public API_GET_USERINFO2_RET getRet() {
        return ret;
    }

    public void setRet(API_GET_USERINFO2_RET ret) {
        this.ret = ret;
    }

    public static void main(String[] args) {
        API_GET_USERINFO2_RESPONSE resp = new API_GET_USERINFO2_RESPONSE();
        resp.setCode(0);
        API_GET_USERINFO2_RET ret = new API_GET_USERINFO2_RET();
        List<Object> user = new ArrayList<Object>();
        user.add(90972);// id
        user.add("小凡");// player name
        user.add(3);// type
        user.add(132);// level
        user.add(5161);// ???
        user.add("鱼和熊");// union name
        user.add(38);// ???
        user.add(1);// ???
        user.add(0);// ???
        List<Object> subAttr = new ArrayList<Object>();
        subAttr.add(0); // ???
        subAttr.add(0); // ???
        subAttr.add(""); // ???
        user.add(subAttr);
        user.add(0);// ???
        user.add(0);// ???
        ret.setUser(user);
        List<City> city = new ArrayList<City>();
        City oneCity = new City();
        oneCity.setId(90921);
        oneCity.setName("巨鹿城");
        oneCity.setIn(3);
        city.add(oneCity);
        ret.setCity(city);
        resp.setRet(ret);
        System.out.println(JSONUtil.generateJSON(resp));
    }
}
