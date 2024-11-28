package store.model.product;

import java.util.Arrays;
import java.util.List;

public class Products {

    private static final int PROMOTION_PRODUCT_INDEX = 0;
    private static final int NORMAL_PRODUCT_INDEX = 1;

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
}
