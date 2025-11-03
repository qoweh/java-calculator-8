package calculator.domain;

import calculator.ErrorMessage;
import java.util.List;

public class InputString {
    private List<String> slicedInput;

    private InputString(List<String> slicedInput) {
        this.slicedInput = slicedInput;
    }

    public static InputString from(String input) throws IllegalArgumentException {
        validate(input);

        return new InputString(List.of(null));
    }

    private static void validate(String input) throws IllegalArgumentException {

        throw new IllegalArgumentException(ErrorMessage.EMPTY_STRING.getMessage());
    }
}
