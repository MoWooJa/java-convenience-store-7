package store.model.vo;

public class ProductQuantity {
    private int generalQuantity = 0;
    private int promotionalQuantity = 0;

    public void updateGeneralQuantity(int generalQuantity) {
        this.generalQuantity = generalQuantity;
    }

    public void updatePromotionalQuantity(int promotionalQuantity) {
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
