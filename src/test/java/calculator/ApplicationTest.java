package calculator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class ApplicationTest {
    Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvSource({
            "'', 0",
            "',,,,::::', 0",
            "'1,', 1",
            "',1', 1",
            "',1,', 1",
            "'1', 1",
            "'1,2:3', 6",
            "'1,2,3,4,5', 15",
            "'1,2,:::,,,3,,,,,4,5', 15",
            "'//3\\n1,2:32,4', 9",
            "'//%\\n//$\\n:1,2$3%4', 10",
            "'//%\\n:1,2:3%4', 10",
            "'//%\\n1,2:3%4', 10",
            "'9223372036854775807,0', 9223372036854775807",
    })
    void testSuccessData(String input, Long expected) {
        assertThat(calculator.work(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("fileTestData")
    void testLargeInput(String input, Long expected) {
        assertThat(calculator.work(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> fileTestData() throws IOException {
        String input = Files.readString(Paths.get("src/test/resources/large_test_case.txt"));
        return Stream.of(Arguments.of(input, 50005000L));
    }

    @ParameterizedTest
    @CsvSource({
            "'//%\\n1,2:3%4$'",
            "'/%\\n1,2:3%4$'",
            "'//\\n1,2:3%4$'",
            "'//%n1,2:3%4$'",
            "'//%\\1,2:3%4$'",
    })
    void testIllegalArgumentException(String input) {
        assertThatThrownBy(() -> calculator.work(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
