package com.max.cryptoanalyzerfx.util;


import com.max.cryptoanalyzerfx.model.Languages;
import com.max.cryptoanalyzerfx.service.Validator;
import com.max.cryptoanalyzerfx.service.impl.ValidatorImpl;

import java.util.HashMap;
import java.util.Map;

public class CryptoUtils {

    private static final Validator validator = new ValidatorImpl();

    /**
     * Adjusts the array shift if the key value is greater
     * the number of all symbols in the language.
     */

    public static int keyCorrect(Languages lang, int value) {
        int symbolsCapacity = lang.getSymbolsCapacity();

        if (validator.isValidKey(lang, value)) {
            if (value < -symbolsCapacity) {
                value %= -symbolsCapacity;
            }

            if (value > symbolsCapacity) {
                value %= symbolsCapacity;
            }
        }
        return value;
    }

    /*
     * Логику метода getEncryptMap решил реализовать самостоятельно,
     * без использования утилитарных методов типа Arrays.copyOf()
     * а также Collections.rotate()
     */

    public static Map<Character, Character> getEncryptMap(Languages lang, int shift) {
        char[] symbols = lang.getAllSymbols();
        Map<Character, Character> encryptMap = new HashMap<>();

        if (shift < 0) {
            shift += symbols.length;
        }

        for (int i = 0; i < symbols.length; i++) {
            int shiftedIndex = i + shift;

            if (shiftedIndex < symbols.length) {
                encryptMap.put(symbols[i], symbols[shiftedIndex]);
            } else {
                encryptMap.put(symbols[i], symbols[shiftedIndex - symbols.length]);
            }
        }
        return encryptMap;
    }
}
