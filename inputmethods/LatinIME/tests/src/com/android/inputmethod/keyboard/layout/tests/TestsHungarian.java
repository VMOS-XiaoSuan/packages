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

package com.android.inputmethod.keyboard.layout.tests;

import android.test.suitebuilder.annotation.SmallTest;

import com.android.inputmethod.keyboard.layout.LayoutBase;
import com.android.inputmethod.keyboard.layout.LayoutBase.LayoutCustomizer;
import com.android.inputmethod.keyboard.layout.Qwertz;
import com.android.inputmethod.keyboard.layout.Symbols;
import com.android.inputmethod.keyboard.layout.expected.ExpectedKey;
import com.android.inputmethod.keyboard.layout.expected.ExpectedKeyboardBuilder;

import java.util.Locale;

/**
 * hu: Hungarian/qwertz
 */
@SmallTest
public final class TestsHungarian extends LayoutTestsBase {
    private static final Locale LOCALE = new Locale("hu");
    private static final LayoutBase LAYOUT = new Qwertz(new HungarianCustomizer(LOCALE));

    @Override
    LayoutBase getLayout() { return LAYOUT; }

    private static class HungarianCustomizer extends LayoutCustomizer {
        public HungarianCustomizer(final Locale locale) { super(locale); }

        @Override
        public ExpectedKey[] getDoubleQuoteMoreKeys() { return Symbols.DOUBLE_QUOTES_L9R; }

        @Override
        public ExpectedKey[] getSingleQuoteMoreKeys() { return Symbols.SINGLE_QUOTES_L9R; }

        @Override
        public ExpectedKey[] getDoubleAngleQuoteKeys() { return Symbols.DOUBLE_ANGLE_QUOTES_RL; }

        @Override
        public ExpectedKey[] getSingleAngleQuoteKeys() { return Symbols.SINGLE_ANGLE_QUOTES_RL; }

        @Override
        public ExpectedKeyboardBuilder setAccentedLetters(final ExpectedKeyboardBuilder builder) {
            return builder
                    // U+00E9: "??" LATIN SMALL LETTER E WITH ACUTE
                    // U+00E8: "??" LATIN SMALL LETTER E WITH GRAVE
                    // U+00EA: "??" LATIN SMALL LETTER E WITH CIRCUMFLEX
                    // U+00EB: "??" LATIN SMALL LETTER E WITH DIAERESIS
                    // U+0119: "??" LATIN SMALL LETTER E WITH OGONEK
                    // U+0117: "??" LATIN SMALL LETTER E WITH DOT ABOVE
                    // U+0113: "??" LATIN SMALL LETTER E WITH MACRON
                    .setMoreKeysOf("e",
                            "\u00E9", "\u00E8", "\u00EA", "\u00EB", "\u0119", "\u0117", "\u0113")
                    // U+00FA: "??" LATIN SMALL LETTER U WITH ACUTE
                    // U+00FC: "??" LATIN SMALL LETTER U WITH DIAERESIS
                    // U+0171: "??" LATIN SMALL LETTER U WITH DOUBLE ACUTE
                    // U+00FB: "??" LATIN SMALL LETTER U WITH CIRCUMFLEX
                    // U+00F9: "??" LATIN SMALL LETTER U WITH GRAVE
                    // U+016B: "??" LATIN SMALL LETTER U WITH MACRON
                    .setMoreKeysOf("u", "\u00FA", "\u00FC", "\u0171", "\u00FB", "\u00F9", "\u016B")
                    // U+00ED: "??" LATIN SMALL LETTER I WITH ACUTE
                    // U+00EE: "??" LATIN SMALL LETTER I WITH CIRCUMFLEX
                    // U+00EF: "??" LATIN SMALL LETTER I WITH DIAERESIS
                    // U+00EC: "??" LATIN SMALL LETTER I WITH GRAVE
                    // U+012F: "??" LATIN SMALL LETTER I WITH OGONEK
                    // U+012B: "??" LATIN SMALL LETTER I WITH MACRON
                    .setMoreKeysOf("i", "\u00ED", "\u00EE", "\u00EF", "\u00EC", "\u012F", "\u012B")
                    // U+00F3: "??" LATIN SMALL LETTER O WITH ACUTE
                    // U+00F6: "??" LATIN SMALL LETTER O WITH DIAERESIS
                    // U+0151: "??" LATIN SMALL LETTER O WITH DOUBLE ACUTE
                    // U+00F4: "??" LATIN SMALL LETTER O WITH CIRCUMFLEX
                    // U+00F2: "??" LATIN SMALL LETTER O WITH GRAVE
                    // U+00F5: "??" LATIN SMALL LETTER O WITH TILDE
                    // U+0153: "??" LATIN SMALL LIGATURE OE
                    // U+00F8: "??" LATIN SMALL LETTER O WITH STROKE
                    // U+014D: "??" LATIN SMALL LETTER O WITH MACRON
                    .setMoreKeysOf("o",
                            "\u00F3", "\u00F6", "\u0151", "\u00F4", "\u00F2", "\u00F5", "\u0153",
                            "\u00F8", "\u014D")
                    // U+00E1: "??" LATIN SMALL LETTER A WITH ACUTE
                    // U+00E0: "??" LATIN SMALL LETTER A WITH GRAVE
                    // U+00E2: "??" LATIN SMALL LETTER A WITH CIRCUMFLEX
                    // U+00E4: "??" LATIN SMALL LETTER A WITH DIAERESIS
                    // U+00E6: "??" LATIN SMALL LETTER AE
                    // U+00E3: "??" LATIN SMALL LETTER A WITH TILDE
                    // U+00E5: "??" LATIN SMALL LETTER A WITH RING ABOVE
                    // U+0101: "??" LATIN SMALL LETTER A WITH MACRON
                    .setMoreKeysOf("a",
                            "\u00E1", "\u00E0", "\u00E2", "\u00E4", "\u00E6", "\u00E3", "\u00E5",
                            "\u0101");
        }
    }
}
