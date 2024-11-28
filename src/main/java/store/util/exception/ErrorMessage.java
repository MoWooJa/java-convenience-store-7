package store.util.exception;

public enum ErrorMessage {
    NOT_FILE_FOUND("[ERROR] 파일을 찾을 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
