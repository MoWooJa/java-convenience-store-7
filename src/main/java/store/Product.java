package store;

public class Product {
    private String name;
    private int price;
    private int regularQuantity;
    private int promotionQuantity;
    private String promotionName;


    public void canBuyProductIfPromotion(int quantity) {
        //프로모션 기간이면..? 일단 두 개 더한 거보다 많으면 안됨
        if (quantity > promotionQuantity + regularQuantity) {
            throw new IllegalArgumentException("재고 초과 구매 X");
        }
    }

    public void canBuyProductIfNonPromotion(int quantity) {
        //일반 재고를 기준으로 재고 초과인지 체크
        if (quantity > regularQuantity) {
            throw new IllegalArgumentException("재고 초과 구매 X");
        }
    }

    //추가 필요
    public void decrementBothQuantityIfPromotion(int quantity, int groupSize) {
        int maxPromotionQuantity = (promotionQuantity / groupSize) * groupSize;
        int freeItemCount = (promotionQuantity / groupSize);
        //나머지는 일반 재고에서 처리해야 함
        int restQuantity = quantity - maxPromotionQuantity;


        if (regularQuantity >= restQuantity) {// 나머지가 일반재고에서 처리되면?
            regularQuantity -= restQuantity;
        } else {//나머지가 일반재고에서 처리가 안되면 프로모션에서 제거는 할 것이지만 돈은 내야 함
            //일반 재고까지 차감해도 남은 수(이건 프로모션에서 다시 뺄 거임)
            int afterRegularRestQuantity = restQuantity-regularQuantity;
            regularQuantity = 0;
            //이제는 일반재고 없으니 프로모션에서 뺌
            promotionQuantity -= afterRegularRestQuantity;
        }


    }

    public void decrementRegularQuantity(int quantity) {
        regularQuantity -= quantity;
    }

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
