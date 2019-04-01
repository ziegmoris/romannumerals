package converter;

import java.util.regex.Pattern;

class Converter {

    static String convert(String num) {
        if (Pattern.matches("[a-zA-Z]+", num)) {
            return "1";
        } else if (Pattern.matches("[0-9]+", num)) {
            return "0";
        }
        return "Invalid";
    }
}
