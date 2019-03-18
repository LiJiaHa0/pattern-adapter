package com.ljh.study.pattern.adapter.v2;

/**
 * @description: 扩展加密
 * @author: Jh Lee
 * @create: 2019-03-18 20:44
 **/
public interface ExpandEncryptionWay {

    public String SHA(String str);

    public String SHA1(String str);

    public String SHA256(String str);
}
