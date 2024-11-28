package store.model.Factory;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import store.model.arigation.PromotionCatalog;
import store.model.entity.Promotion;
import store.model.type.PromotionType;
import store.model.vo.PromotionPeriod;
import store.util.FileReader;
import store.util.FileType;

public class PromotionCatologFactory {
    private static final String DELIMITER = ",";
    public static final int INDEX_OF_PROMOTION_NAME = 0;
    public static final int INDEX_OF_BUY_CONDITION = 1;
    public static final int INDEX_OF_START_DATE = 3;
    public static final int INDEX_OF_END_DATE = 4;
    private final FileReader fileReader;
    private List<String> fileContents;
    private PromotionCatalog catalog;

    public PromotionCatologFactory(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public PromotionCatalog create() throws FileNotFoundException {
        setUp();
        List<Promotion> promotions = new ArrayList<>();
        for (String promotionInformation : fileContents) {
            splitAndCreatePromotion(promotionInformation, promotions);
        }
        catalog = new PromotionCatalog(promotions);
        return catalog;
    }

    private void splitAndCreatePromotion(String promotionInformation, List<Promotion> promotions) {
        List<String> elements = getSplit(promotionInformation);
        String name = elements.get(INDEX_OF_PROMOTION_NAME);
        PromotionType type = PromotionType.getByBuy(elements.get(INDEX_OF_BUY_CONDITION));
        PromotionPeriod period = promotionPeriodFactory(elements);
        Promotion promotion = new Promotion(name, type, period);
        promotions.add(promotion);
    }

    private static PromotionPeriod promotionPeriodFactory(List<String> elements) {
        return new PromotionPeriod(
                elements.get(INDEX_OF_START_DATE),
                elements.get(INDEX_OF_END_DATE));
    }

    private void setUp() throws FileNotFoundException {
        fileContents = fileReader.read(FileType.PROMOTIONS_FILE_PATH);
    }

    private List<String> getSplit(String productInfo) {
        return List.of(productInfo.split(DELIMITER));
    }
}
