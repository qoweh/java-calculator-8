package calculator;

public class PreProcessorUtil {
    private final StringBuilder delimiterStringBuilder;

    public PreProcessorUtil(final String DELIMITERS) {
        this.delimiterStringBuilder = new StringBuilder(DELIMITERS);
    }

    public boolean haveCustomDelimiter(StringBuilder inputStringBuilder) {
        String input = inputStringBuilder.toString();

        if (input.charAt(0) != '/') {
            return false;
        }
        if (input.charAt(1) == '/'
                && input.charAt(3) == '\\'
                && input.charAt(4) == 'n') {
            return true;
        }
        throw new IllegalArgumentException("올바르지 않은 입력 형식입니다.");
    }

    public void appendCustomDelimiter(StringBuilder inputStringBuilder) {
        String input = inputStringBuilder.toString();
        delimiterStringBuilder.append(input.charAt(2));
    }

    public String[] getSlicedStrings(StringBuilder inputStringBuilder) {
        delimiterStringBuilder.insert(0, "[");
        delimiterStringBuilder.append("]");

        String input = inputStringBuilder.toString();
        return input.split(delimiterStringBuilder.toString());
    }

    public void makeSubstringToEndIndex(StringBuilder inputStringBuilder, int endIndex) {
        inputStringBuilder.delete(0, endIndex);
    }
}
