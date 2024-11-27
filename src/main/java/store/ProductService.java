package store;

public class ProductService {
    private final ProductRepository productRepository;
    private final StockService stockService;

    public ProductService(ProductRepository productRepository, StockService stockService) {
        this.productRepository = productRepository;
        this.stockService = stockService;
    }

    public Product findProductByName(String name) {
        return productRepository.findByName(name);
    }
}
