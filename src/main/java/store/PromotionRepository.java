package store;

import static store.Exceptions.NO_PROMOTION;

import java.util.List;

public class PromotionRepository {

    private final List<Promotion> promotions;

    public PromotionRepository(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public Promotion findByName(String name) {
        return promotions.stream()
                .filter(promotion -> promotion.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_PROMOTION.getMessage()));
    }
}
