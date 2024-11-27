package store.order;

import store.product.Product;

public class Order {
    private final Product product;
    private final Integer quantity;

    public Order(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
