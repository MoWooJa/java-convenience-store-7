package store;

import java.util.List;
import store.order.Order;
import store.order.OrderController;
import store.product.ProductController;

public class MainController {
    private final OrderController orderController;

    private final ProductController productController;

    public MainController(OrderController orderController, ProductController productController) {
        this.orderController = orderController;
        this.productController = productController;
    }

    public void run() {
        List<Order> orders = orderController.createOrder();

    }
}
