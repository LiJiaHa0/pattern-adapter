package com.ljh.study.pattern.adapter.v2;

import java.security.MessageDigest;

/**
 * @description: SHA1加密适配器具体加密实现
 * @author: Jh Lee
 * @create: 2019-03-18 20:58
 **/
public class SHA1Adapter implements ExpandEncryption {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof SHA1Adapter;
    }

    @Override
    public String encryption(String str) {
        if(str==null||str.length()==0){
            return null;
        }
        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9',
                'a','b','c','d','e','f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j*2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }
}
