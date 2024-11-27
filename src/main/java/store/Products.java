package store;

import java.util.List;
import java.util.Map;

public class Products {
    Map<String, Product> products;

    public Products(Map<String, Product> products) {
        this.products = products;
    }

    public void printAllProducts() {

    }

    public Map<String, Product> getProducts() {
        return products;
    }

    public OrderRecord buyProductsIfYouCan(OrderItem orderItem, boolean promotionWithinDate,int groupSize) {
        Product findProduct = findProduct(orderItem.getItemName());
        //프로모션 기간이면?
        if (promotionWithinDate) {

            //(체크) 프로모션 기간인데 살 수 있는지?
            findProduct.canBuyProductIfPromotion(orderItem.getQuantity());
            //throw가 안된 경우(재고 초과가 없는 정상 케이스)
            findProduct.(orderItem.getQuantity());

            OrderRecord orderRecord = new OrderRecord(
                    orderItem.getItemName(),
                    findProduct.getPrice(),
                    orderItem.getQuantity(),
                    0,
                    0
            );
            return orderRecord;
        }

        //프로모션 기간이 아니면?

        //(체크) 프로모션 기간이 아닌데 살 수 있는지?
        findProduct.canBuyProductIfNonPromotion(orderItem.getQuantity());
        //throw가 안된 경우(재고 초과가 없는 정상 케이스)
        findProduct.decrementRegularQuantity(orderItem.getQuantity());

        OrderRecord orderRecord = new OrderRecord(
                orderItem.getItemName(),
                findProduct.getPrice(),
                orderItem.getQuantity(),
                0,
                0
        );
        return orderRecord;


    }



    public Product findProduct(String productName) {
        for (Map.Entry<String, Product> entry : products.entrySet()) {
            if (entry.getKey().equals(productName)) {
                return entry.getValue();
            }
        }
        throw new IllegalArgumentException("ERROR : 없는 상품입니다.");
    }
}
