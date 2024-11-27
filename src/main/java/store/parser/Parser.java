package store.parser;

import store.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<OrderItem> parse(String input) {
        List<OrderItem> orderItems = new ArrayList<>();
        try {
            String[] split = input.split("],\\[");


            for (String s : split) {
                String cleaned = s.replace("[", "").replace("]", "");
                String[] parts = cleaned.split("-");

                String itemName = parts[0];
                int quantity = Integer.parseInt(parts[1]);

                orderItems.add(new OrderItem(itemName, quantity));

            }
        } catch (Exception e) {
            throw new IllegalArgumentException("ERROR 올바른 형식으로 입력바람");
        }


        return orderItems;
    }
}
