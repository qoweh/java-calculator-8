package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String NOTIFY_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public static String read() {
        System.out.println(NOTIFY_MESSAGE);

        String line = Console.readLine();
        Console.close();

        return line;
    }
}
