package store.model.arigation;

import java.util.List;
import store.model.entity.Promotion;

public class PromotionCatalog {
    private final List<Promotion> promotions;

    public PromotionCatalog(List<Promotion> promotions) {
        this.promotions = promotions;
    }
}
