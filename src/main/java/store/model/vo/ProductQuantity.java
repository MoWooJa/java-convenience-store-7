package store.model.vo;

public class ProductQuantity {
    private int generalQuantity;
    private int promotionalQuantity;

    public ProductQuantity(int generalQuantity, int promotionalQuantity) {
        this.generalQuantity = generalQuantity;
        this.promotionalQuantity = promotionalQuantity;
    }

    public boolean isEnoughGeneralQuantity(int quantity) {
        return quantity <= generalQuantity;
    }

    public boolean isEnoughPromotionalQuantity(int quantity) {
        return quantity <= promotionalQuantity;
    }

    public boolean isEnoughTotalQuantity(int quantity) {
        return quantity <= generalQuantity + promotionalQuantity;
    }

    public void orderCompleteGeneralQuantity(int quantity) {
        this.generalQuantity -= quantity;
    }

    public void orderCompletePromotionalQuantity(int quantity) {
        this.promotionalQuantity -= quantity;
    }
}
