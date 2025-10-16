package calculator;

public class PreProcessorUtil {
    public PreProcessorUtil() {}

    public String getCustomDelimiter(String input, String delimiters) {
        delimiters += input.charAt(2);
        return delimiters;
    }

    public boolean haveCustomDelimiter(String input) {
        if (input.charAt(0) != '/') {
            return false;
        }
        if (input.charAt(1) == '/' && input.charAt(3) == '\\' && input.charAt(4) == 'n') {
            return true;
        }
        throw new IllegalArgumentException("올바르지 않은 입력 형식입니다.");
    }

    public String[] getSlicedStrings(String input, String delimiters) {
        return input.split("[" + delimiters + "]");
    }
}
