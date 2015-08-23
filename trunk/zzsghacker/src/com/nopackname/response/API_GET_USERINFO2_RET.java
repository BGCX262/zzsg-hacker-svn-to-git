package com.nopackname.response;

import java.util.List;

import com.nopackname.bean.City;

public class API_GET_USERINFO2_RET {
    private List<Object> user;
    private List<City> city;

    public List<Object> getUser() {
        return user;
    }

    public void setUser(List<Object> user) {
        this.user = user;
    }

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }

}
