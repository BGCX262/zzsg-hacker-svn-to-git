package com.nopackname.response;

import java.util.ArrayList;
import java.util.List;

import com.nopackname.bean.Attribute;
import com.nopackname.bean.Good;
import com.nopackname.bean.Item;
import com.nopackname.tools.JSONUtil;

public class API_GOODS_LIST_RESPONSE {
    private List<Good> item;
    private int max;
    private String num;
    private int size;

    public List<Good> getItem() {
        return item;
    }

    public void setItem(List<Good> item) {
        this.item = item;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static void main(String[] args) {
        API_GOODS_LIST_RESPONSE resp = new API_GOODS_LIST_RESPONSE();
        List<Good> item = new ArrayList<Good>();
        Good good = new Good();
        Item it = new Item();
        it.setId(999999);
        it.setSid(122);
        it.setUp(0);
        Attribute attr = new Attribute();
        attr.setXed(0);
        attr.setXea(0);
        attr.setExd(0);
        attr.setExa(0);
        attr.setEnd(0);
        attr.setEna(124);
        attr.setC(0);
        attr.setCourage(0);
        attr.setWisdom(0);
        attr.setInstinct(0);
        attr.setR_power(0);
        it.setAttr(attr);
        good.setItem(it);
        good.setSale(4000);
        good.setNum(1);
        good.setUse(0);
        good.setJewel_effect(null);
        item.add(good);
        resp.setItem(item);
        resp.setMax(6);
        resp.setNum("6");
        resp.setSize(6);
        System.out.println(JSONUtil.generateJSON(resp));
    }
}
