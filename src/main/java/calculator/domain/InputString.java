package calculator.domain;

import calculator.ErrorMessage;
import java.util.List;
import java.util.stream.Stream;

public class InputString {
    private static final int ALL = -1;
    private static final int TARGET = 2;
    private static final int BEGIN_INDEX = 5;
    private static final String DELIMITER_FORMAT = "^//(.)\\\\n.*$";
    private static final String DELIMITER = ":,";
    private static final String POSSIBLE_FORMAT_PREFIX = "^(//(.)\\\\n)*([";
    private static final String POSSIBLE_FORMAT_SUFFIX = "]*\\d*)+$";

    private final List<String> slicedInput;

    private InputString(List<String> slicedInput) {
        this.slicedInput = slicedInput;
    }

    public static InputString from(String input) throws IllegalArgumentException {
        String delimiter = makeDelimiter(input);
        validate(input, delimiter);
        List<String> strings = makeSlicedInput(input, delimiter);

        return new InputString(strings);
    }

    private static String makeDelimiter(String input) {
        String delimiter = DELIMITER;
        while (input.matches(DELIMITER_FORMAT)) {
            delimiter += String.valueOf(input.charAt(TARGET));
            input = input.substring(BEGIN_INDEX);
        }
        return delimiter;
    }

    private static void validate(String input, String delimiter) throws IllegalArgumentException {
        String possibleFormat = POSSIBLE_FORMAT_PREFIX + delimiter + POSSIBLE_FORMAT_SUFFIX;
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_STRING.getMessage());
        }
        if (!input.matches(possibleFormat)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_STRING.getMessage());
        }
    }

    private static List<String> makeSlicedInput(String input, String delimiter) {
        input = sliceDelimiters(input);

        List<String> strings = Stream
                .of(input.split("[" + delimiter + "]", ALL))
                .filter(s -> !s.isBlank())
                .toList();
        return strings;
    }

    private static String sliceDelimiters(String input) {
        while (input.matches(DELIMITER_FORMAT)) {
            input = input.substring(5);
        }
        return input;
    }

    public List<String> getSlicedInput() {
        return slicedInput;
    }
}
