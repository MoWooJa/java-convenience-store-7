package store;

import static store.Exceptions.INVALID_FORMAT;

import java.util.ArrayList;
import java.util.List;
import store.order.OrderRequestDto;

public class InputParser {

    public static List<OrderRequestDto> parseOrders(String input) {
        String[] orders = input.split(",");
        List<OrderRequestDto> orderRequests = new ArrayList<>();

        for (String order : orders) {
            String[] split = order.split("-");

            if (split.length != 2) {
                throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
            }

            String name = split[0];
            Integer quantity = toInteger(split[1]);

            orderRequests.add(OrderRequestDto.of(name, quantity));
        }
        return orderRequests;
    }

    public static Integer toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }
    }
}
