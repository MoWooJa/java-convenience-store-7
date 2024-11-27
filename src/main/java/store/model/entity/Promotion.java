package store.model.entity;

import store.model.entity.type.PromotionType;
import store.model.entity.vo.PromotionPeriod;
import store.util.Date;

public class Promotion {
    private final String name;
    private final PromotionType type;
    private final PromotionPeriod period;

    public Promotion(String name, PromotionType promotionType,PromotionPeriod promotionPeriod) {
        this.name = name;
        this.type = promotionType;
        this.period = promotionPeriod;
    }

    public String getName() {
        return name;
    }

    public boolean isInPeriod(Date date) {
        return period.isInPromotionPeriod(date);
    }
}
