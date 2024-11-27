package store;

import java.util.List;
import java.util.Map;

public class Products {
    Map<String,Product> products;

    public Products(Map<String,Product> products) {
        this.products = products;
    }

    public void printAllProducts() {

    }

    public Map<String,Product> getProducts() {
        return products;
    }

    public Receipt buyProductsIfYouCan(List<OrderItem> orderItems) {
        for (OrderItem orderItem : orderItems) {
            Product findProduct = findProduct(orderItem.getItemName());
            findProduct.canBuyProduct(orderItem.getQuantity());
        }

        //throw가 안된 경우(재고 초과가 없는 정상 케이스)
        Receipt Receipt = new Receipt();

        for (OrderItem orderItem : orderItems) {
            Product findProduct = findProduct(orderItem.getItemName());
            findProduct.decrementRegularQuantity(orderItem.getQuantity());

            //필수로 고쳐야 함
            //필수로 고쳐야 함
            OrderRecord orderRecord = new OrderRecord(
                    orderItem.getItemName(),
                    findProduct.getPrice(),
                    orderItem.getQuantity(),
                    0,
                    0
            );
            //필수로 고쳐야 함
            //필수로 고쳐야 함
            Receipt.addRecord(orderRecord);
        }
        return Receipt;
    }

    private Product findProduct(String productName) {
        for (Map.Entry<String, Product> entry : products.entrySet()) {
            if (entry.getKey().equals(productName)) {
                return entry.getValue();
            }
        }
        throw new IllegalArgumentException("ERROR : 없는 상품입니다.");
    }
}
