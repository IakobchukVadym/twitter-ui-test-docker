package com.qa.twitter.utils;

import org.jasypt.util.text.BasicTextEncryptor;

public final class Decryptor {

    private Decryptor() {
    }

    public static String decrypt(String encryptedPassword) {
        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
        basicTextEncryptor.setPassword(System.getProperty("security.password"));
        return basicTextEncryptor.decrypt(encryptedPassword);
    }
}