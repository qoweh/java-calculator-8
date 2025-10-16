package calculator;

public class PreProcessor {
    private String delimiters;
    private PreProcessorUtil preProcessorUtil;

    public PreProcessor() {
        this.delimiters = ",:";
        this.preProcessorUtil = new PreProcessorUtil();
    }

    public String[] work(String input) {
        if (preProcessorUtil.haveCustomDelimiter(input)) {
            delimiters = preProcessorUtil
                    .getCustomDelimiter(input, delimiters);
            input = input.substring(5);
        }
        return preProcessorUtil.getSlicedStrings(input, delimiters);
    }
}
