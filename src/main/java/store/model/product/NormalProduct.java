package store.model.product;

import java.util.List;

public class NormalProduct implements Product {

    public static final String DELIMITER = ",";
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

    @Override
    public String getInfo() {
        return String.join(DELIMITER, name, Integer.toString(price), Integer.toString(quantity), "null");
    }

    @Override
    public int reduceOrderAmount(int orderAmount) {
        return orderAmount - quantity;
    }
}
