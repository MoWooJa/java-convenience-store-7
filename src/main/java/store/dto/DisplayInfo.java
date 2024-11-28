package store.dto;

public class DisplayInfo {

    private final String NormalProductInfo;
    private final String PromotionProductInfo;

    public DisplayInfo(String normalProductInfo, String promotionProductInfo) {
        NormalProductInfo = normalProductInfo;
        PromotionProductInfo = promotionProductInfo;
    }

    public String getNormalProductInfo() {
        return NormalProductInfo;
    }

    public String getPromotionProductInfo() {
        return PromotionProductInfo;
    }
}
