package store.product;

import store.PromotionService;
import store.StockService;
import store.product.Product;
import store.product.ProductRepository;

public class ProductService {
    private final ProductRepository productRepository;
    private final StockService stockService;
    private final PromotionService promotionService;

    public ProductService(ProductRepository productRepository, StockService stockService,
                          PromotionService promotionService) {
        this.productRepository = productRepository;
        this.stockService = stockService;
        this.promotionService = promotionService;
    }

    public Product findProductByName(String name) {
        return productRepository.findByName(name);
    }

    public Integer calculateMissedPromotion(Product product, Integer quantity) {
        if (!product.isInPromotion()) {
            return 0;
        }
        Integer missItems = promotionService.calculateMiss(product.getPromotion(), quantity);
        return stockService.compareWithPromotionStock(product, missItems);
    }

    public Integer calculateIgnoredPromotion(Product product, Integer quantity) {
        if (!product.isInPromotion()) {
            return 0;
        }
        return stockService.compareWithPromotionStock(product, quantity);
    }
}
