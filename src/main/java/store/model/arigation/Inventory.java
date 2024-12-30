package store.model.arigation;

import java.util.List;
import store.model.entity.Product;

public class Inventory {
    private final List<Product> products;

    public Inventory(List<Product> products) {
        this.products = products;
    }


}
