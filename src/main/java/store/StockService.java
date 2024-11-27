package store;

public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public void compareWithTotal(Product product, Integer quantity) {
        Stock stock = stockRepository.findByProduct(product);
        stock.compareWithQuantity(quantity);
    }
}
