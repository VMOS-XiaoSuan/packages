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

import static com.android.inputmethod.keyboard.layout.DevanagariLetterConstants.*;

import com.android.inputmethod.keyboard.KeyboardId;
import com.android.inputmethod.keyboard.layout.expected.ExpectedKey;
import com.android.inputmethod.keyboard.layout.expected.ExpectedKeyboardBuilder;
import com.android.inputmethod.latin.Constants;

import java.util.Locale;

/**
 * The Hindi keyboard.
 */
public final class Hindi extends LayoutBase {
    private static final String LAYOUT_NAME = "hindi";

    public Hindi(final LayoutCustomizer customizer) {
        super(customizer, HindiSymbols.class, SymbolsShifted.class);
    }

    @Override
    public String getName() { return LAYOUT_NAME; }

    public static class HindiCustomizer extends LayoutCustomizer {
        public HindiCustomizer(final Locale locale) { super(locale); }

        @Override
        public ExpectedKey getAlphabetKey() { return HINDI_ALPHABET_KEY; }

        @Override
        public ExpectedKey getSymbolsKey() { return HINDI_SYMBOLS_KEY; }

        @Override
        public ExpectedKey getBackToSymbolsKey() { return HINDI_BACK_TO_SYMBOLS_KEY; }

        @Override
        public ExpectedKey getCurrencyKey() { return CURRENCY_RUPEE; }

        @Override
        public ExpectedKey[] getOtherCurrencyKeys() {
            return SymbolsShifted.CURRENCIES_OTHER_GENERIC;
        }

        @Override
        public ExpectedKey[] getRightShiftKeys(final boolean isPhone) {
            return isPhone ? EMPTY_KEYS : EXCLAMATION_AND_QUESTION_MARKS;
        }

        // U+0915: "???" DEVANAGARI LETTER KA
        // U+0916: "???" DEVANAGARI LETTER KHA
        // U+0917: "???" DEVANAGARI LETTER GA
        private static final ExpectedKey HINDI_ALPHABET_KEY = key(
                "\u0915\u0916\u0917", Constants.CODE_SWITCH_ALPHA_SYMBOL);
        // U+0967: "???" DEVANAGARI DIGIT ONE
        // U+0968: "???" DEVANAGARI DIGIT TWO
        // U+0969: "???" DEVANAGARI DIGIT THREE
        private static final String HINDI_SYMBOLS_LABEL = "?\u0967\u0968\u0969";
        private static final ExpectedKey HINDI_SYMBOLS_KEY = key(HINDI_SYMBOLS_LABEL,
                Constants.CODE_SWITCH_ALPHA_SYMBOL);
        private static final ExpectedKey HINDI_BACK_TO_SYMBOLS_KEY = key(HINDI_SYMBOLS_LABEL,
                Constants.CODE_SHIFT);

        // U+20B9: "???" INDIAN RUPEE SIGN
        private static final ExpectedKey CURRENCY_RUPEE = key("\u20B9",
                Symbols.CURRENCY_GENERIC_MORE_KEYS);
    }

    @Override
    ExpectedKey[][] getCommonAlphabetLayout(boolean isPhone) { return ALPHABET_COMMON; }

    @Override
    ExpectedKey[][] getCommonAlphabetShiftLayout(boolean isPhone, final int elementId) {
        if (elementId == KeyboardId.ELEMENT_ALPHABET_AUTOMATIC_SHIFTED) {
            return getCommonAlphabetLayout(isPhone);
        }
        return ALPHABET_SHIFTED_COMMON;
    }

    private static final ExpectedKey[][] ALPHABET_COMMON = new ExpectedKeyboardBuilder()
            .setKeysOfRow(1,
                    // U+094C: "???" DEVANAGARI VOWEL SIGN AU
                    // U+094C/U+0902: "??????" DEVANAGARI VOWEL SIGN AU/DEVANAGARI SIGN ANUSVARA
                    // U+0967: "???" DEVANAGARI DIGIT ONE
                    key(VOWEL_SIGN_AU, "\u094C", joinMoreKeys(
                            moreKey(VOWEL_SIGN_AU + "\u0902", "\u094C\u0902"),
                            "\u0967", "1")),
                    // U+0948: "???" DEVANAGARI VOWEL SIGN AI
                    // U+0948/U+0902: "??????" DEVANAGARI VOWEL SIGN AI/DEVANAGARI SIGN ANUSVARA
                    // U+0968: "???" DEVANAGARI DIGIT TWO
                    key(VOWEL_SIGN_AI, "\u0948", joinMoreKeys(
                            moreKey(VOWEL_SIGN_AI + "\u0902", "\u0948\u0902"),
                            "\u0968", "2")),
                    // U+093E: "???" DEVANAGARI VOWEL SIGN AA
                    // U+093E/U+0902: "??????" DEVANAGARI VOWEL SIGN AA/DEVANAGARI SIGN ANUSVARA
                    // U+093E/U+0901: "??????" DEVANAGARI VOWEL SIGN AA/DEVANAGARI SIGN CANDRABINDU
                    // U+0969: "???" DEVANAGARI DIGIT THREE
                    key(VOWEL_SIGN_AA, "\u093E", joinMoreKeys(
                            moreKey(VOWEL_SIGN_AA + "\u0902", "\u093E\u0902"),
                            moreKey(VOWEL_SIGN_AA + "\u0901", "\u093E\u0901"),
                            "\u0969", "3")),
                    // U+0940: "???" DEVANAGARI VOWEL SIGN II
                    // U+0940/U+0902: "??????" DEVANAGARI VOWEL SIGN II/DEVANAGARI SIGN ANUSVARA
                    // U+096A: "???" DEVANAGARI DIGIT FOUR
                    key(VOWEL_SIGN_II, "\u0940", joinMoreKeys(
                            moreKey(VOWEL_SIGN_II + "\u0902", "\u0940\u0902"),
                            "\u096A", "4")),
                    // U+0942: "???" DEVANAGARI VOWEL SIGN UU
                    // U+0942/U+0902: "??????" DEVANAGARI VOWEL SIGN UU/DEVANAGARI SIGN ANUSVARA
                    // U+0942/U+0901: "??????" DEVANAGARI VOWEL SIGN UU/DEVANAGARI SIGN CANDRABINDU
                    // U+096B: "???" DEVANAGARI DIGIT FIVE
                    key(VOWEL_SIGN_UU, "\u0942", joinMoreKeys(
                            moreKey(VOWEL_SIGN_UU + "\u0902", "\u0942\u0902"),
                            moreKey(VOWEL_SIGN_UU + "\u0901", "\u0942\u0901"),
                            "\u096B", "5")),
                    // U+092C: "???" DEVANAGARI LETTER BA
                    // U+092C/U+0952: "??????" DEVANAGARI LETTER BA/DEVANAGARI STRESS SIGN ANUDATTA
                    // U+096C: "???" DEVANAGARI DIGIT SIX
                    key("\u092C", joinMoreKeys("\u092C\u0952", "\u096C", "6")),
                    // U+0939: "???" DEVANAGARI LETTER HA
                    // U+096D: "???" DEVANAGARI DIGIT SEVEN
                    key("\u0939", joinMoreKeys("\u096D", "7")),
                    // U+0917: "???" DEVANAGARI LETTER GA
                    // U+091C/U+094D/U+091E:
                    //     "?????????" DEVANAGARI LETTER JA/DEVANAGARI SIGN VIRAMA/DEVANAGARI LETTER NYA
                    // U+0917/U+093C: "??????" DEVANAGARI LETTER GA/DEVANAGARI SIGN NUKTA
                    // U+0917/U+0952: "??????" DEVANAGARI LETTER GA/DEVANAGARI STRESS SIGN ANUDATTA
                    // U+096E: "???" DEVANAGARI DIGIT EIGHT
                    key("\u0917", joinMoreKeys("\u091C\u094D\u091E", "\u0917\u093C", "\u0917\u0952",
                            "\u096E", "8")),
                    // U+0926: "???" DEVANAGARI LETTER DA
                    // U+096F: "???" DEVANAGARI DIGIT NINE
                    key("\u0926", joinMoreKeys("\u096F", "9")),
                    // U+091C: "???" DEVANAGARI LETTER JA
                    // U+091C/U+0952: "??????" DEVANAGARI LETTER JA/DEVANAGARI STRESS SIGN ANUDATTA
                    // U+091C/U+094D/U+091E:
                    //     "?????????" DEVANAGARI LETTER JA/DEVANAGARI SIGN VIRAMA/DEVANAGARI LETTER NYA
                    // U+091C/U+093C: "??????" DEVANAGARI LETTER JA/DEVANAGARI SIGN NUKTA
                    // U+0966: "???" DEVANAGARI DIGIT ZERO
                    key("\u091C", joinMoreKeys("\u091C\u0952", "\u091C\u094D\u091E", "\u091C\u093C",
                            "\u0966", "0")),
                    // U+0921: "???" DEVANAGARI LETTER DDA
                    // U+0921/U+0952: "??????" DEVANAGARI LETTER DDA/DEVANAGARI STRESS SIGN ANUDATTA
                    // U+0921/U+093C: "??????" DEVANAGARI LETTER DDA/DEVANAGARI SIGN NUKTA
                    key("\u0921", joinMoreKeys("\u0921\u0952", "\u0921\u093C")))
            .setKeysOfRow(2,
                    // U+094B: "???" DEVANAGARI VOWEL SIGN O
                    // U+094B/U+0902: "?????" DEVANAGARI VOWEL SIGN O/DEVANAGARI SIGN ANUSVARA
                    // U+0949: "???" DEVANAGARI VOWEL SIGN CANDRA O
                    // U+094A: "???" DEVANAGARI VOWEL SIGN SHORT O
                    key(VOWEL_SIGN_O, "\u094B", joinMoreKeys(
                            moreKey(VOWEL_SIGN_O + "\u0902", "\u094B\u0902"),
                            moreKey(VOWEL_SIGN_CANDRA_O, "\u0949"),
                            moreKey(VOWEL_SIGN_SHORT_O, "\u094A"))),
                    // U+0947: "???" DEVANAGARI VOWEL SIGN E
                    // U+0947/U+0902: "??????" DEVANAGARI VOWEL SIGN E/DEVANAGARI SIGN ANUSVARA
                    key(VOWEL_SIGN_E, "\u0947",
                            moreKey(VOWEL_SIGN_E + "\u0902", "\u0947\u0902")),
                    // U+094D: "???" DEVANAGARI SIGN VIRAMA
                    key(SIGN_VIRAMA, "\u094D"),
                    // U+093F: "???" DEVANAGARI VOWEL SIGN I
                    // U+093F/U+0902: "??????" DEVANAGARI VOWEL SIGN I/DEVANAGARI SIGN ANUSVARA
                    key(VOWEL_SIGN_I, "\u093F",
                            moreKey("\u093F" + SIGN_ANUSVARA, "\u093F\u0902")),
                    // U+0941: "???" DEVANAGARI VOWEL SIGN U
                    // U+0941/U+0902: "??????" DEVANAGARI VOWEL SIGN U/DEVANAGARI SIGN ANUSVARA
                    // U+0941/U+0901: "??????" DEVANAGARI VOWEL SIGN U/DEVANAGARI SIGN CANDRABINDU
                    key(VOWEL_SIGN_U, "\u0941", joinMoreKeys(
                            moreKey(VOWEL_SIGN_U + "\u0902", "\u0941\u0902"),
                            moreKey(VOWEL_SIGN_U + "\u0901", "\u0941\u0901"))),
                    // U+092A: "???" DEVANAGARI LETTER PA
                    "\u092A",
                    // U+0930: "???" DEVANAGARI LETTER RA
                    // U+090B: "???" DEVANAGARI LETTER VOCALIC R
                    // U+0930/U+093C: "??????" DEVANAGARI LETTER RA/DEVANAGARI SIGN NUKTA
                    // U+0960: "???" DEVANAGARI LETTER VOCALIC RR
                    key("\u0930", joinMoreKeys("\u090B", "\u0930\u093C", "\u0960")),
                    // U+0915: "???" DEVANAGARI LETTER KA
                    // U+0915/U+093C: "??????" DEVANAGARI LETTER KA/DEVANAGARI SIGN NUKTA
                    key("\u0915", moreKey("\u0915\u093C")),
                    // U+0924: "???" DEVANAGARI LETTER TA
                    // U+0924/U+094D/U+0930:
                    //     "?????????" DEVANAGARI LETTER TA/DEVANAGARI SIGN VIRAMA/DEVANAGARI LETTER RA
                    key("\u0924", moreKey("\u0924\u094D\u0930")),
                    // U+091A: "???" DEVANAGARI LETTER CA
                    // U+091F: "???" DEVANAGARI LETTER TTA
                    "\u091A","\u091F")
            .setKeysOfRow(3,
                    // U+0949: "???" DEVANAGARI VOWEL SIGN CANDRA O
                    key(VOWEL_SIGN_CANDRA_O, "\u0949"),
                    // U+0902: "???" DEVANAGARI SIGN ANUSVARA
                    key(SIGN_ANUSVARA, "\u0902"),
                    // U+092E: "???" DEVANAGARI LETTER MA
                    // U+0950: "???" DEVANAGARI OM
                    key("\u092E", moreKey("\u0950")),
                    // U+0928: "???" DEVANAGARI LETTER NA
                    // U+091E: "???" DEVANAGARI LETTER NYA
                    // U+0919: "???" DEVANAGARI LETTER NGA
                    // U+0928/U+093C: "??????" DEVANAGARI LETTER NA/DEVANAGARI SIGN NUKTA
                    key("\u0928", joinMoreKeys("\u091E", "\u0919", "\u0928\u093C")),
                    // U+0935: "???" DEVANAGARI LETTER VA
                    "\u0935",
                    // U+0932: "???" DEVANAGARI LETTER LA
                    // U+090C: "???" DEVANAGARI LETTER VOCALIC L
                    // U+0961: "???" DEVANAGARI LETTER VOCALIC LL
                    key("\u0932", joinMoreKeys("\u090C", "\u0961")),
                    // U+0938: "???" DEVANAGARI LETTER SA
                    "\u0938",
                    // U+092F: "???" DEVANAGARI LETTER YA
                    // U+095F: "???" DEVANAGARI LETTER YYA
                    key("\u092F", moreKey("\u095F")),
                    // U+093C: "???" DEVANAGARI SIGN NUKTA
                    // U+097D: "???" DEVANAGARI LETTER GLOTTAL STOP
                    // U+0970: "???" DEVANAGARI ABBREVIATION SIGN
                    // U+093D: "???" DEVANAGARI SIGN AVAGRAHA
                    key(SIGN_NUKTA, "\u093C", joinMoreKeys(
                            moreKey(LETTER_GLOTTAL_STOP, "\u097D"),
                            moreKey(ABBREVIATION_SIGN, "\u0970"),
                            moreKey(SIGN_AVAGRAHA, "\u093D"))))
            .build();

    private static final ExpectedKey[][] ALPHABET_SHIFTED_COMMON = new ExpectedKeyboardBuilder()
            .setKeysOfRow(1,
                    // U+0914: "???" DEVANAGARI LETTER AU
                    // U+0912/U+0902: "??????" DEVANAGARI LETTER SHORT O//DEVANAGARI SIGN ANUSVARA
                    key("\u0914", moreKey("\u0912\u0902")),
                    // U+0910: "???" DEVANAGARI LETTER AI
                    // U+0910/U+0902: "??????" DEVANAGARI LETTER AI/DEVANAGARI SIGN ANUSVARA
                    key("\u0910", moreKey("\u0910\u0902")),
                    // U+0906: "???" DEVANAGARI LETTER AA
                    // U+0906/U+0902: "??????" DEVANAGARI LETTER AA/DEVANAGARI SIGN ANUSVARA
                    // U+0906/U+0901: "??????" DEVANAGARI LETTER AA/DEVANAGARI SIGN CANDRABINDU
                    key("\u0906", joinMoreKeys("\u0906\u0902", "\u0906\u0901")),
                    // U+0908: "???" DEVANAGARI LETTER II
                    // U+0908/U+0902: "??????" DEVANAGARI LETTER II/DEVANAGARI SIGN ANUSVARA
                    key("\u0908", moreKey("\u0908\u0902")),
                    // U+090A: "???" DEVANAGARI LETTER UU
                    // U+090A/U+0902: "??????" DEVANAGARI LETTER UU/DEVANAGARI SIGN ANUSVARA
                    // U+090A/U+0901: "??????" DEVANAGARI LETTER UU/DEVANAGARI SIGN CANDRABINDU
                    key("\u090A", joinMoreKeys("\u090A\u0902", "\u090A\u0901")),
                    // U+092D: "???" DEVANAGARI LETTER BHA
                    // U+0903: "???" DEVANAGARI SIGN VISARGA
                    // U+0918: "???" DEVANAGARI LETTER GHA
                    "\u092D", key(SIGN_VISARGA, "\u0903"), "\u0918",
                    // U+0927: "???" DEVANAGARI LETTER DHA
                    // U+0915/U+094D/U+0937:
                    //     "?????????" DEVANAGARI LETTER KA/DEVANAGARI SIGN VIRAMA/DEVANAGARI LETTER SSA
                    // U+0936/U+094D/U+0930:
                    //     "?????????" DEVANAGARI LETTER SHA/DEVANAGARI SIGN VIRAMA/DEVANAGARI LETTER RA
                    key("\u0927", joinMoreKeys("\u0915\u094D\u0937", "\u0936\u094D\u0930")),
                    // U+091D: "???" DEVANAGARI LETTER JHA
                    // U+0922: "???" DEVANAGARI LETTER DDHA
                    "\u091D", "\u0922")
            .setKeysOfRow(2,
                    // U+0913: "???" DEVANAGARI LETTER O
                    // U+0913/U+0902: "??????" DEVANAGARI LETTER O/DEVANAGARI SIGN ANUSVARA
                    // U+0911: "???" DEVANAGARI LETTER CANDRA O
                    // U+0912: "???" DEVANAGARI LETTER SHORT O
                    key("\u0913", joinMoreKeys("\u0913\u0902", "\u0911", "\u0912")),
                    // U+090F: "???" DEVANAGARI LETTER E
                    // U+090F/U+0902: "??????" DEVANAGARI LETTER E/DEVANAGARI SIGN ANUSVARA
                    // U+090F/U+0901: "??????" DEVANAGARI LETTER E/DEVANAGARI SIGN CANDRABINDU
                    // U+090D: "???" DEVANAGARI LETTER CANDRA E
                    // U+090E: "???" DEVANAGARI LETTER SHORT E
                    key("\u090F", joinMoreKeys("\u090F\u0902", "\u090F\u0901", "\u090D", "\u090E")),
                    // U+0905: "???" DEVANAGARI LETTER A
                    // U+0905/U+0902: "??????" DEVANAGARI LETTER A/DEVANAGARI SIGN ANUSVARA
                    // U+0905/U+0901: "??????" DEVANAGARI LETTER A/DEVANAGARI SIGN CANDRABINDU
                    key("\u0905", joinMoreKeys("\u0905\u0902", "\u0905\u0901")),
                    // U+0907: "???" DEVANAGARI LETTER I
                    // U+0907/U+0902: "??????" DEVANAGARI LETTER I/DEVANAGARI SIGN ANUSVARA
                    // U+0907/U+0901: "??????" DEVANAGARI LETTER I/DEVANAGARI SIGN CANDRABINDU
                    key("\u0907", joinMoreKeys("\u0907\u0902", "\u0907\u0901")),
                    // U+0909: "???" DEVANAGARI LETTER U
                    // U+0909/U+0902: "??????" DEVANAGARI LETTER U/DEVANAGARI SIGN ANUSVARA
                    // U+0909/U+0901: "??????" DEVANAGARI LETTER U/DEVANAGARI SIGN CANDRABINDU
                    key("\u0909", joinMoreKeys("\u0909\u0902", "\u0909\u0901")),
                    // U+092B: "???" DEVANAGARI LETTER PHA
                    // U+092B/U+093C: "??????" DEVANAGARI LETTER PHA/DEVANAGARI SIGN NUKTA
                    key("\u092B", moreKey("\u092B\u093C")),
                    // U+0931: "???" DEVANAGARI LETTER RRA
                    // U+094D/U+0930: "??????" DEVANAGARI SIGN VIRAMA/DEVANAGARI LETTER RA
                    // U+0930/U+094D: "??????" DEVANAGARI LETTER RA/DEVANAGARI SIGN VIRAMA
                    key("\u0931", joinMoreKeys("\u094D\u0930", "\u0930\u094D")),
                    // U+0916: "???" DEVANAGARI LETTER KHA
                    // U+0916/U+093C: "??????" DEVANAGARI LETTER KHA/DEVANAGARI SIGN NUKTA
                    key("\u0916", moreKey("\u0916\u093C")),
                    // U+0925: "???" DEVANAGARI LETTER THA
                    // U+091B: "???" DEVANAGARI LETTER CHA
                    // U+0920: "???" DEVANAGARI LETTER TTHA
                    "\u0925", "\u091B", "\u0920")
            .setKeysOfRow(3,
                    // U+0911: "???" DEVANAGARI LETTER CANDRA O
                    "\u0911",
                    // U+0901: "???" DEVANAGARI SIGN CANDRABINDU
                    // U+0945: "???" DEVANAGARI VOWEL SIGN CANDRA E
                    key(SIGN_CANDRABINDU, "\u0901", moreKey(VOWEL_SIGN_CANDRA_E, "\u0945")),
                    // U+0923: "???" DEVANAGARI LETTER NNA
                    // U+0929: "???" DEVANAGARI LETTER NNNA
                    "\u0923", "\u0929",
                    // U+0933: "???" DEVANAGARI LETTER LLA
                    // U+0934: "???" DEVANAGARI LETTER LLLA
                    key("\u0933", moreKey("\u0934")),
                    // U+0936: "???" DEVANAGARI LETTER SHA
                    // U+0937: "???" DEVANAGARI LETTER SSA
                    "\u0936", "\u0937",
                    // U+0943: "???" DEVANAGARI VOWEL SIGN VOCALIC R
                    // U+0944: "???" DEVANAGARI VOWEL SIGN VOCALIC RR
                    key(VOWEL_SIGN_VOCALIC_R, "\u0943", moreKey(VOWEL_SIGN_VOCALIC_RR, "\u0944")),
                    // U+091E: "???" DEVANAGARI LETTER NYA
                    "\u091E")
            .build();

    static class HindiSymbols extends Symbols {
        public HindiSymbols(final LayoutCustomizer customizer) {
            super(customizer);
        }

        @Override
        public ExpectedKey[][] getLayout(final boolean isPhone) {
            return new ExpectedKeyboardBuilder(super.getLayout(isPhone))
                    // U+0967: "???" DEVANAGARI DIGIT ONE
                    // U+00B9: "??" SUPERSCRIPT ONE
                    // U+00BD: "??" VULGAR FRACTION ONE HALF
                    // U+2153: "???" VULGAR FRACTION ONE THIRD
                    // U+00BC: "??" VULGAR FRACTION ONE QUARTER
                    // U+215B: "???" VULGAR FRACTION ONE EIGHTH
                    .replaceKeyOfLabel("1", key("\u0967",
                            joinMoreKeys("1", "\u00B9", "\u00BD", "\u2153", "\u00BC", "\u215B")))
                    // U+0968: "???" DEVANAGARI DIGIT TWO
                    // U+00B2: "??" SUPERSCRIPT TWO
                    // U+2154: "???" VULGAR FRACTION TWO THIRDS
                    .replaceKeyOfLabel("2", key("\u0968", joinMoreKeys("2", "\u00B2", "\u2154")))
                    // U+0969: "???" DEVANAGARI DIGIT THREE
                    // U+00B3: "??" SUPERSCRIPT THREE
                    // U+00BE: "??" VULGAR FRACTION THREE QUARTERS
                    // U+215C: "???" VULGAR FRACTION THREE EIGHTHS
                    .replaceKeyOfLabel("3", key("\u0969",
                            joinMoreKeys("3", "\u00B3", "\u00BE","\u215C")))
                    // U+096A: "???" DEVANAGARI DIGIT FOUR
                    // U+2074: "???" SUPERSCRIPT FOUR
                    .replaceKeyOfLabel("4", key("\u096A", joinMoreKeys("4", "\u2074")))
                    // U+096B: "???" DEVANAGARI DIGIT FIVE
                    // U+215D: "???" VULGAR FRACTION FIVE EIGHTHS
                    .replaceKeyOfLabel("5", key("\u096B", joinMoreKeys("5", "\u215D")))
                    // U+096C: "???" DEVANAGARI DIGIT SIX
                    .replaceKeyOfLabel("6", key("\u096C", moreKey("6")))
                    // U+096D: "???" DEVANAGARI DIGIT SEVEN
                    // U+215E: "???" VULGAR FRACTION SEVEN EIGHTHS
                    .replaceKeyOfLabel("7", key("\u096D", joinMoreKeys("7", "\u215E")))
                    // U+096E: "???" DEVANAGARI DIGIT EIGHT
                    .replaceKeyOfLabel("8", key("\u096E", moreKey("8")))
                    // U+096F: "???" DEVANAGARI DIGIT NINE
                    .replaceKeyOfLabel("9", key("\u096F", moreKey("9")))
                    // U+0966: "???" DEVANAGARI DIGIT ZERO
                    // U+207F: "???" SUPERSCRIPT LATIN SMALL LETTER N
                    // U+2205: "???" EMPTY SET
                    .replaceKeyOfLabel("0", key("\u0966", joinMoreKeys("0", "\u207F", "\u2205")))
                    .build();
        }
    }
}
