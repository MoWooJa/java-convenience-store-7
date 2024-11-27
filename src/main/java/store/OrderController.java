package store;

import java.util.List;
import java.util.function.Supplier;

public class OrderController {
    private final InputView inputView;
    private final OrderService orderService;

    public OrderController(InputView inputView, OrderService orderService) {
        this.inputView = inputView;
        this.orderService = orderService;
    }

    public void createOrder() {
        List<OrderRequestDto> orderRequests = inputView.buyProducts();
        List<Order> order = orderService.createOrder(orderRequests);
    }
}
