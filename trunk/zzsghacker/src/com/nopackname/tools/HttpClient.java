package com.nopackname.tools;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClient {
    public final static void main(String[] args) throws Exception {

    }

    /**
     * http GET
     * 
     * @param uri
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static HttpResult httpGet(String uri, Map<String, String> headers, final HttpResult httpResult,
            ResponseHandler<String> responseHandler) throws ClientProtocolException, IOException {

        String status = "";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(uri);
            System.out.println(httpget.getMethod() + " " + httpget.getURI());
            for (Entry<String, String> entry : headers.entrySet()) {
                httpget.addHeader(entry.getKey(), entry.getValue());
            }
            // long start = System.currentTimeMillis();
            status = httpclient.execute(httpget, responseHandler);
            // System.out.println("[HttpClient] - GET " + uri + " response: " +
            // status);
            // System.out.println("INNER COST: " + (System.currentTimeMillis() -
            // start));
            httpResult.setStatus(status);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpclient.close();
        }
        return httpResult;
    }

}
