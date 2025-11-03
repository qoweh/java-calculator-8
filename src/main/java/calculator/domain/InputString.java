package calculator.domain;

import calculator.ErrorMessage;
import java.util.List;

public class InputString {
    private static final int ALL = -1;
    private List<String> slicedInput;

    private InputString(List<String> slicedInput) {
        this.slicedInput = slicedInput;
    }

    public static InputString from(String input) throws IllegalArgumentException {
        validate(input);
//        String
        List<String> strings = List.of(input.split("", ALL));
        return new InputString(strings);
    }

    private static void validate(String input) throws IllegalArgumentException {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_STRING.getMessage());
        }
        if (!input.matches("^(//\\.\\n)*([:,]*\\d*)+$")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_STRING.getMessage());
        }
    }
}
