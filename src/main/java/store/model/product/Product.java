package store.model.product;

public interface Product {
    String getInfo();

    int reduceOrderAmount(int orderAmount);
}
