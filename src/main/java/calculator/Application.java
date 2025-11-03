package calculator;

import calculator.controller.CalculatorController;
import calculator.controller.CalculatorControllerFactory;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("//\\n12+1 = " + "//\n12+1");

        CalculatorControllerFactory factory = new CalculatorControllerFactory();
        CalculatorController calculatorController = factory.calculatorController();
        calculatorController.run();
    }
}
