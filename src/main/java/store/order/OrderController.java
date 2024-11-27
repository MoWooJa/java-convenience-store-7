package store.order;

import java.util.List;
import store.InputView;
import store.product.ProductController;

public class OrderController {
    private final OrderService orderService;
    private final InputView inputView;
    private final ProductController productController;

    public OrderController(OrderService orderService, InputView inputView) {
        this.orderService = orderService;
        this.inputView = inputView;
    }

    public List<Order> createOrder() {
        List<OrderRequestDto> orderRequests = inputView.buyProducts();
        return orderService.createOrder(orderRequests);
    }

    public List<OrderResult> applyPromotion(List<Order> orders) {
        for (Order order : orders) {
            Integer applyMissed = productController.checkMissed(order.getProduct(), order.getQuantity());
            Integer total = productController.checkIgnored(order.getProduct(), order.getQuantity() + applyMissed);
            Integer freeQuantity = productController.freeQuantity(order.getProduct(), total);
        }
    }
}
