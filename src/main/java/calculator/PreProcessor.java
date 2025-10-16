package calculator;

public class PreProcessor {
    public String delimiters;
    private NumFilter numfilter;

    public PreProcessor() {
        this.delimiters = ",:";
        this.numfilter = new NumFilter();
    }

    public long doPreProcess(String inputString) {
        if (inputString.isEmpty()) return 0;
        if (inputString.charAt(0) == '/') {
            if (inputString.charAt(1) == '/' && inputString.charAt(3) == '\\' && inputString.charAt(4) == 'n') {
                delimiters += inputString.charAt(2);
                inputString = inputString.substring(5);
            } else {
                throw new IllegalArgumentException();
            }
        }
        String[] splitedStrings = inputString.split("[" + delimiters + "]");
        long result = 0;
        for (String splitedString : splitedStrings) {
            try {
                result += Long.parseLong(splitedString);
            } catch (Exception E) {
                throw new IllegalArgumentException();
            }
        }
        return result;
    }
}
