package store.view.inputview;

public class InputViewFactory {

    private InputViewFactory() {
    }

    public static InputView createInputViewTypeOf(InputViewType inputViewType) {
        if (inputViewType == InputViewType.PRODUCTS_REQUEST) {
            return new InputView(InputViewType.PRODUCTS_REQUEST.getMessage());
        }
        if (inputViewType == InputViewType.PART_NO_PROMOTION_ANNOUNCE) {
            return new InputView(InputViewType.PART_NO_PROMOTION_ANNOUNCE.getMessage());
        }
        if (inputViewType == InputViewType.PROMOTION_AVAILABLE_ANNOUNCE) {
            return new InputView(InputViewType.PROMOTION_AVAILABLE_ANNOUNCE.getMessage());
        }
        if (inputViewType == InputViewType.CONTINUE_REQUEST) {
            return new InputView(InputViewType.CONTINUE_REQUEST.getMessage());
        }
        return new InputView(InputViewType.MEMBERSHIP_REQUEST.getMessage());
    }
}
