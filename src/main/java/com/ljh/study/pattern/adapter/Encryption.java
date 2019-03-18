package com.ljh.study.pattern.adapter;

import org.apache.commons.codec.digest.DigestUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;

/**
 * @description: 加密数据参数实现
 * @author: Jh Lee
 * @create: 2019-03-18 20:15
 **/
public class Encryption {


    public  String MD5(String str) {
        return DigestUtils.md5Hex(str);
    }

    public String Base64Encoder(String str) {
        byte[] b = null;
        String s = null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = new BASE64Encoder().encode(b);
        }
        return s;
    }

    public String base64Decoder(String str) {
        byte[] b = null;
        String result = null;
        if (str != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(str);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
