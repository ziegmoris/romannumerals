package enums;

public enum ArabicEnum {
    ONES("I", "V", "IX"),
    TENS("X", "L", "XL"),
    HUNDREDS("C", "D", "CM"),
    THOUSANDS("M", "", "");

    private String minVal;
    private String midVal;
    private String maxVal;

    ArabicEnum(String minVal, String midVal, String maxVal) {
        this.minVal = minVal;
        this.midVal = midVal;
        this.maxVal = maxVal;
    }

    public String getMinVal() {
        return minVal;
    }

    public String getMidVal() {
        return midVal;
    }

    public String getMaxVal() {
        return maxVal;
    }
}
