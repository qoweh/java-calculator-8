package calculator;

import calculator.config.AppConfig;
import calculator.controller.CalculatorController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        CalculatorController calculatorController = appConfig.calculatorController();
        calculatorController.run();
    }
}
