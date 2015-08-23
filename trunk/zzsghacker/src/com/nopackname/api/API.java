package com.nopackname.api;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import com.nopackname.tools.HttpResult;

public class API {
    // constant
    public static final String ACTION = "action";
    public static final String PAGE = "page";
    public static final String ID = "id";
    public static final String CITY = "city";
    public static final String MODE = "mode";
    public static final String TYPE = "type";
    public static final String NUM = "num";
    // hidden
    public static long startUpTime = System.currentTimeMillis();
    // symbol
    public static final String AND = "&";
    public static final String EQUAL = "=";

    // http stuff
    public static final String HOST_PRE = "http://m.zzsanguo.com";
    public static final String HOST_MAIN = "http://s6.zzsanguo.com";
    //
    public static final String JSONPCALLBACK = "jsonpcallback";
    /**
     * i guess it records the start time of a command
     */
    public static final String JSONP = "jsonp";
    /**
     * i guess it records the end time of a command
     */
    public static final String _ = "_";
    public static final String KEY = "key";
    public static final String _L = "_l";
    public static final String _L_DEFAULT_CHS = "chs";
    public static final String _L_DEFAULT_EN = "en";
    public static final String _P = "_p";
    public static final String _P_DEFAULT_ANDROID = "ZZ-DROID-CHS-TTGW";
    public static final String _P_DEFAULT_IPHONE = "ZZ-IPHONE-CHS";

    //

    String path;
    String jsonpcallback;
    long tag_;
    String key;

    //
    int city;

    //
    String _l = _L_DEFAULT_CHS;
    String _p = _P_DEFAULT_ANDROID;

    public API() {
        super();
        // generate jsonpcallback
        this.jsonpcallback = generateJSONPCallback();
        this.tag_ = System.currentTimeMillis();
        this.key = generateKey();
    }

    public static ResponseHandler<String> generateAccLgoinResponseHandler(
            final HttpResult httpResult) {
        // Create a custom response handler
        return new ResponseHandler<String>() {

            public String handleResponse(final HttpResponse response)
                    throws ClientProtocolException, IOException {
                int status = response.getStatusLine().getStatusCode();
                httpResult.setStatus(String.valueOf(status));
                String result = EntityUtils.toString(response.getEntity());
                System.out.println("[RESPONSE]: " + result);
                httpResult.setResponse(result);

                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? result : null;
                } else {
                    throw new ClientProtocolException(
                            "Unexpected response status: " + status);
                }
            }

        };
    }

    private static int commandCount = 0;

    private String generateJSONPCallback() {
        return JSONPCALLBACK + startUpTime + commandCount++;
    }

    private String generateKey() {
        return "740e978717d64de3a6476c90ff2695cd";
    }
}
