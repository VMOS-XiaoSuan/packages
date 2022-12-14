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

import com.android.inputmethod.keyboard.layout.expected.ExpectedKey;
import com.android.inputmethod.keyboard.layout.expected.ExpectedKeyboardBuilder;
import com.android.inputmethod.latin.Constants;

import java.util.Locale;

/**
 * The Kannada keyboard.
 */
public final class Kannada extends LayoutBase {
    private static final String LAYOUT_NAME = "kannada";

    public Kannada(final LayoutCustomizer customizer) {
        super(customizer, Symbols.class, SymbolsShifted.class);
    }

    @Override
    public String getName() { return LAYOUT_NAME; }

    public static class KannadaCustomizer extends LayoutCustomizer {
        public KannadaCustomizer(final Locale locale) { super(locale); }

        @Override
        public ExpectedKey getAlphabetKey() { return KANNADA_ALPHABET_KEY; }

        @Override
        public ExpectedKey getCurrencyKey() { return CURRENCY_RUPEE; }

        @Override
        public ExpectedKey[] getOtherCurrencyKeys() {
            return SymbolsShifted.CURRENCIES_OTHER_GENERIC;
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
        public ExpectedKey[] getSpaceKeys(final boolean isPhone) {
            return joinKeys(LANGUAGE_SWITCH_KEY, SPACE_KEY, key(ZWNJ_KEY, ZWJ_KEY));
        }

        // U+0C85: "???" KANNADA LETTER A
        // U+0C86: "???" KANNADA LETTER AA
        // U+0C87: "???" KANNADA LETTER I
        private static final ExpectedKey KANNADA_ALPHABET_KEY = key(
                "\u0C85\u0C86\u0C87", Constants.CODE_SWITCH_ALPHA_SYMBOL);

        // U+20B9: "???" INDIAN RUPEE SIGN
        private static final ExpectedKey CURRENCY_RUPEE = key("\u20B9",
                Symbols.CURRENCY_GENERIC_MORE_KEYS);
    }

    @Override
    ExpectedKey[][] getCommonAlphabetLayout(boolean isPhone) { return ALPHABET_COMMON; }

    @Override
    ExpectedKey[][] getCommonAlphabetShiftLayout(boolean isPhone, final int elementId) {
        return null;
    }

    private static final ExpectedKey[][] ALPHABET_COMMON = new ExpectedKeyboardBuilder()
            .setKeysOfRow(1,
                    // U+0CCC: "???" KANNADA VOWEL SIGN AU
                    // U+0C94: "???" KANNADA LETTER AU
                    // U+0CE7: "???" KANNADA DIGIT ONE
                    key("\u0CCC", joinMoreKeys("\u0C94", "\u0CE7", "1")),
                    // U+0CC8: "???" KANNADA VOWEL SIGN AI
                    // U+0C90: "???" KANNADA LETTER AI
                    // U+0CE8: "???" KANNADA DIGIT TWO
                    key("\u0CC8", joinMoreKeys("\u0C90", "\u0CE8", "2")),
                    // U+0CBE: "???" KANNADA VOWEL SIGN AA
                    // U+0C86: "???" KANNADA LETTER AA
                    // U+0CE9: "???" KANNADA DIGIT THREE
                    key("\u0CBE", joinMoreKeys("\u0C86", "\u0CE9", "3")),
                    // U+0CC0: "???" KANNADA VOWEL SIGN II
                    // U+0C88: "???" KANNADA LETTER II
                    // U+0CEA: "???" KANNADA DIGIT FOUR
                    key("\u0CC0", joinMoreKeys("\u0C88", "\u0CEA", "4")),
                    // U+0CC2: "???" KANNADA VOWEL SIGN UU
                    // U+0C8A: "???" KANNADA LETTER UU
                    // U+0CEB: "???" KANNADA DIGIT FIVE
                    key("\u0CC2", joinMoreKeys("\u0C8A", "\u0CEB", "5")),
                    // U+0CAC: "???" KANNADA LETTER BA
                    // U+0CAD: "???" KANNADA LETTER BHA
                    // U+0CEC: "???" KANNADA DIGIT SIX
                    key("\u0CAC", joinMoreKeys("\u0CAD", "\u0CEC", "6")),
                    // U+0CB9: "???" KANNADA LETTER HA
                    // U+0C99: "???" KANNADA LETTER NGA
                    // U+0CED: "???" KANNADA DIGIT SEVEN
                    key("\u0CB9", joinMoreKeys("\u0C99", "\u0CED", "7")),
                    // U+0C97: "???" KANNADA LETTER GA
                    // U+0C98: "???" KANNADA LETTER GHA
                    // U+0CEE: "???" KANNADA DIGIT EIGHT
                    key("\u0C97", joinMoreKeys("\u0C98", "\u0CEE", "8")),
                    // U+0CA6: "???" KANNADA LETTER DA
                    // U+0CA7: "???" KANNADA LETTER DHA
                    // U+0CEF: "???" KANNADA DIGIT NINE
                    key("\u0CA6", joinMoreKeys("\u0CA7", "\u0CEF", "9")),
                    // U+0C9C: "???" KANNADA LETTER JA
                    // U+0C9D: "???" KANNADA LETTER JHA
                    // U+0CE6: "???" KANNADA DIGIT ZERO
                    key("\u0C9C", joinMoreKeys("\u0C9D", "\u0CE6", "0")),
                    // U+0CA1: "???" KANNADA LETTER DDA
                    // U+0CA2: "???" KANNADA LETTER DDHA
                    key("\u0CA1", moreKey("\u0CA2")))
            .setKeysOfRow(2,
                    // U+0CCB: "???" KANNADA VOWEL SIGN OO
                    // U+0C93: "???" KANNADA LETTER OO
                    key("\u0CCB", moreKey("\u0C93")),
                    // U+0CC7: "???" KANNADA VOWEL SIGN EE
                    // U+0C8F: "???" KANNADA LETTER EE
                    key("\u0CC7", moreKey("\u0C8F")),
                    // U+0CCD: "???" KANNADA SIGN VIRAMA
                    // U+0C85: "???" KANNADA LETTER A
                    key("\u0CCD", moreKey("\u0C85")),
                    // U+0CBF: "???" KANNADA VOWEL SIGN I
                    // U+0C87: "???" KANNADA LETTER I
                    key("\u0CBF", moreKey("\u0C87")),
                    // U+0CC1: "???" KANNADA VOWEL SIGN U
                    // U+0C89: "???" KANNADA LETTER U
                    key("\u0CC1", moreKey("\u0C89")),
                    // U+0CAA: "???" KANNADA LETTER PA
                    // U+0CAB: "???" KANNADA LETTER PHA
                    key("\u0CAA", moreKey("\u0CAB")),
                    // U+0CB0: "???" KANNADA LETTER RA
                    // U+0CB1: "???" KANNADA LETTER RRA
                    // U+0CC3: "???" KANNADA VOWEL SIGN VOCALIC R
                    key("\u0CB0", joinMoreKeys("\u0CB1", "\u0CC3")),
                    // U+0C95: "???" KANNADA LETTER KA
                    // U+0C96: "???" KANNADA LETTER KHA
                    key("\u0C95", moreKey("\u0C96")),
                    // U+0CA4: "???" KANNADA LETTER TA
                    // U+0CA5: "???" KANNADA LETTER THA
                    key("\u0CA4", moreKey("\u0CA5")),
                    // U+0C9A: "???" KANNADA LETTER CA
                    // U+0C9B: "???" KANNADA LETTER CHA
                    key("\u0C9A", moreKey("\u0C9B")),
                    // U+0C9F: "???" KANNADA LETTER TTA
                    // U+0CA0: "???" KANNADA LETTER TTHA
                    key("\u0C9F", moreKey("\u0CA0")))
            .setKeysOfRow(3,
                    // U+0CC6: "???" KANNADA VOWEL SIGN E
                    // U+0C92: "???" KANNADA LETTER O
                    key("\u0CC6", moreKey("\u0C92")),
                    // U+0C82: "???" KANNADA SIGN ANUSVARA
                    // U+0C8E: "???" KANNADA LETTER E
                    key("\u0C82", moreKey("\u0C8E")),
                    // U+0CAE: "???" KANNADA LETTER MA
                    "\u0CAE",
                    // U+0CA8: "???" KANNADA LETTER NA
                    // U+0CA3: "???" KANNADA LETTER NNA
                    key("\u0CA8", moreKey("\u0CA3")),
                    // U+0CB5: "???" KANNADA LETTER VA
                    "\u0CB5",
                    // U+0CB2: "???" KANNADA LETTER LA
                    // U+0CB3: "???" KANNADA LETTER LLA
                    key("\u0CB2", moreKey("\u0CB3")),
                    // U+0CB8: "???" KANNADA LETTER SA
                    // U+0CB6: "???" KANNADA LETTER SHA
                    key("\u0CB8", moreKey("\u0CB6")),
                    // U+0C8B: "???" KANNADA LETTER VOCALIC R
                    // U+0CCD/U+0CB0: "??????" KANNADA SIGN VIRAMA/KANNADA LETTER RA
                    key("\u0C8B", moreKey("\u0CCD\u0CB0")),
                    // U+0CB7: "???" KANNADA LETTER SSA
                    // U+0C95/U+0CCD/U+0CB7:
                    //     "?????????" KANNADA LETTER RA/KANNADA SIGN VIRAMA/KANNADA LETTER SSA
                    key("\u0CB7", moreKey("\u0C95\u0CCD\u0CB7")),
                    // U+0CAF: "???" KANNADA LETTER YA
                    // U+0C9C/U+0CCD/U+0C9E:
                    //     "?????????" KANNADA LETTER JA/KANNADA SIGN VIRAMA/KANNADA LETTER NYA
                    key("\u0CAF", moreKey("\u0C9C\u0CCD\u0C9E")))
            .build();
}
