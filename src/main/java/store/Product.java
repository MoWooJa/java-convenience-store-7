package store;

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
