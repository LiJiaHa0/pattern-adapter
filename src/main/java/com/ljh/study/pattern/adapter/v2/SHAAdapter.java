package com.ljh.study.pattern.adapter.v2;

import com.ljh.study.pattern.adapter.Encryption;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description: sha加密适配器具体实现
 * @author: Jh Lee
 * @create: 2019-03-18 20:49
 **/
public class SHAAdapter extends Encryption implements ExpandEncryption {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof SHAAdapter;
    }

    @Override
    public String encryption(String str) {
        BigInteger shaStr = null;
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA");
            sha.reset();
            sha.update(str.getBytes("utf-8"));
            shaStr = new BigInteger(sha.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return shaStr.toString(32);
    }
}
