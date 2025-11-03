package calculator.view;

public class OutputView {
    private static final String RESULT_MESSAGE = "결과 : ";

    public static void error(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void result(int result) {
        System.out.println(RESULT_MESSAGE + result);
    }
}
