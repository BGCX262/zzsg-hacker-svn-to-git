package com.nopackname.response;

import java.util.ArrayList;
import java.util.List;

import com.nopackname.tools.JSONUtil;

public class API_UNION_MEMBER_RESPONSE {
    private int code;
    private API_UNION_MEMBER_RET ret;// json

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public API_UNION_MEMBER_RET getRet() {
        return ret;
    }

    public void setRet(API_UNION_MEMBER_RET ret) {
        this.ret = ret;
    }

    public static void main(String[] args) {
        API_UNION_MEMBER_RESPONSE resp = new API_UNION_MEMBER_RESPONSE();
        resp.setCode(0);
        API_UNION_MEMBER_RET ret = new API_UNION_MEMBER_RET();
        ret.setMax(5);
        List<Object> list = new ArrayList<Object>();
        List<Object> member = new ArrayList<Object>();
        member.add(90972);// id
        member.add("小凡");// player name
        member.add(3);// type
        member.add(132);// level
        member.add(5161);// ???
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
        ret.setList(list);
        List<Integer> score = new ArrayList<Integer>();
        score.add(98290569);
        ret.setScore(score);
        resp.setRet(ret);
        System.out.println(JSONUtil.generateJSON(resp));
    }
}
