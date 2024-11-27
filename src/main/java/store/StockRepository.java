package store;

import static store.Exceptions.NO_PRODUCT;

import java.util.List;
import store.product.Product;

public class StockRepository {

    private final List<Stock> stocks;

    public StockRepository(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public Stock findByProduct(Product product) {
        return stocks.stream()
                .filter(stock -> stock.getProduct().equals(product))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_PRODUCT.getMessage()));
    }
}
