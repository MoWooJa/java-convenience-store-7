package store.model.product;

import java.util.List;
import store.model.promotion.Promotion;

public class PromotionProduct implements Product {

    public static final String DELIMITER = ",";
    private final String name;
    private final int price;
    private final int quantity;
    private final Promotion promotion;

    public PromotionProduct(String name, int price, int quantity, Promotion promotion) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.promotion = promotion;
    }

    public static PromotionProduct of(List<String> productInfo, Promotion promotion) {
        String name = productInfo.get(0);
        int price = Integer.parseInt(productInfo.get(1));
        int quantity = Integer.parseInt(productInfo.get(2));
        return new PromotionProduct(name, price, quantity, promotion);
    }

    @Override
    public String getInfo() {
        return String.join(DELIMITER, name, Integer.toString(price),
                Integer.toString(quantity), promotion.getPromotionName());
    }

    @Override
    public int reduceOrderAmount(int orderAmount) {
        return orderAmount - quantity;
    }
}
