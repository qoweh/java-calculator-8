package calculator;

public class PreProcessor {
    private final static String DELIMITERS = ",:";
    private final PreProcessorUtil preProcessorUtil = new PreProcessorUtil(DELIMITERS);

    public PreProcessor() {
    }

    public String[] work(String input) {
        StringBuilder inputStringBuilder = new StringBuilder(input);

        while (preProcessorUtil.haveCustomDelimiter(inputStringBuilder)) {
            preProcessorUtil.appendCustomDelimiter(inputStringBuilder);
            preProcessorUtil.makeSubstringToEndIndex(inputStringBuilder, 5);
        }
        return preProcessorUtil.getSlicedStrings(inputStringBuilder);
    }

    public boolean refinedStringIsDigit(String refined) {
        if (refined.isBlank()) {
            return false;
        } else if (preProcessorUtil.haveNonDigit(refined)) {
            throw new IllegalArgumentException("올바르지 않은 입력 형식입니다.");
        }
        return true;
    }

}
