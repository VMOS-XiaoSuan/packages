/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.inputmethod.keyboard.layout;

import com.android.inputmethod.keyboard.layout.Symbols.RtlSymbols;
import com.android.inputmethod.keyboard.layout.SymbolsShifted.RtlSymbolsShifted;
import com.android.inputmethod.keyboard.layout.expected.ExpectedKey;
import com.android.inputmethod.keyboard.layout.expected.ExpectedKeyboardBuilder;
import com.android.inputmethod.latin.Constants;

import java.util.Locale;

public final class Hebrew extends LayoutBase {
    private static final String LAYOUT_NAME = "hebrew";

    public Hebrew(final LayoutCustomizer customizer) {
        super(customizer, HebrewSymbols.class, RtlSymbolsShifted.class);
    }

    @Override
    public String getName() { return LAYOUT_NAME; }

    public static class HebrewCustomizer extends LayoutCustomizer {
        public HebrewCustomizer(final Locale locale) {
            super(locale);
        }

        @Override
        public ExpectedKey getAlphabetKey() { return HEBREW_ALPHABET_KEY; }

        @Override
        public ExpectedKey getCurrencyKey() { return CURRENCY_NEW_SHEQEL; }

        @Override
        public ExpectedKey[] getOtherCurrencyKeys() {
            return SymbolsShifted.CURRENCIES_OTHER_GENERIC;
        }

        @Override
        public ExpectedKey[] getDoubleQuoteMoreKeys() { return Symbols.DOUBLE_QUOTES_LR9; }

        @Override
        public ExpectedKey[] getSingleQuoteMoreKeys() { return Symbols.SINGLE_QUOTES_LR9; }

        @Override
        public ExpectedKey[] getDoubleAngleQuoteKeys() {
            return RtlSymbols.DOUBLE_ANGLE_QUOTES_LR_RTL;
        }

        @Override
        public ExpectedKey[] getSingleAngleQuoteKeys() {
            return RtlSymbols.SINGLE_ANGLE_QUOTES_LR_RTL;
        }

        @Override
        public ExpectedKey[] getLeftShiftKeys(final boolean isPhone) {
            return EMPTY_KEYS;
        }

        @Override
        public ExpectedKey[] getRightShiftKeys(final boolean isPhone) {
            return isPhone ? EMPTY_KEYS : EXCLAMATION_AND_QUESTION_MARKS;
        }

        @Override
        public ExpectedKey[] getPunctuationMoreKeys(final boolean isPhone) {
            return isPhone ? RTL_PHONE_PUNCTUATION_MORE_KEYS
                    : RTL_TABLET_PUNCTUATION_MORE_KEYS;
        }

        // U+05D0: "??" HEBREW LETTER ALEF
        // U+05D1: "??" HEBREW LETTER BET
        // U+05D2: "??" HEBREW LETTER GIMEL
        private static final ExpectedKey HEBREW_ALPHABET_KEY = key(
                "\u05D0\u05D1\u05D2", Constants.CODE_SWITCH_ALPHA_SYMBOL);
        // U+20AA: "???" NEW SHEQEL SIGN
        private static final ExpectedKey CURRENCY_NEW_SHEQEL = key("\u20AA",
                Symbols.CURRENCY_GENERIC_MORE_KEYS);
        private static final ExpectedKey[] RTL_PHONE_PUNCTUATION_MORE_KEYS = joinKeys(
                ",", "?", "!", "#", key(")", "("), key("(", ")"), "/", ";",
                "'", "@", ":", "-", "\"", "+", "%", "&");
        // Punctuation more keys for tablet form factor.
        private static final ExpectedKey[] RTL_TABLET_PUNCTUATION_MORE_KEYS = joinKeys(
                ",", "'", "#", key(")", "("), key("(", ")"), "/", ";",
                "@", ":", "-", "\"", "+", "%", "&");
    }

    @Override
    ExpectedKey[][] getCommonAlphabetLayout(final boolean isPhone) { return ALPHABET_COMMON; }

    @Override
    ExpectedKey[][] getCommonAlphabetShiftLayout(final boolean isPhone, final int elementId) {
        return null;
    }

    private static final ExpectedKey[][] ALPHABET_COMMON = new ExpectedKeyboardBuilder()
            .setKeysOfRow(1,
                    key("'", joinMoreKeys("1", "\"")),
                    key("-", joinMoreKeys("2", "_")),
                    // U+05E7: "??" HEBREW LETTER QOF
                    key("\u05E7", moreKey("3")),
                    // U+05E8: "??" HEBREW LETTER RESH
                    key("\u05E8", moreKey("4")),
                    // U+05D0: "??" HEBREW LETTER ALEF
                    key("\u05D0", moreKey("5")),
                    // U+05D8: "??" HEBREW LETTER TET
                    key("\u05D8", moreKey("6")),
                    // U+05D5: "??" HEBREW LETTER VAV
                    key("\u05D5", moreKey("7")),
                    // U+05DF: "??" HEBREW LETTER FINAL NUN
                    key("\u05DF", moreKey("8")),
                    // U+05DD: "??" HEBREW LETTER FINAL MEM
                    key("\u05DD", moreKey("9")),
                    // U+05E4: "??" HEBREW LETTER PE
                    key("\u05E4", moreKey("0")))
            .setKeysOfRow(2,
                    // U+05E9: "??" HEBREW LETTER SHIN
                    // U+05D3: "??" HEBREW LETTER DALET
                    "\u05E9", "\u05D3",
                    // U+05D2: "??" HEBREW LETTER GIMEL
                    // U+05D2 U+05F3: "????" HEBREW LETTER GIMEL + HEBREW PUNCTUATION GERESH
                    key("\u05D2", moreKey("\u05D2\u05F3")),
                    // U+05DB: "??" HEBREW LETTER KAF
                    // U+05E2: "??" HEBREW LETTER AYIN
                    "\u05DB", "\u05E2",
                    // U+05D9: "??" HEBREW LETTER YOD
                    // U+05F2 U+05B7: "????" HEBREW LIGATURE YIDDISH DOUBLE YOD + HEBREW POINT PATAH
                    key("\u05D9", moreKey("\u05F2\u05B7")),
                    // U+05D7: "??" HEBREW LETTER HET
                    // U+05D7 U+05F3: "????" HEBREW LETTER HET + HEBREW PUNCTUATION GERESH
                    key("\u05D7", moreKey("\u05D7\u05F3")),
                    // U+05DC: "??" HEBREW LETTER LAMED
                    // U+05DA: "??" HEBREW LETTER FINAL KAF
                    // U+05E3: "??" HEBREW LETTER FINAL PE
                    "\u05DC", "\u05DA", "\u05E3")
            .setKeysOfRow(3,
                    // U+05D6: "??" HEBREW LETTER ZAYIN
                    // U+05D6 U+05F3: "????" HEBREW LETTER ZAYIN + HEBREW PUNCTUATION GERESH
                    key("\u05D6", moreKey("\u05D6\u05F3")),
                    // U+05E1: "??" HEBREW LETTER SAMEKH
                    // U+05D1: "??" HEBREW LETTER BET
                    // U+05D4: "??" HEBREW LETTER HE
                    // U+05E0: "??" HEBREW LETTER NUN
                    // U+05DE: "??" HEBREW LETTER MEM
                    "\u05E1", "\u05D1", "\u05D4", "\u05E0", "\u05DE",
                    // U+05E6: "??" HEBREW LETTER TSADI
                    // U+05E6 U+05F3: "????" HEBREW LETTER TSADI + HEBREW PUNCTUATION GERESH
                    key("\u05E6", moreKey("\u05E6\u05F3")),
                    // U+05EA: "??" HEBREW LETTER TAV
                    // U+05EA U+05F3: "????" HEBREW LETTER TAV + HEBREW PUNCTUATION GERESH
                    key("\u05EA", moreKey("\u05EA\u05F3")),
                    // U+05E5: "??" HEBREW LETTER FINAL TSADI
                    // U+05E5 U+05F3: "????" HEBREW LETTER FINAL TSADI + HEBREW PUNCTUATION GERESH
                    key("\u05E5", moreKey("\u05E5\u05F3")))
            .build();

    private static class HebrewSymbols extends RtlSymbols {
        public HebrewSymbols(final LayoutCustomizer customizer) {
            super(customizer);
        }

        @Override
        public ExpectedKey[][] getLayout(final boolean isPhone) {
            return new ExpectedKeyboardBuilder(super.getLayout(isPhone))
                    // U+00B1: "??" PLUS-MINUS SIGN
                    // U+FB29: "???" HEBREW LETTER ALTERNATIVE PLUS SIGN
                    .setMoreKeysOf("+", "\u00B1", "\uFB29")
                    // U+2605: "???" BLACK STAR
                    .setMoreKeysOf("*", "\u2605")
                    .build();
        }
    }
}
