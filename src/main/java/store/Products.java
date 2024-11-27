package store;

import java.util.List;
import java.util.Map;

public class Products {
    Map<String,Product> products;

    public Products(Map<String,Product> products) {
        this.products = products;
    }

    public void printAllProducts() {

    }

    public Map<String,Product> getProducts() {
        return products;
    }

//    public canBuyProducts(List<OrderItem> orderItems) {
//
//    }
}
