package calculator;

public enum ErrorMessage {
    EMPTY_STRING("빈 문자열입니다."),
    INVALID_STRING("적절하지 않은 형태의 문자열입니다."),
    TOO_BIG("입력은 100_000_000(9자리, 1억)까지 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
