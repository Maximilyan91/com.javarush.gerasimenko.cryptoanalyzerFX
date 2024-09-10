package com.max.cryptoanalyzerfx.service;


import com.max.cryptoanalyzerfx.model.Languages;

public interface Cryptographer {

    String encrypt(Languages lang, String text, int shift);

    String decrypt(Languages lang, String text, int shift);
}
