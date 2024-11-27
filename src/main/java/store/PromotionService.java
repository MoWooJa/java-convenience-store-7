package store;

public class PromotionService {
    private final PromotionRepository promotionRepository;

    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public Integer calculateMiss(Promotion promotion, Integer quantity) {
        Integer buy = promotion.getBuy();
        Integer get = promotion.getGet();
        Integer group = buy + get;

        if (quantity % group == promotion.getBuy()) {
            return 1;
        }
        return 0;
    }
}
