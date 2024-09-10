package com.max.cryptoanalyzerfx.service.impl;


import com.max.cryptoanalyzerfx.model.Languages;
import com.max.cryptoanalyzerfx.service.Cryptographer;
import com.max.cryptoanalyzerfx.service.Validator;
import com.max.cryptoanalyzerfx.util.CryptoUtils;

import java.util.Arrays;
import java.util.Map;

public class CryptographerImpl implements Cryptographer {

    private static final Validator validator = new ValidatorImpl();


    @Override
    public String encrypt(Languages lang, String text, int shift) {
        shift = CryptoUtils.keyCorrect(lang, shift);
        char[] textArr = text.toCharArray();
        char[] encryptedArr = new char[textArr.length];
        Map<Character, Character> encryptionMap = CryptoUtils.getEncryptMap(lang, shift);

        for (int i = 0; i < textArr.length; i++) {
            encryptedArr[i] = encryptionMap.getOrDefault(textArr[i], '`');
        }
        return Arrays.toString(encryptedArr);
    }

    @Override
    public String decrypt(Languages lang, String text, int shift) {
        return encrypt(lang, text, -shift);
    }
}
