package calculator.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.ErrorMessage;
import org.assertj.core.api.Assertions;
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
    @ValueSource(strings = {"//\\n12+1", " 12", ",,,1,2:4 ", "-1"})
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
    @ValueSource(strings = {"//1\\n12,1", "0", "12", "1,2:4", ",,,1,2:4", "123,12,121", "//!\\n//@\\n!1@@2,3:4,,"})
    void 올바른_문자열_입력(String input) {
        assertSimpleTest(() ->
                // when
                assertThatCode(() -> InputString.from(input))

                        // then
                        .doesNotThrowAnyException()
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,,", "1,,:2::3,4,,", "//!\\n!1!2,3:4,,", "//!\\n//@\\n!1@@2,3:4,,"})
    void 적절하게_파싱_하는지(String input) {
        // when
        InputString inputString = InputString.from(input);

        // then
        Assertions.assertThat(inputString.getSlicedInput()).containsExactly("1", "2", "3", "4");
    }

}