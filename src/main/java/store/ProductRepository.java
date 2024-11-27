package store;

import static store.Exceptions.NO_PRODUCT;

import java.util.List;

public class ProductRepository {

    private final List<Product> products;

    public ProductRepository(List<Product> products) {
        this.products = products;
    }

    public Product findByName(String name) {
        return products.stream()
                .filter(product -> product.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_PRODUCT.getMessage()));
    }
}
