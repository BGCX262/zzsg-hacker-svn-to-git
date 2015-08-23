package com.nopackname.response;

import java.util.ArrayList;
import java.util.List;

import com.nopackname.tools.JSONUtil;

public class API_UNION_MEMBER_RET {
    private List<Object> list;
    private List<Integer> score;
    private int max;

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public List<Integer> getScore() {
        return score;
    }

    public void setScore(List<Integer> score) {
        this.score = score;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public static void main(String[] args) {
        API_UNION_MEMBER_RET resp = new API_UNION_MEMBER_RET();
        resp.setMax(5);
        List<Object> list = new ArrayList<Object>();
        List<Object> member = new ArrayList<Object>();
        member.add(90972);// id
        member.add("小凡");// player name
        member.add(3);// type
        member.add(132);// level
        member.add(5161);// union id
        member.add("鱼和熊");// union name
        member.add(38);// ???
        member.add(1);// ???
        member.add(0);// ???
        List<Object> subAttr = new ArrayList<Object>();
        subAttr.add(0); // ???
        subAttr.add(0); // ???
        subAttr.add(""); // ???
        member.add(subAttr);
        member.add(0);// ???
        member.add(0);// ???
        list.add(member);
        resp.setList(list);
        List<Integer> score = new ArrayList<Integer>();
        score.add(98290569);
        resp.setScore(score);
        System.out.println(JSONUtil.generateJSON(resp));
    }
}
