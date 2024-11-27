package store;

public class OrderRecord {
    private String productName;
    private int decrementRegularQuantity;
    private int decrementPromotionQuantity;
    private int freeItemCount;

    public OrderRecord(String productName, int decrementRegularQuantity, int decrementPromotionQuantity, int freeItemCount) {
        this.productName = productName;
        this.decrementRegularQuantity = decrementRegularQuantity;
        this.decrementPromotionQuantity = decrementPromotionQuantity;
        this.freeItemCount = freeItemCount;
    }
}
