package calculator.view;

public class OutputView {
    public static void error(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
