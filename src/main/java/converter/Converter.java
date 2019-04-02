package converter;


import enums.ArabicEnum;
import enums.RomanEnum;

import java.text.ParseException;
import java.util.regex.Pattern;

class Converter {

    private Converter() {
    }

    static String convert(String num) throws ParseException {
        String convertedValue;

        if (Pattern.matches("[IVXLCDM]+", num)) {
            if (num.startsWith("MMM") && num.length() > 3) {
                throw new ParseException("Maximum of 3000", -1);
            }
            convertedValue = String.valueOf(getConvertedRomanNumeral(num));
        } else if (Pattern.matches("[0-9]+", num)) {
            Integer integer = Integer.valueOf(num);
            if (integer > 3000 || integer < 1) {
                throw new ParseException("Maximum of 3000 and minimum of 1", -1);
            }
            convertedValue = getConvertedArabicValue(integer);
        } else {
            throw new ParseException("Invalid input", -1);
        }

        return convertedValue;
    }

    private static String getConvertedArabicValue(Integer integer) throws ParseException {
        String convertedValue;
        int thousands = integer / 1000;
        thousands = thousands * 1000;
        integer = integer - thousands;

        int hundreds = integer / 100;
        hundreds = hundreds * 100;
        integer = integer - hundreds;

        int tens = integer / 10;
        tens = tens * 10;
        integer = integer - tens;

        int ones = integer;

        convertedValue = getDecimalValue(thousands, ArabicEnum.valueOf("THOUSANDS"))
                + getDecimalValue(hundreds, ArabicEnum.valueOf("HUNDREDS"))
                + getDecimalValue(tens, ArabicEnum.valueOf("TENS"))
                + getDecimalValue(ones, ArabicEnum.valueOf("ONES"));
        return convertedValue;
    }

    private static String getDecimalValue(int arabicVal, ArabicEnum arabicEnum) throws ParseException {
        StringBuilder val = new StringBuilder();
        if (arabicVal > 0) {
            while (val.toString().isEmpty()
                    || getConvertedRomanNumeral(val.toString()) < arabicVal) {
                if (val.toString().contains(arabicEnum.getMinVal()
                        + arabicEnum.getMinVal()
                        + arabicEnum.getMinVal())) {
                    if (val.toString().contains(arabicEnum.getMidVal())) {
                        val = new StringBuilder(arabicEnum.getMaxVal());
                    } else {
                        val = new StringBuilder(arabicEnum.getMinVal() + arabicEnum.getMidVal());
                    }
                } else if (val.toString().contains(arabicEnum.getMinVal() + arabicEnum.getMidVal())) {
                    val = new StringBuilder(arabicEnum.getMidVal());
                } else {
                    val.append(arabicEnum.getMinVal());
                }
            }
        }
        return val.toString();
    }

    private static int getConvertedRomanNumeral(String num) throws ParseException {
        int totalVal = 0;
        String previousNum = "N/A";
        int numCount = 1;
        for (String n : num.split("")) {
            RomanEnum romanEnum = RomanEnum.valueOf(n);
            Integer integer = Integer.valueOf(romanEnum.getArabic());
            if (!previousNum.equals(n)) {
                numCount = 1;
                if (previousNum.equals(romanEnum.getPrev())) {
                    totalVal += integer - (Integer.valueOf(RomanEnum.valueOf(previousNum).getArabic()) * 2);
                } else if (!"N/A".equals(previousNum) && !num.equals(previousNum)
                        && Integer.valueOf(RomanEnum.valueOf(previousNum).getArabic()) < integer) {
                    throw new ParseException("Invalid roman numeral", -1);
                } else {
                    totalVal += integer;
                }
            } else {
                numCount++;
                if (numCount == 4) {
                    throw new ParseException("Cannot have more than 3 repeating roman numerals next to each other", -1);
                }
                totalVal += integer;
            }
            previousNum = n;
        }
        return totalVal;
    }
}
