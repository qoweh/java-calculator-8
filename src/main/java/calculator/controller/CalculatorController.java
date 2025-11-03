package calculator.controller;

import calculator.domain.InputString;
import calculator.domain.Numbers;
import calculator.view.InputView;
import calculator.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {
    public void run() {
        InputView.notifyStart();

        String input = Console.readLine();
        InputString inputString = InputString.from(input);
        Numbers numbers = Numbers.from(inputString.getSlicedInput());
        int result = makeResult(numbers);

        OutputView.result(result);
    }

    private int makeResult(Numbers numbers) {
        return numbers.calculateSum();
    }
}
