package store.model.product;

import java.util.List;
import java.util.Map;
import store.model.promotion.Promotion;

public class ProductFactory {

    public static final String SEPARATOR = ",";
    public static final String NO_PROMOTION = "null";

    private ProductFactory() {
    }

    public static Product createProduct(String productData, Map<String, Promotion> promotions) {
        List<String> productInfo = List.of(productData.split(SEPARATOR));
        String promotionName = productInfo.getLast();
        if (isPromotionProduct(promotionName)) {
            return PromotionProduct.of(productInfo, promotions.get(promotionName));
        }
        return NormalProduct.of(productInfo);
    }

    private static boolean isPromotionProduct(String promotionName) {
        return !promotionName.equals(NO_PROMOTION);
    }
}
