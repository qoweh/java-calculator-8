package calculator.config;

import calculator.controller.CalculatorController;

public class AppConfig {
    public CalculatorController calculatorController() {

        return new CalculatorController();
    }
}
