package com.ljh.study.pattern.adapter.v2;

/**
 * @description: 适配器模式测试
 * @author: Jh Lee
 * @create: 2019-03-18 21:10
 **/
public class AdapterTest {

    public static void main(String[] args) {
        EncryptionAdapter encryptionAdapter = new EncryptionAdapter();
        String sha = encryptionAdapter.MD5("11122");
        System.out.println(sha);
    }
}
