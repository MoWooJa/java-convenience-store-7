package store;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Receipt {
    List<OrderRecord> orderRecords;

    public Receipt() {
        orderRecords = new ArrayList<>();
    }

    public void addRecord(OrderRecord record) {
        orderRecords.add(record);
    }

    public int getTotalPrice() {
        return orderRecords.stream()
                .mapToInt(OrderRecord::calculateTotalSingleOrderPrice)
                .sum();
    }
    public int getTotalQuantity() {
        return orderRecords.stream()
                .mapToInt(OrderRecord::calculateTotalQuantity)
                .sum();
    }

    public int getTotalPromotionDiscount() {
        return orderRecords.stream()
                .mapToInt(OrderRecord::calculateSinglePromotionDiscount)
                .sum();
    }

    public int calculateMembershipDiscount(boolean isMembership) {
        int membershipDiscount = 0;
        if (isMembership) {
            int nonPromotionPrice = orderRecords.stream()
                    .mapToInt(OrderRecord::calculateTotalNonPromotionPrice)
                    .sum();
            if (nonPromotionPrice * 0.3 >= 8000) {
                membershipDiscount = 8000;
            }
            if (nonPromotionPrice * 0.3 < 8000) {
                membershipDiscount = (int) Math.round(nonPromotionPrice * 0.3);
            }
        }
        return membershipDiscount;
    }

    public int calculateFinalPayAmount(int totalPrice, int promotionPrice, int membershipDiscount) {
        return totalPrice - promotionPrice - membershipDiscount;
    }

    public String displayReceipt(int totalPrice, int promotionPrice, int membershipDiscount, int finalPayAmount, int totalQuantity) {
        StringBuilder receiptBuilder = new StringBuilder();
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);

        receiptBuilder.append("==============W 편의점 ==============\n");
        receiptBuilder.append("상품명\t\t\t\t수량\t\t금액\n");

        for (OrderRecord orderRecord : orderRecords) {
            receiptBuilder.append(orderRecord.getProductName())
                    .append("\t\t\t\t")
                    .append(orderRecord.calculateTotalQuantity())
                    .append("\t\t")
                    .append(numberFormat.format((orderRecord.calculateTotalSingleOrderPrice())))
                    .append("\n");

        }
        receiptBuilder.append("==============증 정==============\n");
        receiptBuilder.append("\n");

        for (OrderRecord orderRecord : orderRecords) {
            orderRecord.displayFreeItem(receiptBuilder);
        }
        receiptBuilder.append("\n");

        receiptBuilder.append("====================================\n");
        receiptBuilder.append("총구매액\t\t").append(totalQuantity).append("\t\t").append(numberFormat.format(totalPrice)).append("\n");
        receiptBuilder.append("행사할인\t\t-").append(numberFormat.format(promotionPrice)).append("\n");
        receiptBuilder.append("멤버십할인\t\t-").append(numberFormat.format(membershipDiscount)).append("\n");
        receiptBuilder.append("내실돈\t\t").append(numberFormat.format(finalPayAmount)).append("\n");
        receiptBuilder.append("====================================\n");

        return receiptBuilder.toString();
    }


}
