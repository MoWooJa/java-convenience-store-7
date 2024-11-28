package store.service;

import java.util.List;
import store.domain.Product;

public class StoreService {

    public String createStoreList(List<Product> products) {
        StringBuilder sb = new StringBuilder();
        sb.append("안녕하세요. W편의점입니다.\n");
        sb.append("현재 보유하고 있는 상품입니다.\n\n");

        for (Product product : products) {
            boolean promotionOfProduct = checkPromotionOfProduct(product, products);
            sb.append(formatProductInfo(product, promotionOfProduct)).append("\n");
        }

        return sb.toString();
    }

    private String formatProductInfo(Product product, boolean promotionOfProduct) {
        String promotionStatus = product.getPromotion();
        // 프로모션이 없는 경우 처리
        if ("null".equals(promotionStatus) && !promotionOfProduct) {
            promotionStatus = "";
        }
        // 프로모션 재고는 있지만 일반 재고가 없는 경우 처리
        if (promotionOfProduct && "null".equals(promotionStatus)) {

        }
        return String.format("-%s %,d원 %d개 %s",
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                promotionStatus);
    }

    private boolean checkPromotionOfProduct(Product product, List<Product> products) {
        String productName = product.getName();
        int NonPromotionCount = 0;
        int PromotionCount = 0;

        for (Product checkProduct : products) {
            int checkCount = checkPromotionCount(productName, checkProduct);
            if (checkCount == 0) {
                NonPromotionCount++;
            }
            if (checkCount == 1) {
                PromotionCount++;
            }
        }

        // 일반 재고가 없고 프로모션 재고만 있는 경우
        if (NonPromotionCount == 0 && PromotionCount == 1) {
            return true;
        }
        return false;
    }

    private int checkPromotionCount(String productName, Product checkProduct) {
        if (productName.equals(checkProduct.getName())) {
            if ("null".equals(checkProduct.getPromotion()) || checkProduct.getPromotion() == null) {
                return 0; // 일반 재고
            }
            return 1; // 프로모션 재고
        }
        return 2; // 다른 상품
    }
}
