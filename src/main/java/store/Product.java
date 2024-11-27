package store;

public class Product {
    private String name;
    private int price;
    private int regularQuantity;
    private int promotionQuantity;
    private String promotionName;


    public boolean canBuyProduct(int quantity) {
        //일반 재고를 기준으로 재고 초과인지 체크
        if (quantity > regularQuantity) {
            throw new IllegalArgumentException("재고 초과 구매 X");
        }
        //프로모션 기간이면..?
        return Boolean.TRUE;
    }
//    public Product buyProduct(int quantity) {
//        if (canBuyProduct(quantity)) {
//            regularQuantity -= quantity;
//        }
//        return this;
//    }
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getRegularQuantity() {
        return regularQuantity;
    }

    public int getPromotionQuantity() {
        return promotionQuantity;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void incrementRegularStock(int quantity) {
        regularQuantity += quantity;
    }

    public void incrementPromotionStock(int quantity) {
        promotionQuantity += quantity;
    }

    public Product(String name, int price, int regularQuantity, int promotionQuantity, String promotionName) {
        this.name = name;
        this.price = price;
        this.regularQuantity = regularQuantity;
        this.promotionQuantity = promotionQuantity;
        this.promotionName = promotionName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", regularQuantity=" + regularQuantity +
                ", promotionQuantity=" + promotionQuantity +
                ", promotionName='" + promotionName + '\'' +
                '}';
    }
}
