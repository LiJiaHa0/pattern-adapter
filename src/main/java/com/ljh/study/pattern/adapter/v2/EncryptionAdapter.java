package com.ljh.study.pattern.adapter.v2;

import com.ljh.study.pattern.adapter.Encryption;

/**
 * @description: 加密方式适配器
 * @author: Jh Lee
 * @create: 2019-03-18 21:02
 **/
public class EncryptionAdapter extends Encryption implements ExpandEncryptionWay {

    @Override
    public String SHA(String str) {
        return doingEncryption(str,SHAAdapter.class);
    }

    @Override
    public String SHA1(String str) {
        return doingEncryption(str,SHA1Adapter.class);
    }

    @Override
    public String SHA256(String str) {
        return doingEncryption(str,SHA256Adapter.class);
    }

    public String doingEncryption(String str,Class<? extends ExpandEncryption> clazz){
        try {
            ExpandEncryption adapter = clazz.newInstance();
            if(adapter.support(adapter)){
                return adapter.encryption(str);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
