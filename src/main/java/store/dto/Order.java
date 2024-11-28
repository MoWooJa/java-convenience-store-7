package store.dto;

public class Order {

    private String orderName;
    private int orderAmount;

    public Order(String orderName, int orderAmount) {
        this.orderName = orderName;
        this.orderAmount = orderAmount;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }
}
