package store.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import store.model.promotion.Promotion;

public class Store {

    public static final String SEPARATOR = ",";

    private final Map<String, Promotion> promotions;
    private final Stock stock;

    public Store() {
        this.promotions = organizePromotions();
        this.stock = organizeStock();
    }

    public Stock organizeStock() {
        List<String> productsData = FileLoader.load(FileLoader.PRODUCTS_FILE);
        productsData.removeFirst();
        return Stock.from(productsData, promotions);
    }

    private Map<String, Promotion> organizePromotions() {
        List<String> promotionsData = FileLoader.load(FileLoader.PROMOTIONS_FILE);
        promotionsData.removeFirst();
        Map<String, Promotion> promotions = new HashMap<>();
        for (String promotionData : promotionsData) {
            List<String> promotionInformation = List.of(promotionData.split(SEPARATOR));
            promotions.put(promotionInformation.getFirst(), Promotion.of(promotionInformation));
        }
        return promotions;
    }

}
