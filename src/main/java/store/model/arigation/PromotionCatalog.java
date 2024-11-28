package store.model.arigation;

import java.util.Collections;
import java.util.List;
import store.model.entity.Promotion;

public record PromotionCatalog(List<Promotion> promotions) {

    @Override
    public List<Promotion> promotions() {
        return Collections.unmodifiableList(promotions);
    }
}
