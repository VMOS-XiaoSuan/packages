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
 * cs: Czech/qwertz
 */
@SmallTest
public final class TestsCzech extends LayoutTestsBase {
    private static final Locale LOCALE = new Locale("cs");
    private static final LayoutBase LAYOUT = new Qwertz(new CzechCustomizer(LOCALE));

    @Override
    LayoutBase getLayout() { return LAYOUT; }

    private static class CzechCustomizer extends LayoutCustomizer {
        public CzechCustomizer(final Locale locale) { super(locale); }

        @Override
        public ExpectedKey[] getDoubleQuoteMoreKeys() { return Symbols.DOUBLE_QUOTES_R9L; }

        @Override
        public ExpectedKey[] getSingleQuoteMoreKeys() { return Symbols.SINGLE_QUOTES_R9L; }

        @Override
        public ExpectedKey[] getDoubleAngleQuoteKeys() { return Symbols.DOUBLE_ANGLE_QUOTES_RL; }

        @Override
        public ExpectedKey[] getSingleAngleQuoteKeys() { return Symbols.SINGLE_ANGLE_QUOTES_RL; }

        @Override
        public ExpectedKeyboardBuilder setAccentedLetters(final ExpectedKeyboardBuilder builder) {
            return builder
                    // U+00E9: "??" LATIN SMALL LETTER E WITH ACUTE
                    // U+011B: "??" LATIN SMALL LETTER E WITH CARON
                    // U+00E8: "??" LATIN SMALL LETTER E WITH GRAVE
                    // U+00EA: "??" LATIN SMALL LETTER E WITH CIRCUMFLEX
                    // U+00EB: "??" LATIN SMALL LETTER E WITH DIAERESIS
                    // U+0119: "??" LATIN SMALL LETTER E WITH OGONEK
                    // U+0117: "??" LATIN SMALL LETTER E WITH DOT ABOVE
                    // U+0113: "??" LATIN SMALL LETTER E WITH MACRON
                    .setMoreKeysOf("e",
                            "\u00E9", "\u011B", "\u00E8", "\u00EA", "\u00EB", "\u0119", "\u0117",
                            "\u0113")
                    // U+0159: "??" LATIN SMALL LETTER R WITH CARON
                    .setMoreKeysOf("r", "\u0159")
                    // U+0165: "??" LATIN SMALL LETTER T WITH CARON
                    .setMoreKeysOf("t", "\u0165")
                    // U+017E: "??" LATIN SMALL LETTER Z WITH CARON
                    // U+017A: "??" LATIN SMALL LETTER Z WITH ACUTE
                    // U+017C: "??" LATIN SMALL LETTER Z WITH DOT ABOVE
                    .setMoreKeysOf("z", "\u017E", "\u017A", "\u017C")
                    // U+00FA: "??" LATIN SMALL LETTER U WITH ACUTE
                    // U+016F: "??" LATIN SMALL LETTER U WITH RING ABOVE
                    // U+00FB: "??" LATIN SMALL LETTER U WITH CIRCUMFLEX
                    // U+00FC: "??" LATIN SMALL LETTER U WITH DIAERESIS
                    // U+00F9: "??" LATIN SMALL LETTER U WITH GRAVE
                    // U+016B: "??" LATIN SMALL LETTER U WITH MACRON
                    .setMoreKeysOf("u", "\u00FA", "\u016F", "\u00FB", "\u00FC", "\u00F9", "\u016B")
                    // U+00ED: "??" LATIN SMALL LETTER I WITH ACUTE
                    // U+00EE: "??" LATIN SMALL LETTER I WITH CIRCUMFLEX
                    // U+00EF: "??" LATIN SMALL LETTER I WITH DIAERESIS
                    // U+00EC: "??" LATIN SMALL LETTER I WITH GRAVE
                    // U+012F: "??" LATIN SMALL LETTER I WITH OGONEK
                    // U+012B: "??" LATIN SMALL LETTER I WITH MACRON
                    .setMoreKeysOf("i", "\u00ED", "\u00EE", "\u00EF", "\u00EC", "\u012F", "\u012B")
                    // U+00F3: "??" LATIN SMALL LETTER O WITH ACUTE
                    // U+00F6: "??" LATIN SMALL LETTER O WITH DIAERESIS
                    // U+00F4: "??" LATIN SMALL LETTER O WITH CIRCUMFLEX
                    // U+00F2: "??" LATIN SMALL LETTER O WITH GRAVE
                    // U+00F5: "??" LATIN SMALL LETTER O WITH TILDE
                    // U+0153: "??" LATIN SMALL LIGATURE OE
                    // U+00F8: "??" LATIN SMALL LETTER O WITH STROKE
                    // U+014D: "??" LATIN SMALL LETTER O WITH MACRON
                    .setMoreKeysOf("o",
                            "\u00F3", "\u00F6", "\u00F4", "\u00F2", "\u00F5", "\u0153", "\u00F8",
                            "\u014D")
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
                            "\u0101")
                    // U+0161: "??" LATIN SMALL LETTER S WITH CARON
                    // U+00DF: "??" LATIN SMALL LETTER SHARP S
                    // U+015B: "??" LATIN SMALL LETTER S WITH ACUTE
                    .setMoreKeysOf("s", "\u0161", "\u00DF", "\u015B")
                    // U+010F: "??" LATIN SMALL LETTER D WITH CARON
                    .setMoreKeysOf("d", "\u010F")
                    // U+00FD: "??" LATIN SMALL LETTER Y WITH ACUTE
                    // U+00FF: "??" LATIN SMALL LETTER Y WITH DIAERESIS
                    .setMoreKeysOf("y", "\u00FD", "\u00FF")
                    // U+010D: "??" LATIN SMALL LETTER C WITH CARON
                    // U+00E7: "??" LATIN SMALL LETTER C WITH CEDILLA
                    // U+0107: "??" LATIN SMALL LETTER C WITH ACUTE
                    .setMoreKeysOf("c", "\u010D", "\u00E7", "\u0107")
                    // U+0148: "??" LATIN SMALL LETTER N WITH CARON
                    // U+00F1: "??" LATIN SMALL LETTER N WITH TILDE
                    // U+0144: "??" LATIN SMALL LETTER N WITH ACUTE
                    .setMoreKeysOf("n", "\u0148", "\u00F1", "\u0144");
        }
    }
}
