package calculator.view;

public class OutputView {
    private static final String NOTIFY_MESSAGE = "결과 : ";

    public static void print(int result) {
        System.out.println(NOTIFY_MESSAGE + result);
    }
}
