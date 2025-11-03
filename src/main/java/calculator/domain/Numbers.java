package calculator.domain;

import calculator.ErrorMessage;
import java.util.List;

public class Numbers {
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
            if (s.length() > 9) {
                throw new IllegalArgumentException(ErrorMessage.TOO_BIG.getMessage());
            }
        });
    }
}
