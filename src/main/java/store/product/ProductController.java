package store.product;

import store.InputView;
import store.UserResponse;

public class ProductController {
    private final ProductService productService;
    private final InputView inputView;

    public ProductController(ProductService productService, InputView inputView) {
        this.productService = productService;
        this.inputView = inputView;
    }

    public Integer checkMissed(Product product, Integer quantity) {

        Integer missed = productService.calculateMissedPromotion(product, quantity);

        if (missed == 0) {
            return quantity;
        }

        UserResponse response = inputView.askMissedItem(product, missed);
        if (response == UserResponse.NO) {
            return quantity;
        }
        return quantity + missed;
    }


    public Integer checkIgnored(Product product, Integer quantity) {
        Integer ignored = productService.calculateIgnoredPromotion(product, quantity);
        if (ignored == 0) {
            return quantity;
        }
        UserResponse response = inputView.askIgnoredItem(product, ignored);
        if (response == UserResponse.NO) {
            return quantity - ignored;
        }
        return quantity;
    }
}
