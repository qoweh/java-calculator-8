package calculator;

public class Calculator {
    private static long result;
    private static PreProcessor preProcessor;

    public Calculator() {
        result = 0L;
        preProcessor = new PreProcessor();
    }

    public long work(String input) {
        if (input.isEmpty()) return 0L;

        String[] refinedInput = preProcessor.work(input);
        for (String each : refinedInput) {
            try {
                if (!each.isBlank()) {
                    result += Long.parseLong(each);
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("올바르지 않은 입력 형식입니다.");
            }
        }
        return result;
    }
}