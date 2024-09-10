package com.max.cryptoanalyzerfx.service;


import com.max.cryptoanalyzerfx.model.Languages;

public interface Validator {

    boolean isValidKey(Languages lang, int key);
}
