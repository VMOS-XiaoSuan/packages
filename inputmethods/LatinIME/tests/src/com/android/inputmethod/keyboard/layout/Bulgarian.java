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

import com.android.inputmethod.keyboard.layout.EastSlavic.EastSlavicCustomizer;
import com.android.inputmethod.keyboard.layout.expected.ExpectedKey;
import com.android.inputmethod.keyboard.layout.expected.ExpectedKeyboardBuilder;

import java.util.Locale;

public final class Bulgarian extends LayoutBase {
    private static final String LAYOUT_NAME = "bulgarian";

    public Bulgarian(final LayoutCustomizer customizer) {
        super(customizer, Symbols.class, SymbolsShifted.class);
    }

    @Override
    public String getName() { return LAYOUT_NAME; }

    public static class BulgarianCustomizer extends LayoutCustomizer {
        private final EastSlavicCustomizer mEastSlavicCustomizer;

        public BulgarianCustomizer(final Locale locale) {
            super(locale);
            mEastSlavicCustomizer = new EastSlavicCustomizer(locale);
        }

        @Override
        public ExpectedKey getAlphabetKey() {
            return mEastSlavicCustomizer.getAlphabetKey();
        }

        @Override
        public ExpectedKey[] getDoubleQuoteMoreKeys() { return Symbols.DOUBLE_QUOTES_R9L; }
    }

    @Override
    ExpectedKey[][] getCommonAlphabetLayout(final boolean isPhone) { return ALPHABET_COMMON; }

    private static final ExpectedKey[][] ALPHABET_COMMON = new ExpectedKeyboardBuilder()
            .setKeysOfRow(1,
                    // U+044F: "??" CYRILLIC SMALL LETTER YA
                    key("\u044F", moreKey("1")),
                    // U+0432: "??" CYRILLIC SMALL LETTER VE
                    key("\u0432", moreKey("2")),
                    // U+0435: "??" CYRILLIC SMALL LETTER IE
                    key("\u0435", moreKey("3")),
                    // U+0440: "??" CYRILLIC SMALL LETTER ER
                    key("\u0440", moreKey("4")),
                    // U+0442: "??" CYRILLIC SMALL LETTER TE
                    key("\u0442", moreKey("5")),
                    // U+044A: "??" CYRILLIC SMALL LETTER HARD SIGN
                    key("\u044A", moreKey("6")),
                    // U+0443: "??" CYRILLIC SMALL LETTER U
                    key("\u0443", moreKey("7")),
                    // U+0438: "??" CYRILLIC SMALL LETTER I
                    // U+045D: "??" CYRILLIC SMALL LETTER I WITH GRAVE
                    key("\u0438", joinMoreKeys("8", "\u045D")),
                    // U+043E: "??" CYRILLIC SMALL LETTER O
                    key("\u043E", moreKey("9")),
                    // U+043F: "??" CYRILLIC SMALL LETTER PE
                    key("\u043F", moreKey("0")),
                    // U+0447: "??" CYRILLIC SMALL LETTER CHE
                    "\u0447")
            .setKeysOfRow(2,
                    // U+0430: "??" CYRILLIC SMALL LETTER A
                    // U+0441: "??" CYRILLIC SMALL LETTER ES
                    // U+0434: "??" CYRILLIC SMALL LETTER DE
                    // U+0444: "??" CYRILLIC SMALL LETTER EF
                    // U+0433: "??" CYRILLIC SMALL LETTER GHE
                    // U+0445: "??" CYRILLIC SMALL LETTER HA
                    // U+0439: "??" CYRILLIC SMALL LETTER SHORT I
                    // U+043A: "??" CYRILLIC SMALL LETTER KA
                    // U+043B: "??" CYRILLIC SMALL LETTER EL
                    // U+0448: "??" CYRILLIC SMALL LETTER SHA
                    // U+0449: "??" CYRILLIC SMALL LETTER SHCHA
                    "\u0430", "\u0441", "\u0434", "\u0444", "\u0433", "\u0445", "\u0439", "\u043A",
                    "\u043B", "\u0448", "\u0449")
            .setKeysOfRow(3,
                    // U+0437: "??" CYRILLIC SMALL LETTER ZE
                    // U+044C: "??" CYRILLIC SMALL LETTER SOFT SIGN
                    // U+0446: "??" CYRILLIC SMALL LETTER TSE
                    // U+0436: "??" CYRILLIC SMALL LETTER ZHE
                    // U+0431: "??" CYRILLIC SMALL LETTER BE
                    // U+043D: "??" CYRILLIC SMALL LETTER EN
                    // U+043C: "??" CYRILLIC SMALL LETTER EM
                    // U+044E: "??" CYRILLIC SMALL LETTER YU
                    "\u0437", "\u044C", "\u0446", "\u0436", "\u0431", "\u043D", "\u043C", "\u044E")
            .build();
}
