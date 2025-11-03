package calculator.domain;

import calculator.ErrorMessage;
import java.util.List;

public class Numbers {
    private static final int MAX_LENGTH = 9;
    private final List<Integer> integers;

    private Numbers(List<Integer> integers) {
        this.integers = integers;
    }

    public static Numbers from(List<String> strings) throws IllegalArgumentException {
        validate(strings);
        List<Integer> integers = strings.stream().map(Integer::parseInt).toList();
        return new Numbers(integers);
    }

    private static void validate(List<String> strings) throws IllegalArgumentException {
        strings.forEach(s -> {
            if (s.length() > MAX_LENGTH) {
                throw new IllegalArgumentException(ErrorMessage.TOO_BIG.getMessage());
            }
        });
    }

    public int calculateSum() {
        return integers.stream().mapToInt(Integer::intValue).sum();
    }
}
