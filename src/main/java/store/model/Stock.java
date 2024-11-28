package store.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import store.dto.DisplayInfo;
import store.exception.ExceptionType;
import store.exception.InputException;
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
        Map<String, Products> stock = new LinkedHashMap<>();
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
        if (!stock.containsKey(productName)) {
            stock.put(productName, Products.inIt(product));
        }
    }

    public List<DisplayInfo> getDisplayProductsInfo() {
        List<DisplayInfo> displayInfos = new ArrayList<>();
        for (String productName : stock.keySet()) {
            displayInfos.add(stock.get(productName).getDisplayInfo());
        }
        return displayInfos;
    }

    public void checkName(String orderName) {
        if (!stock.containsKey(orderName)) {
            throw new InputException(ExceptionType.NO_PRODUCT_EXCEPTION);
        }
    }
}
