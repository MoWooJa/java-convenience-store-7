package store;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public List<OrderRequestDto> buyProducts() {
        System.out.println("구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])");
        // [콜라-3],[에너지바-5]
        String input = Console.readLine();

        return InputParser.parseOrders(input);
    }
}
