package store;

public class OrderRecord {
    private String productName;
    private int productPrice;
    private int decrementRegularQuantity;
    private int decrementPromotionQuantity;
    private int freeItemCount;

    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public int getDecrementRegularQuantity() {
        return decrementRegularQuantity;
    }

    public int getDecrementPromotionQuantity() {
        return decrementPromotionQuantity;
    }

    public int getFreeItemCount() {
        return freeItemCount;
    }

    public StringBuilder displayFreeItem(StringBuilder builder) {
        if (freeItemCount >= 0) {
            builder.append(getProductName())
                    .append(" ")
                    .append(freeItemCount)
                    .append("\n");
        }
        return builder;
    }

    public OrderRecord(String productName, int productPrice, int decrementRegularQuantity, int decrementPromotionQuantity, int freeItemCount) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.decrementRegularQuantity = decrementRegularQuantity;
        this.decrementPromotionQuantity = decrementPromotionQuantity;
        this.freeItemCount = freeItemCount;
    }

    public int calculateTotalSingleOrderPrice() {
        return (decrementPromotionQuantity+decrementRegularQuantity) * productPrice;
    }
    public int calculateSinglePromotionDiscount() {
        return (freeItemCount*productPrice);
    }
    public int calculateTotalNonPromotionPrice() {
        return ((decrementRegularQuantity+decrementPromotionQuantity-freeItemCount)*productPrice);
    }

    public int calculateTotalQuantity() {
        return decrementRegularQuantity+decrementPromotionQuantity;
    }
}
