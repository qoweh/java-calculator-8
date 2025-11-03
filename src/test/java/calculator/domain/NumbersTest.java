package calculator.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.ErrorMessage;
import java.util.List;
import org.junit.jupiter.api.Test;

class NumbersTest {
    @Test
    void 최댓값_넘는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    // given
                    List<String> strings = List.of("1000000000");

                    // when
                    Numbers.from(strings);
                })
                        // then
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.TOO_BIG.getMessage())
        );

    }

    @Test
    void 최댓값을_넘지_않는_경우() {
        assertSimpleTest(() ->
                assertThatCode(() -> {
                    // given
                    List<String> strings = List.of("100000000");

                    // when
                    Numbers.from(strings);
                })
                        // then
                        .doesNotThrowAnyException()
        );

    }

}