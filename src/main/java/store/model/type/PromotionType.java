package store.model.type;

import store.util.DateParser;

public enum PromotionType {
    BUY_ONE_GET_ONE(1, 1),
    BUY_TWO_GET_ONE(2, 1);

    private final int buyCondition;
    private final int freePresentQuntity;

    PromotionType(int buyCondition, int freePresentQuntity) {
        this.buyCondition = buyCondition;
        this.freePresentQuntity = freePresentQuntity;
    }


    public static PromotionType getByBuy(String buy) {
        if (BUY_ONE_GET_ONE.buyCondition().equals(buy)) {
            return BUY_ONE_GET_ONE;
        }
        if (BUY_TWO_GET_ONE.buyCondition().equals(buy)) {
            return BUY_TWO_GET_ONE;
        }
        return null;
    }

    private String buyCondition() {
        return String.valueOf(buyCondition);
    }
    // todd : 프로모션 수량 기준 검증 로직 추가
}
