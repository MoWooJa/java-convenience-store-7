package store.model.Factory;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import store.model.arigation.Inventory;
import store.model.arigation.PromotionCatalog;
import store.model.entity.Product;
import store.model.entity.Promotion;
import store.model.vo.ProductQuantity;
import store.util.FileReader;
import store.util.FileType;

public class InventoryFactory {
    private static final String DELIMITER = ",";
    private static final int INDEX_OF_PRODUCT_NAME = 0;
    private static final int INDEX_OF_PRODUCT_PRICE = 1;
    private static final int INDEX_OF_PRODUCT_QUANTITY = 2;
    private static final int INDEX_OF_PRODUCT_PROMOTION = 3;

    private final FileReader fileReader;
    private final PromotionCatalog catalog;
    private List<String> fileContents;
    private final Map<String, ProductQuantity> productQuantities;

    public InventoryFactory(FileReader fileReader, PromotionCatalog promotionCatalog) {
        this.fileReader = fileReader;
        this.catalog = promotionCatalog;
        productQuantities = new HashMap<>();
    }

    private void setUp() throws FileNotFoundException {
        fileContents = fileReader.read(FileType.PRODUCTS_FILE_PATH);
    }

    private Inventory create() throws FileNotFoundException {
        setUp();
        List<Product> products = new ArrayList<>();
        for (String productInfo : fileContents) {
            List<String> elements = getSplit(productInfo);
            String productName = elements.get(INDEX_OF_PRODUCT_NAME);
            int price = parsePrice(elements);
            int quantity = parseQuantity(elements);
            ProductQuantity productQuantity = new ProductQuantity();
            String promotionName = elements.get(INDEX_OF_PRODUCT_PROMOTION);
            if (promotionName != null) {
                productQuantities.put(productName, productQuantity);
                productQuantity.updatePromotionalQuantity(quantity);
                Promotion promotion = catalog.getByPromotionName(promotionName);
                products.add(new Product(productName, price, productQuantity, promotion));
            }
            if (promotionName == null) {
                productQuantity.updateGeneralQuantity(quantity);
                if(productQuantities.containsKey(productName)) {
                    productQuantities.get(productName).updateGeneralQuantity(quantity);
                }
                if (!productQuantities.containsKey(productName)) {
                    products.add(new Product(productName, price, productQuantity, ));
                }
            }
        }

    }


    private static int parseQuantity(List<String> elements) {
        return Integer.parseInt(elements.get(INDEX_OF_PRODUCT_QUANTITY));
    }

    private static int parsePrice(List<String> elements) {
        return Integer.parseInt(elements.get(INDEX_OF_PRODUCT_PRICE));
    }

    private static List<String> getSplit(String target) {
        return List.of(target.split(DELIMITER));
    }

//    name,price,quantity,promotion
//    콜라,1000,10,탄산2+1
//    콜라,1000,10,null
//    사이다,1000,8,탄산2+1
//    사이다,1000,7,null
//    오렌지주스,1800,9,MD추천상품
//    (오렌지주스,1800,0,null)
//    탄산수,1200,5,탄산2+1
//    (탄산수,1200,0,null)
//    물,500,10,null
//    비타민워터,1500,6,null
//    감자칩,1500,5,반짝할인
//    감자칩,1500,5,null
//    초코바,1200,5,MD추천상품
//    초코바,1200,5,null
//    에너지바,2000,5,null
//    정식도시락,6400,8,null
//    컵라면,1700,1,MD추천상품
//    컵라면,1700,10,null
}
