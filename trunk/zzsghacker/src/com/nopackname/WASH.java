package com.nopackname;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.nopackname.api.*;
import com.nopackname.db.Global;
import com.nopackname.tools.*;
import com.nopackname.response.*;

public class WASH {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // constant

        // initial
        int myGeneralId = Global.yanbcZhouyu;
        int myCity = Global.yanbcCity;

        // target
        int pcTarget = -1;
        int piTarget = -1;
        int pwTarget = -2; // initial value -2
        int currentPc = 0;
        int currentPi = 0;
        int currentPw = 0;
        int currentPcMax = 0;
        int currentPiMax = 0;
        int currentPwMax = 0;
        Queue<API> commands = new ConcurrentLinkedQueue<API>();
        commands.add(new API_GET_USERINFO());
        commands.add(new API_MY_GEN_MOD(API_MY_GEN_MOD.WASHPRICE, myGeneralId,
                myCity));
        commands.add(new API_MY_GEN_MOD(API_MY_GEN_MOD.REINIT, myGeneralId,
                myCity, API_MY_GEN_MOD.MODE_EXP));

        // do command
        while (true) {
            API cmd = commands.poll();
            if (null == cmd)
                break;
            String uriString = API.HOST_MAIN + cmd.toString();
            Map<String, String> headers = new HashMap<String, String>();
            final HttpResult result = new HttpResult();
            try {
                HttpClient.httpGet(uriString, headers, result,
                        API.generateAccLgoinResponseHandler(result));
            } catch (Exception e) {
            }
            if (cmd instanceof API_MY_GEN_MOD) {
                // logical
                API_MY_GEN_MOD gen = (API_MY_GEN_MOD) cmd;
                if (API_MY_GEN_MOD.REINIT.equals(gen.getAction())) {
                    API_MY_GEN_MOD_REINIT_BASE_RESPONSE resp = (API_MY_GEN_MOD_REINIT_BASE_RESPONSE) JSONUtil
                            .parseObject(result.getResponse(),
                                    API_MY_GEN_MOD_REINIT_BASE_RESPONSE.class);
                    API_MY_GEN_MOD_REINIT_RESPONSE reinit = resp.getRet();

                    boolean accept = true;
                    // judgement
                    if (pcTarget > 0 && reinit.getCt() < currentPc)
                        accept = false;
                    if (piTarget > 0 && reinit.getIt() < currentPi)
                        accept = false;
                    if (pwTarget > 0 && reinit.getWt() < currentPw)
                        accept = false;
                    System.out.println("now wuli: " + reinit.getCt() + " pre: "
                            + currentPc);
                    System.out.println("now jueji: " + reinit.getIt()
                            + " pre: " + currentPi);
                    System.out.println("now moulve: " + reinit.getWt()
                            + " pre: " + currentPw);
                    if (accept) {
                        // accept
                        currentPc = reinit.getCt();
                        currentPi = reinit.getIt();
                        currentPw = reinit.getWt();
                        commands.add(new API_MY_GEN_MOD(API_MY_GEN_MOD.ACCEPT,
                                myGeneralId, myCity, API_MY_GEN_MOD.MODE_EXP));
                        System.out
                                .println("====================================================ACCEPTED!====================================================");
                    } else
                        // reject
                        commands.add(new API_MY_GEN_MOD(API_MY_GEN_MOD.REJECT,
                                myGeneralId, myCity, API_MY_GEN_MOD.MODE_EXP));
                    // reinit
                    boolean needReinit = false;
                    if (pcTarget != -2 && currentPc < currentPcMax - 10)
                        needReinit = true;
                    if (piTarget != -2 && currentPi < currentPiMax - 10)
                        needReinit = true;
                    if (pwTarget != -2 && currentPw < currentPwMax - 10)
                        needReinit = true;
                    if (needReinit)
                        commands.add(new API_MY_GEN_MOD(API_MY_GEN_MOD.REINIT,
                                myGeneralId, myCity, API_MY_GEN_MOD.MODE_EXP));
                } else if (API_MY_GEN_MOD.REJECT.equals(gen.getAction())) {

                } else if (API_MY_GEN_MOD.ACCEPT.equals(gen.getAction())) {

                } else if (API_MY_GEN_MOD.WASHPRICE.equals(gen.getAction())) {
                    API_MY_GEN_MOD_WASHPRICE_BASE_RESPONSE baseResp = (API_MY_GEN_MOD_WASHPRICE_BASE_RESPONSE) JSONUtil
                            .parseObject(
                                    result.getResponse(),
                                    API_MY_GEN_MOD_WASHPRICE_BASE_RESPONSE.class);
                    API_MY_GEN_MOD_WASHPRICE_RESPONSE resp = baseResp.getRet();
                    currentPc = resp.getPc();
                    currentPcMax = resp.getPcmax();
                    if (currentPc < currentPcMax - 10 && -1 == pcTarget)
                        pcTarget = currentPcMax - 10;
                    currentPi = resp.getPi();
                    currentPiMax = resp.getPimax();
                    if (currentPi < currentPiMax - 10 && -1 == piTarget)
                        piTarget = currentPiMax - 10;
                    currentPw = resp.getPw();
                    currentPwMax = resp.getPwmax();
                    if (currentPw < currentPwMax - 10 && -1 == pwTarget)
                        pwTarget = currentPwMax - 10;
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
