package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String inputString = Console.readLine();
        Console.close();

        Calculator calculator = new Calculator();
        long answer = calculator.work(inputString);
        System.out.println("결과 : " + answer);
    }
}
