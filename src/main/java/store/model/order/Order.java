package store.model.order;

public class Order {

    private final String orderName;
    private final int orderAmount;

    public Order(String orderName, int orderAmount) {
        this.orderName = orderName;
        this.orderAmount = orderAmount;
    }
}
