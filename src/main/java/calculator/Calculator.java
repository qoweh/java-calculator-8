package calculator;

public class Calculator {
    private static long result;
    private static PreProcessor preProcessor;

    public Calculator() {
        result = 0L;
        preProcessor = new PreProcessor();
    }

    public long work(String input) {
        if (input.isEmpty()) {
            return 0L;
        }

        String[] refinedInput = preProcessor.work(input);

        for (String each : refinedInput) {
            if (preProcessor.refinedStringIsDigit(each)) {
                result += Long.parseLong(each);
            }
        }
        return result;
    }
}