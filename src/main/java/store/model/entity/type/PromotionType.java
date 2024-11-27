package store.model.entity.type;

public enum PromotionType {
    BUY_ONE_GET_ONE(1,1),
    BUY_ONE_GET_TWO(2,1);

    private int buyCondition;
    private int freePresentQuntity;

    PromotionType(int buyCondition, int freePresentQuntity) {
        this.buyCondition = buyCondition;
        this.freePresentQuntity = freePresentQuntity;
    }

    // todd : 프로모션 수량 기준 검증 로직 추가
}
