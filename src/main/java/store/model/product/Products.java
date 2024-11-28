package store.model.product;

import java.util.Arrays;
import java.util.List;
import store.dto.DisplayInfo;

public class Products {

    private static final int PROMOTION_PRODUCT_INDEX = 0;
    private static final int NORMAL_PRODUCT_INDEX = 1;
    public static final String SEPARATOR = ",";

    private final List<Product> products;

    public Products(List<Product> products) {
        this.products = products;
    }

    public static Products inIt(Product product) {
        List<Product> products = Arrays.asList(null, null);
        products.set(getIndexOf(product), product);
        return new Products(products);
    }

    public void add(Product product) {
        products.set(getIndexOf(product), product);
    }

    private static int getIndexOf(Product product) {
        if (product instanceof PromotionProduct) {
            return PROMOTION_PRODUCT_INDEX;
        }
        return NORMAL_PRODUCT_INDEX;
    }

    public DisplayInfo getDisplayInfo() {
        if (isOnlyNormal()) {
            return new DisplayInfo(products.get(NORMAL_PRODUCT_INDEX).getInfo(), null);
        }
        if (isOnlyPromotion()) {
            return new DisplayInfo(null, products.get(PROMOTION_PRODUCT_INDEX).getInfo());
        }
        return new DisplayInfo(products.get(NORMAL_PRODUCT_INDEX).getInfo(),
                products.get(PROMOTION_PRODUCT_INDEX).getInfo());
    }

    private boolean isOnlyNormal() {
        return products.get(PROMOTION_PRODUCT_INDEX) == null;
    }

    private boolean isOnlyPromotion() {
        return products.get(NORMAL_PRODUCT_INDEX) == null;
    }
}
