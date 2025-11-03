package calculator;

public enum ErrorMessage {
    EMPTY_STRING("빈 문자열입니다."),
    INVALID_STRING("적절하지 않은 형태의 문자열입니다."),
    MESSAGE("");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
