package com.nopackname.api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.nopackname.tools.HttpClient;
import com.nopackname.tools.HttpResult;

public class API_CHAT extends API {
    public static final String TARGETID = "targetid";
    public static final String TARGETID_DEFAULT = "0";

    public static final String TARGETTYPE = "targettype";
    public static final String TARGETTYPE_DEFAULT = "0";
    public static final String TARGETTYPE_WEI = "1";
    public static final String TARGETTYPE_SHU = "2";
    public static final String TARGETTYPE_WU = "3";

    public static final String TXT = "txt";

    String targetid = TARGETID_DEFAULT;
    String targettype = TARGETTYPE_DEFAULT;
    String txt = "";

    public API_CHAT() {
        super();
        path = "/api_chat.php?";
    }

    public API_CHAT(String targetid, String targettype, String txt) {
        super();
        path = "/api_chat.php?";
        this.targetid = targetid;
        this.targettype = targettype;
        this.txt = toURIEncoded(txt);
    }

    @Override
    public String toString() {
        // GET
        // /api_chat.php?jsonpcallback=jsonp1410847222600&_=1410848897214&key=02bf4daf8213c95f90578a2486964ca1&
        // targetid=0&targettype=0&txt=abc456&_l=chs&_p=ZZ-DROID-CHS-TTGW
        // HTTP/1.0
        StringBuilder uriBuilder = new StringBuilder();
        uriBuilder.append(path).append(JSONPCALLBACK).append(EQUAL).append(jsonpcallback);
        uriBuilder.append(AND).append(_).append(EQUAL).append(tag_);
        uriBuilder.append(AND).append(KEY).append(EQUAL).append(key);

        uriBuilder.append(AND).append(TARGETID).append(EQUAL).append(targetid);
        uriBuilder.append(AND).append(TARGETTYPE).append(EQUAL).append(targettype);
        uriBuilder.append(AND).append(TXT).append(EQUAL).append(txt);

        uriBuilder.append(AND).append(_L).append(EQUAL).append(_l);
        uriBuilder.append(AND).append(_P).append(EQUAL).append(_p);
        return uriBuilder.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // GET /api_chat.php?jsonpcallback=jsonp1411438646449&_=1411440345670&
        // key=b149f2af001fd35f6f5fdc82d013dd80&lineid=141143901290&_l=chs&_p=ZZ-DROID-CHS-TTGW
        // HTTP/1.0
        API_CHAT chat = new API_CHAT();
        chat.targettype = TARGETTYPE_DEFAULT;
        chat.txt = toURIEncoded("今天疯狂爆丹  555");
        System.out.println(chat.toString());
        String uriString = "http://101.251.194.245" + chat.toString();
        Map<String, String> headers = new HashMap<String, String>();
        final HttpResult result = new HttpResult();
        try {
            HttpClient.httpGet(uriString, headers, result, generateAccLgoinResponseHandler(result));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static String parseTxt2Unicode(String msg) {
        return toUnicodeString(msg);
    }

    public static String unicodeToGB(String s) {
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(s, "\\u");
        while (st.hasMoreTokens()) {
            sb.append((char) Integer.parseInt(st.nextToken(), 16));
        }
        return sb.toString();
    }

    public static String toURIEncoded(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    public static String toUnicodeString(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 0 && c <= 255) {
                sb.append(c);
            } else {
                sb.append("\\u" + Integer.toHexString(c));
            }
        }
        return sb.toString();
    }

}
