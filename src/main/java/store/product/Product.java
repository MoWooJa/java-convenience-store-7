package store.product;

import store.Promotion;
import store.Stock;

public class Product {
    private final String name;
    private final Stock stock;
    private final Promotion promotion;
    private final Integer price;

    public Product(String name, Stock stock, Promotion promotion, Integer price) {
        this.name = name;
        this.stock = stock;
        this.promotion = promotion;
        this.price = price;
    }

    public boolean isInPromotion() {
        if (promotion == null) {
            return false;
        }
        return promotion.isInPromotion();
    }

    public String getName() {
        return name;
    }

    public Stock getStock() {
        return stock;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public Integer getPrice() {
        return price;
    }
}
