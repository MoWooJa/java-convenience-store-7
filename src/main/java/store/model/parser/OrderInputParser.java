package store.model.parser;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import store.dto.Order;
import store.exception.ExceptionType;
import store.exception.InputException;

public class OrderInputParser {

    private static final String VALID_INPUT_REGEX = "[^가-힣0-9,\\-\\[\\]]";
    private static final String VALID_ORDER_FORMAT_REGEX = "[^가-힣0-9,\\-]";
    private static final String VALID_NAME_REGEX = "[^가-힣]";
    private static final String VALID_AMOUNT_REGEX = "[^0-9]";
    public static final String SEPARATOR = ",";
    public static final String ORDER_SEPARATOR = "-";

    public OrderInputParser(String input) {
    }

    private static void validateInValidCharacter(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            throw new InputException(ExceptionType.INVALID_FORMAT_EXCEPTION);
        }
    }

    public List<Order> parseOrders(String input) {
        validateInValidCharacter(input, VALID_INPUT_REGEX);
        return Arrays.stream(input.split(SEPARATOR))
                .peek(OrderInputParser::validateOrderInput)
                .map(OrderInputParser::parseOrder)
                .toList();
    }

    private static void validateOrderInput(String orderInput) {
        validateStartEndFormat(orderInput);
        orderInput = orderInput.substring(1, orderInput.length() - 1);
        validateInValidCharacter(orderInput, VALID_ORDER_FORMAT_REGEX);
        validateOrderFormat(orderInput);
    }

    private static void validateStartEndFormat(String orderInput) {
        if (!(orderInput.startsWith("[") && orderInput.endsWith("]"))) {
            throw new InputException(ExceptionType.INVALID_FORMAT_EXCEPTION);
        }
    }

    private static Order parseOrder(String orderInput) {
        String orderName = orderInput.split(ORDER_SEPARATOR)[0];
        int orderAmount = Integer.parseInt(orderInput.split(ORDER_SEPARATOR)[1]);
        return new Order(orderName, orderAmount);
    }

    private static void validateOrderFormat(String orderInput) {
        String[] orderSeparated = orderInput.split(ORDER_SEPARATOR);
        validateOrderFormatSize(orderSeparated);
        validateInValidCharacter(orderSeparated[0], VALID_NAME_REGEX);
        validateInValidCharacter(orderSeparated[1], VALID_AMOUNT_REGEX);
    }

    private static void validateOrderFormatSize(String[] orderSeparated) {
        if (orderSeparated.length != 2) {
            throw new InputException(ExceptionType.INVALID_FORMAT_EXCEPTION);
        }
    }
}
