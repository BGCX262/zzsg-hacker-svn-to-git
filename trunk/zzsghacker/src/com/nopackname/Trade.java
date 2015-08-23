package com.nopackname;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.nopackname.api.API;
import com.nopackname.api.API_GET_CITYINFO;
import com.nopackname.api.API_GET_USERINFO2;
import com.nopackname.api.API_UNION;
import com.nopackname.db.Global;
import com.nopackname.response.API_GET_USERINFO2_RESPONSE;
import com.nopackname.response.API_GET_USERINFO2_RET;
import com.nopackname.response.API_UNION_MEMBER_RESPONSE;
import com.nopackname.response.API_UNION_MEMBER_RET;
import com.nopackname.tools.HttpClient;
import com.nopackname.tools.HttpResult;
import com.nopackname.tools.JSONUtil;

public class Trade {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // constant

        // init
        int myId = Global.bcjId;
        int myCity = Global.bcjCity;

        Queue<API> commands = new ConcurrentLinkedQueue<API>();
        commands.add(new API_UNION(API_UNION.API_UNION_ACTION_MEMBER, 2));
        // do command
        while (true) {
            API cmd = commands.poll();
            if (null == cmd) {
                break;
            }
            String uriString = API.HOST_MAIN + cmd.toString();
            Map<String, String> headers = new HashMap<String, String>();
            final HttpResult result = new HttpResult();
            try {
                HttpClient.httpGet(uriString, headers, result,
                        API.generateAccLgoinResponseHandler(result));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (cmd instanceof API_UNION) {
                // query union member
                API_UNION union = (API_UNION) cmd;
                if (API_UNION.API_UNION_ACTION_MEMBER.equals(union.getAction())) {
                    API_UNION_MEMBER_RESPONSE resp = (API_UNION_MEMBER_RESPONSE) JSONUtil
                            .parseObject(result.getResponse(),
                                    API_UNION_MEMBER_RESPONSE.class);
                    // save memberId
                    API_UNION_MEMBER_RET ret = resp.getRet();
                    List<Object> list = ret.getList();
                    for (Object member : list) {
                        @SuppressWarnings("unchecked")
                        List<Object> attr = (List<Object>) member;
                        Integer memberId = (Integer) attr.get(0);
                        if (myId != memberId) {
                            commands.add(new API_GET_USERINFO2(memberId));
                        }
                    }
                }
            } else if (cmd instanceof API_GET_USERINFO2) {
                // query city id
                API_GET_USERINFO2_RESPONSE resp = (API_GET_USERINFO2_RESPONSE) JSONUtil
                        .parseObject(result.getResponse(),
                                API_GET_USERINFO2_RESPONSE.class);
                API_GET_USERINFO2_RET ret = resp.getRet();
                int playerId = (Integer) ret.getUser().get(0);
                int cityId = ret.getCity().get(0).getId();
                commands.add(new API_GET_CITYINFO(
                        API_GET_CITYINFO.API_GET_CITYINFO_ACTION_TRADE_OUT,
                        myCity, playerId, cityId));
            } else if (cmd instanceof API_GET_CITYINFO) {
                // do trade response
                System.out.println(result.getResponse());
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Finished.");
    }
}
