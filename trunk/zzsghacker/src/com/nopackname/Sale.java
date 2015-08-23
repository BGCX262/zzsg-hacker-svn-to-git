package com.nopackname;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.nopackname.api.API;
import com.nopackname.api.API_GEN_CONSCRIBE;
import com.nopackname.api.API_GOODS;
import com.nopackname.bean.Good;
import com.nopackname.db.Global;
import com.nopackname.response.API_GOODS_LIST_RESPONSE;
import com.nopackname.response.API_GOODS_RESPONSE;
import com.nopackname.response.API_GOODS_RESPONSE2;
import com.nopackname.response.API_GOODS_SALE_RESPONSE;
import com.nopackname.tools.HttpClient;
import com.nopackname.tools.HttpResult;
import com.nopackname.tools.JSONUtil;

public class Sale {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // constant

        // init
        int myCity = Global.bcjCity;

        Queue<API> commands = new ConcurrentLinkedQueue<API>();
        commands.add(new API_GOODS(API_GOODS.API_GOODS_TYPE_0,
                API_GOODS.API_GOODS_ACTION_LIST, myCity, 1));

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
            if (cmd instanceof API_GOODS) {
                // logical
                API_GOODS list = (API_GOODS) cmd;
                if (API_GOODS.API_GOODS_ACTION_LIST.equals(list.getAction())) {
                    API_GOODS_RESPONSE resp = (API_GOODS_RESPONSE) JSONUtil
                            .parseObject(result.getResponse(),
                                    API_GOODS_RESPONSE.class);
                    API_GOODS_LIST_RESPONSE listResp = resp.getRet();
                    System.out.println(listResp.getMax());
                    List<Good> item = listResp.getItem();
                    List<Integer> ids = new ArrayList<Integer>();
                    for (Good good : item) {
                        Integer id = good.getItem().getId();
                        if (!ids.contains(id)) {
                            ids.add(id);
                        }
                    }
                    // add to sale list
                    for (Integer id : ids) {
                        commands.add(new API_GOODS(id, 1,
                                API_GOODS.API_GOODS_ACTION_SALE, myCity));
                    }
                } else if (API_GOODS.API_GOODS_ACTION_LIST.equals(list
                        .getAction())) {
                    API_GOODS_RESPONSE2 resp = (API_GOODS_RESPONSE2) JSONUtil
                            .parseObject(result.getResponse(),
                                    API_GOODS_RESPONSE2.class);
                    API_GOODS_SALE_RESPONSE saleResp = resp.getRet();
                    System.out.println(saleResp.getCredit());
                }
            } else if (cmd instanceof API_GEN_CONSCRIBE) {

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
