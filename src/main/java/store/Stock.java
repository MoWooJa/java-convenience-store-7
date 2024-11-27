package store;

import static store.Exceptions.NOT_ENOUGH_STOCK;

public class Stock {
    private final Product product;

    int promotion;

    int general;

    int total;

    public Stock(Product product, int promotion, int general) {
        this.product = product;
        this.promotion = promotion;
        this.general = general;
        this.total = promotion + general;
    }

    public Product getProduct() {
        return product;
    }

    public void compareWithQuantity(int quantity) {
        if (quantity > total) {
            throw new IllegalArgumentException(NOT_ENOUGH_STOCK.getMessage());
        }
    }
}
