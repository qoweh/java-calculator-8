package calculator.controller;

import calculator.domain.InputString;
import calculator.view.InputView;
import calculator.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {
    public void run() {
        InputView.notifyStart();

        String input = Console.readLine();
        InputString inputString = makeValidInputString(input);

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
}
