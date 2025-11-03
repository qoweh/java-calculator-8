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
        InputString inputString = makeValidInputString(input);
        Numbers numbers = makeNumbers(inputString);

        int result = makeResult(numbers);
    }

    private InputString makeValidInputString(String input) {
        InputString inputString = null;
        try {
            inputString = InputString.from(input);
        } catch (IllegalArgumentException e) {
            OutputView.error(e);
        }
        return inputString;
    }

    private Numbers makeNumbers(InputString inputString) {
        Numbers numbers = null;
        try {
            numbers = Numbers.from(inputString.getSlicedInput());
        } catch (IllegalArgumentException e) {
            OutputView.error(e);
        }
        return numbers;
    }

    private int makeResult(Numbers numbers) {
        return numbers.calculateSum();
    }
}
