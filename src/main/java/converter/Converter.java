package converter;


import enums.RomanEnum;

import java.text.ParseException;
import java.util.regex.Pattern;

class Converter {

    private Converter() {
    }

    static String convert(String num) throws ParseException {
        String convertedValue = "";

        if (Pattern.matches("[IVXLCDM]+", num)) {
            if (num.startsWith("MMM") && num.length() > 3) {
                throw new ParseException("Maximum of 3000", -1);
            }
            convertedValue = String.valueOf(getConvertedRomanNumeral(num));
        } else if (Pattern.matches("[0-9]+", num)) {
            Integer integer = Integer.valueOf(num);
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

            convertedValue = getTensValue(tens) + getOnesValue(ones);
        } else {
            throw new ParseException("Invalid input", -1);
        }

        return convertedValue;
    }

    private static String getTensValue(int tens) throws ParseException {
        StringBuilder tensString = new StringBuilder();
        if (tens > 0) {
            while (tensString.toString().isEmpty()
                    || getConvertedRomanNumeral(tensString.toString()) < tens) {
                if (tensString.toString().contains("XXX")) {
                    if (tensString.toString().contains("L")) {
                        tensString = new StringBuilder("XC");
                    } else {
                        tensString = new StringBuilder("XL");
                    }
                } else if(tensString.toString().contains("XL")) {
                    tensString = new StringBuilder("L");
                } else {
                    tensString.append("X");
                }
            }
        }
        return tensString.toString();
    }

    private static String getOnesValue(int ones) throws ParseException {
        StringBuilder onesString = new StringBuilder();
        if (ones > 0) {
            while (onesString.toString().isEmpty()
                    || getConvertedRomanNumeral(onesString.toString()) < ones) {
                if (onesString.toString().contains("III")) {
                    if (onesString.toString().contains("V")) {
                        onesString = new StringBuilder("IX");
                    } else {
                        onesString = new StringBuilder("IV");
                    }
                } else if(onesString.toString().contains("IV")) {
                    onesString = new StringBuilder("V");
                } else {
                    onesString.append("I");
                }
            }
        }
        return onesString.toString();
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
