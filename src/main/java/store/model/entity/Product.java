package store.model.entity;

import store.model.vo.ProductQuantity;

public class Product {
    private final String name;
    private final ProductQuantity quntity;
    private final Promotion promotion;

    public Product(String name, ProductQuantity quntity, Promotion promotion) {
        this.name = name;
        this.quntity = quntity;
        this.promotion = promotion;
    }

    public String getName() {
        return name;
    }
}
