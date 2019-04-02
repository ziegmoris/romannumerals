package enums;

public enum RomanEnum {
        I("1", ""),
        V("5", "I"),
        X("10","I"),
        L("50", "X"),
        C("100", "X"),
        D("500", "C"),
        M("1000", "C");

        private String arabic;
        private String prev;

        RomanEnum(String arabic, String prev) {
            this.arabic = arabic;
            this.prev = prev;
        }

        public String getArabic() {
            return this.arabic;
        }

        public String getPrev() {
            return prev;
        }
    }