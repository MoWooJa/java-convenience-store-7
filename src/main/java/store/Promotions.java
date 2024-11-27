package store;

import java.time.LocalDate;
import java.util.Map;

public class Promotions {
    Map<String, Promotion> promotions;

    public Promotions(Map<String, Promotion> promotions) {
        this.promotions = promotions;
    }

    Promotion findPromotion(String promotionName) {
        return promotions.get(promotionName);
    }

    public boolean isPromotionWithinDate(String promotionName, LocalDate currentDate) {
        Promotion foundPromotion = findPromotion(promotionName);
        if (foundPromotion == null){
            return false;
        }
        return foundPromotion.isPromotion(currentDate);
    }

    public int calculatePromotionGroupSize(String promotionName) {
        Promotion foundPromotion = findPromotion(promotionName);
        if (foundPromotion == null){
            return 0;
        }
        return foundPromotion.calculateGroupSize();
    }
}
