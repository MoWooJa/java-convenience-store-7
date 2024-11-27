package store;

public class Order {
    private final Product product;
    private final Integer quantity;

    public Order(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
