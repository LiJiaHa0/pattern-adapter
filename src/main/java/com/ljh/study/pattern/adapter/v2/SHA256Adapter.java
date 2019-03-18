package com.ljh.study.pattern.adapter.v2;

import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description: sha256加密具体实现
 * @author: Jh Lee
 * @create: 2019-03-18 21:00
 **/
public class SHA256Adapter implements ExpandEncryption {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof  SHA256Adapter;
    }

    @Override
    public String encryption(String str) {
        MessageDigest messageDigest;
        String encdeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(str.getBytes("UTF-8"));
            encdeStr = Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encdeStr;
    }
}
