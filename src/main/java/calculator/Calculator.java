package calculator;

public class Calculator {
    private long result;
    private PreProcessor preProcessor;

    public Calculator() {
        this.result = 0;
        this.preProcessor = new PreProcessor();
    }

    public long work(String input) {
        if (input.isEmpty()) return 0;

        String[] refinedInput = preProcessor.work(input);
        for (String each : refinedInput) {
            try {
                if (!each.isBlank()) {
                    this.result += Long.parseLong(each);
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("올바르지 않은 입력 형식입니다.");
            }
        }
        return this.result;
    }
}