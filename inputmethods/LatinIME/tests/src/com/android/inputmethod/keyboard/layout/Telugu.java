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
 * The Telugu keyboard.
 */
public final class Telugu extends LayoutBase {
    private static final String LAYOUT_NAME = "telugu";

    public Telugu(final LayoutCustomizer customizer) {
        super(customizer, Symbols.class, SymbolsShifted.class);
    }

    @Override
    public String getName() { return LAYOUT_NAME; }

    public static class TeluguCustomizer extends LayoutCustomizer {
        public TeluguCustomizer(final Locale locale) { super(locale); }

        @Override
        public ExpectedKey getAlphabetKey() { return TELUGU_ALPHABET_KEY; }

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

        // U+0C05: "???" TELUGU LETTER A
        // U+0C06: "???" TELUGU LETTER AA
        // U+0C07: "???" TELUGU LETTER I
        private static final ExpectedKey TELUGU_ALPHABET_KEY = key(
                "\u0C05\u0C06\u0C07", Constants.CODE_SWITCH_ALPHA_SYMBOL);

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
                    // U+0C4C: "???" TELUGU VOWEL SIGN AU
                    // U+0C14: "???" TELUGU LETTER AU
                    key("\u0C4C", joinMoreKeys("\u0C14", "1")),
                    // U+0C48: "???" TELUGU VOWEL SIGN AI
                    // U+0C10: "???" TELUGU LETTER AI
                    key("\u0C48", joinMoreKeys("\u0C10", "2")),
                    // U+0C3E: "???" TELUGU VOWEL SIGN AA
                    // U+0C06: "???" TELUGU LETTER AA
                    key("\u0C3E", joinMoreKeys("\u0C06", "3")),
                    // U+0C40: "???" TELUGU VOWEL SIGN II
                    // U+0C08: "???" TELUGU LETTER II
                    key("\u0C40", joinMoreKeys("\u0C08", "4")),
                    // U+0C42: "???" TELUGU VOWEL SIGN UU
                    // U+0C0A: "???" TELUGU LETTER UU
                    key("\u0C42", joinMoreKeys("\u0C0A", "5")),
                    // U+0C2C: "???" TELUGU LETTER BA
                    // U+0C2D: "???" TELUGU LETTER BHA
                    key("\u0C2C", joinMoreKeys("\u0C2D", "6")),
                    // U+0C39: "???" TELUGU LETTER HA
                    // U+0C03: "???" TELUGU SIGN VISARGA
                    key("\u0C39", joinMoreKeys("\u0C03", "7")),
                    // U+0C17: "???" TELUGU LETTER GA
                    // U+0C18: "???" TELUGU LETTER GHA
                    key("\u0C17", joinMoreKeys("\u0C18", "8")),
                    // U+0C26: "???" TELUGU LETTER DA
                    // U+0C27: "???" TELUGU LETTER DHA
                    key("\u0C26", joinMoreKeys("\u0C27", "9")),
                    // U+0C1C: "???" TELUGU LETTER JA
                    // U+0C1D: "???" TELUGU LETTER JHA
                    key("\u0C1C", joinMoreKeys("\u0C1D", "0")),
                    // U+0C21: "???" TELUGU LETTER DDA
                    // U+0C22: "???" TELUGU LETTER DDHA
                    key("\u0C21", moreKey("\u0C22")))
            .setKeysOfRow(2,
                    // U+0C4B: "???" TELUGU VOWEL SIGN OO
                    // U+0C13: "???" TELUGU LETTER OO
                    key("\u0C4B", moreKey("\u0C13")),
                    // U+0C47: "???" TELUGU VOWEL SIGN EE
                    // U+0C0F: "???" TELUGU LETTER EE
                    key("\u0C47", moreKey("\u0C0F")),
                    // U+0C4D: "???" TELUGU SIGN VIRAMA
                    // U+0C05: "???" TELUGU LETTER A
                    key("\u0C4D", moreKey("\u0C05")),
                    // U+0C3F: "???" TELUGU VOWEL SIGN I
                    // U+0C07: "???" TELUGU LETTER I
                    key("\u0C3F", moreKey("\u0C07")),
                    // U+0C41: "???" TELUGU VOWEL SIGN U
                    // U+0C09: "???" TELUGU LETTER U
                    key("\u0C41", moreKey("\u0C09")),
                    // U+0C2A: "???" TELUGU LETTER PA
                    // U+0C2B: "???" TELUGU LETTER PHA
                    key("\u0C2A", moreKey("\u0C2B")),
                    // U+0C30: "???" TELUGU LETTER RA
                    // U+0C31: "???" TELUGU LETTER RRA
                    // U+0C43: "???" TELUGU VOWEL SIGN VOCALIC R
                    key("\u0C30", joinMoreKeys("\u0C31", "\u0C43")),
                    // U+0C15: "???" TELUGU LETTER KA
                    // U+0C16: "???" TELUGU LETTER KHA
                    key("\u0C15", moreKey("\u0C16")),
                    // U+0C24: "???" TELUGU LETTER TA
                    // U+0C25: "???" TELUGU LETTER THA
                    key("\u0C24", moreKey("\u0C25")),
                    // U+0C1A: "???" TELUGU LETTER CA
                    // U+0C1B: "???" TELUGU LETTER CHA
                    key("\u0C1A", moreKey("\u0C1B")),
                    // U+0C1F: "???" TELUGU LETTER TTA
                    // U+0C20: "???" TELUGU LETTER TTHA
                    key("\u0C1F", moreKey("\u0C20")))
            .setKeysOfRow(3,
                    // U+0C46: "???" TELUGU VOWEL SIGN E
                    // U+0C12: "???" TELUGU LETTER O
                    key("\u0C46", moreKey("\u0C12")),
                    // U+0C02: "???" TELUGU SIGN ANUSVARA
                    // U+0C0E: "???" TELUGU LETTER E
                    key("\u0C02", moreKey("\u0C0E")),
                    // U+0C2E: "???" TELUGU LETTER MA
                    "\u0C2E",
                    // U+0C28: "???" TELUGU LETTER NA
                    // U+0C23: "???" TELUGU LETTER NNA
                    // U+0C19: "???" TELUGU LETTER NGA
                    key("\u0C28", joinMoreKeys("\u0C23", "\u0C19")),
                    // U+0C35: "???" TELUGU LETTER VA
                    "\u0C35",
                    // U+0C32: "???" TELUGU LETTER LA
                    // U+0C33: "???" TELUGU LETTER LLA
                    key("\u0C32", moreKey("\u0C33")),
                    // U+0C38: "???" TELUGU LETTER SA
                    // U+0C36: "???" TELUGU LETTER SHA
                    key("\u0C38", moreKey("\u0C36")),
                    // U+0C0B: "???" TELUGU LETTER VOCALIC R
                    // U+0C4D/U+0C30: "??????" TELUGU SIGN VIRAMA/TELUGU LETTER RA
                    key("\u0C0B", moreKey("\u0C4D\u0C30")),
                    // U+0C37: "???" TELUGU LETTER SSA
                    // U+0C15/U+0C4D/U+0C37:
                    //     "?????????" TELUGU LETTER KA/TELUGU SIGN VIRAMA/TELUGU LETTER SSA
                    key("\u0C37", moreKey("\u0C15\u0C4D\u0C37")),
                    // U+0C2F: "???" TELUGU LETTER YA
                    // U+0C1C/U+0C4D/U+0C1E:
                    //     "?????????" TELUGU LETTER JA/TELUGU SIGN VIRAMA/TELUGU LETTER NYA
                    key("\u0C2F", moreKey("\u0C1C\u0C4D\u0C1E")))
            .build();
}
