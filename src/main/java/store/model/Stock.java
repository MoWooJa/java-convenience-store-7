package store.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import store.model.product.Product;
import store.model.product.ProductFactory;
import store.model.product.Products;
import store.model.promotion.Promotion;

public class Stock {

    public static final String SEPARATOR = ",";

    private Map<String, Products> stock;

    public Stock(Map<String, Products> stock) {
        this.stock = stock;
    }

    public static Stock from(List<String> productsData, Map<String, Promotion> promotions) {
        Map<String, Products> stock = new HashMap<>();
        for (String productData : productsData) {
            List<String> productInfo = List.of(productData.split(SEPARATOR));
            String productName = productInfo.getFirst();
            Product product = ProductFactory.createProduct(productData, promotions);
            putProduct(stock, productName, product);
        }
        return new Stock(stock);
    }

    private static void putProduct(Map<String, Products> stock, String productName, Product product) {
        if (stock.containsKey(productName)) {
            stock.get(productName).add(product);
        }
        stock.put(productName, Products.inIt(product));
    }
}
