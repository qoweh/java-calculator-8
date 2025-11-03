package calculator.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.ErrorMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputStringTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n"})
    void 빈_문자열_입력(String input) {
        assertSimpleTest(() ->
                // when
                assertThatThrownBy(() -> InputString.from(input))

                        // then
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.EMPTY_STRING.getMessage())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"//\\n12+1", " 12", ",,,1,2:4 "})
    void 올바르지_않은_문자열_입력(String input) {
        assertSimpleTest(() ->
                // when
                assertThatThrownBy(() -> InputString.from(input))

                        // then
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_STRING.getMessage())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"//1\\n12+1", "12", "1,2:4", ",,,1,2:4"})
    void 올바른_문자열_입력(String input) {
        assertSimpleTest(() ->
                // when
                assertThatCode(() -> InputString.from(input))

                        // then
                        .doesNotThrowAnyException()
        );
    }

}