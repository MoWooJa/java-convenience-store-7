package store.model.product;

import java.util.List;

public class NormalProduct implements Product {

    private final String name;
    private final int price;
    private final int quantity;

    public NormalProduct(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static NormalProduct of(List<String> productInfo) {
        String name = productInfo.get(0);
        int price = Integer.parseInt(productInfo.get(1));
        int quantity = Integer.parseInt(productInfo.get(2));
        return new NormalProduct(name, price, quantity);
    }
}
