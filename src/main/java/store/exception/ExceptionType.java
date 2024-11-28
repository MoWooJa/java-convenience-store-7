package store.exception;

public enum ExceptionType {

    INVALID_FORMAT_EXCEPTION("[ERROR] 올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요."),
    NO_PRODUCT_EXCEPTION("[ERROR] 존재하지 않는 상품입니다. 다시 입력해 주세요."),
    NO_STOCK_EXCEPTION("[ERROR] 재고 수량을 초과하여 구매할 수 없습니다. 다시 입력해 주세요."),
    OTHER_EXCEPTION("[ERROR] 잘못된 입력입니다. 다시 입력해 주세요.");

    private final String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}