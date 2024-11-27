package store;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final StockService stockService;

    private final ProductService productService;

    public OrderService(StockService stockService, ProductService productService) {
        this.stockService = stockService;
        this.productService = productService;
    }

    public List<Order> createOrder(List<OrderRequestDto> orderRequests) {
        List<Order> orders = new ArrayList<>();
        for (OrderRequestDto orderRequest : orderRequests) {
            Product product = productService.findProductByName(orderRequest.name());
            stockService.compareWithTotal(product, orderRequest.quantity());

            orders.add(new Order(product, orderRequest.quantity()));
        }
        return orders;
    }
}
