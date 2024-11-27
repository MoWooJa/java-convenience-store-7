package store.parser;

import store.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<OrderItem> parse(String input) {
        String[] split = input.split("],\\[");
        List<OrderItem> orderItems = new ArrayList<>();

        for (String s : split) {
            String cleaned = s.replace("[", "").replace("]", "");
            String[] parts = cleaned.split("-");

            String itemName = parts[0];
            int quantity = Integer.parseInt(parts[1]);

            orderItems.add(new OrderItem(itemName, quantity));
        }
        return orderItems;
    }
}
