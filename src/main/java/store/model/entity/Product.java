package store.model.entity;

import store.model.vo.ProductQuantity;

public class Product {
    private final String name;
    private final int price;
    private final ProductQuantity quntity;
    private final Promotion promotion;

    public Product(String name, int price, ProductQuantity quntity, Promotion promotion) {
        this.name = name;
        this.price = price;
        this.quntity = quntity;
        this.promotion = promotion;
    }

    public String getName() {
        return name;
    }
}
