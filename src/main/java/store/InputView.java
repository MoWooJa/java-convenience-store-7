package store;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import store.order.OrderRequestDto;
import store.product.Product;

public class InputView {

    public List<OrderRequestDto> buyProducts() {
        System.out.println("구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])");
        // [콜라-3],[에너지바-5]
        String input = Console.readLine();

        return InputParser.parseOrders(input);
    }

    public UserResponse askMissedItem(Product product, Integer missed) {
        System.out.printf("현재 %s은(는) %d개를 무료로 더 받을 수 있습니다. 추가하시겠습니까? (Y/N)", product.getName(), missed);
        System.out.println();
        return UserResponse.of(Console.readLine());
    }

    public UserResponse askIgnoredItem(Product product, Integer ignored) {
        System.out.printf("현재 %s %d개는 프로모션 할인이 적용되지 않습니다. 그래도 구매하시겠습니까? (Y/N)", product.getName(), ignored);
        System.out.println();
        return UserResponse.of(Console.readLine());
    }
}
