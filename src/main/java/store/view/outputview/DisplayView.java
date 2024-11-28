package store.view.outputview;

import java.util.List;
import store.dto.DisplayInfo;

public class DisplayView implements OutputView {

    private static final String WELCOME_MESSAGE = "안녕하세요. W편의점입니다." + System.lineSeparator()
            + "현재 보유하고 있는 상품입니다.";
    private static final String PROMOTION_DISPLAY_FORMAT = "- %s %,d원 %,d개 %s";
    private static final String NORMAL_DISPLAY_FORMAT = "- %s %,d원 %,d개";
    private static final String NO_PRODUCT_DISPLAY_FORMAT = "- %s %,d원 재고 없음";
    public static final String SEPARATOR = ",";

    private void showProductDisplay(List<DisplayInfo> displayInfos) {
        for (DisplayInfo displayInfo : displayInfos) {
            String promotionProductInfo = displayInfo.getPromotionProductInfo();
            String normalProductInfo = displayInfo.getNormalProductInfo();
            displayPromotionProduct(promotionProductInfo, normalProductInfo);
            displayNormalProduct(normalProductInfo);
        }
        System.out.println();
    }

    private static void displayNormalProduct(String normalProductInfo) {
        if (normalProductInfo != null) {
            String name = normalProductInfo.split(SEPARATOR)[0];
            int price = Integer.parseInt(normalProductInfo.split(SEPARATOR)[1]);
            int quantity = Integer.parseInt(normalProductInfo.split(SEPARATOR)[2]);
            System.out.println(String.format(NORMAL_DISPLAY_FORMAT, name, price, quantity));
        }
    }

    private static void displayPromotionProduct(String promotionProductInfo, String normalProductInfo) {
        if (promotionProductInfo != null) {
            String name = promotionProductInfo.split(SEPARATOR)[0];
            int price = Integer.parseInt(promotionProductInfo.split(SEPARATOR)[1]);
            int quantity = Integer.parseInt(promotionProductInfo.split(SEPARATOR)[2]);
            String promotionName = promotionProductInfo.split(SEPARATOR)[3];
            System.out.println(String.format(PROMOTION_DISPLAY_FORMAT, name, price, quantity, promotionName));
            if (normalProductInfo == null) {
                System.out.println(String.format(NO_PRODUCT_DISPLAY_FORMAT, name, price));
            }
        }
    }

    @Override
    public void display(Object object) {
        List<DisplayInfo> displayInfos = (List<DisplayInfo>) object;
        System.out.println(WELCOME_MESSAGE);
        System.out.println();
        showProductDisplay(displayInfos);
    }
}
