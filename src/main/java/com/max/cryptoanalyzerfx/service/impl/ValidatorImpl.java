package com.max.cryptoanalyzerfx.service.impl;


import com.max.cryptoanalyzerfx.exception.ZeroKeyException;
import com.max.cryptoanalyzerfx.model.Languages;
import com.max.cryptoanalyzerfx.service.Validator;

public class ValidatorImpl implements Validator {

    @Override
    public boolean isValidKey(Languages lang, int key) {
        if (Math.abs(key) % lang.getSymbolsCapacity() == 0) {
            throw new ZeroKeyException("the shift is zero or the number of characters in the language");
        } else {
            return true;
        }
    }
}
