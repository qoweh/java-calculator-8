package calculator.domain;

import calculator.ErrorMessage;
import java.util.List;
import java.util.stream.Stream;

public class InputString {
    private static final int ALL = -1;
    private static final String DELIMITER_FORMAT = "^//(.)\\\\n.*$";
    private static final String DELIMITER = ":,";
    private static final String POSSIBLE_FORMAT_PREFIX = "^(//(.)\\\\n)*([";
    private static final String POSSIBLE_FORMAT_SUFFIX = "]*\\d*)+$";

    private final List<String> slicedInput;

    private InputString(List<String> slicedInput) {
        this.slicedInput = slicedInput;
    }

    public static InputString from(String input) throws IllegalArgumentException {
        validateFirst(input);
        String delimiter = makeDelimiter(input);
        validateSecond(input, delimiter);
        input = sliceDelimiters(input);

        List<String> strings = Stream
                .of(input.split("[" + delimiter + "]", ALL))
                .filter(s -> !s.isBlank())
                .toList();

        return new InputString(strings);
    }

    private static String makeDelimiter(String input) {
        String delimiter = DELIMITER;
        while (input.matches(DELIMITER_FORMAT)) {
            delimiter += String.valueOf(input.charAt(2));
            input = input.substring(5);
        }
        return delimiter;
    }

    private static void validateFirst(String input) throws IllegalArgumentException {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_STRING.getMessage());
        }
    }

    private static void validateSecond(String input, String delimiter) throws IllegalArgumentException {
        String possibleFormat = POSSIBLE_FORMAT_PREFIX + delimiter + POSSIBLE_FORMAT_SUFFIX;
        if (!input.matches(possibleFormat)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_STRING.getMessage());
        }
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
