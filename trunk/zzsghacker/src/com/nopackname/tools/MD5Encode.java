package com.nopackname.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encode {

    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
            "e", "f" };

    public MD5Encode() {
    }

    private static MessageDigest md = null;

    private static MessageDigest getDigest() {
        if (null == md) {
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return md;
    }

    public static String update(String pwd) {
        if (pwd == null) {
            return "";
        }
        MessageDigest md = getDigest();
        md.update(pwd.getBytes());
        return byteArrayToHexString(md.digest());
    }

    public static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static void main(String[] args) {
        String s0 = "jsonp1410599368611";
        System.out.println(MD5Encode.update(s0));
    }
}
