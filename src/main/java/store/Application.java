package store;

import camp.nextstep.edu.missionutils.Console;
import store.parser.Parser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Map<String, Product> productsMap = productFileHandle();
        Products products = new Products(productsMap);

        Map<String, Promotion> promotionsMap = promotionFileHandle();
        Promotions promotions = new Promotions(promotionsMap);

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printProducts(products.getProducts());

        String input;
        List<OrderItem> orderItems = new ArrayList<>();
        Receipt Receipt = new Receipt();
        while (true) {
            try {
                input = inputView.getInput();
                orderItems = Parser.parse(input);
                //구매
                Receipt = products.buyProductsIfYouCan(orderItems);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        //멤버십?
        Boolean membership = inputView.getInputMembership();

        outputView.printProducts(products.getProducts());

    }

    static class Garbage {
//        for (OrderItem orderItem : orderItems) {
//                    System.out.println(orderItem.toString());
//                }
    }

    static class InputView {
        public String getInput() {
            System.out.println("구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])");
            return Console.readLine();
        }

        public Boolean getInputMembership() {
            System.out.println("멤버십 할인을 받으시겠습니까? (Y/N)");
            return getBoolean();
        }

        private Boolean getBoolean() {
            if (Console.readLine().equalsIgnoreCase("y")) {
                return true;
            }
            if (Console.readLine().equalsIgnoreCase("n")) {
                return false;
            }
            throw new IllegalArgumentException("잘못된 입력입니다. Y/N만 입력 가능");
        }
    }

    static class OutputView {
        public void printProducts(Map<String, Product> products) {
            System.out.println("안녕하세요. W편의점입니다.");
            System.out.println("현재 보유하고 있는 상품입니다.\n");

            NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);
            for (Map.Entry<String, Product> entry : products.entrySet()) {
                Product product = entry.getValue();
                String name = product.getName();
                int price = product.getPrice();
                String printPrice = numberFormat.format(price);
                int regularStockQuantity = product.getRegularQuantity();
                int promotionStockQuantity = product.getPromotionQuantity();
                String promotionLabel = product.getPromotionName() != null ? product.getPromotionName() : ""; // Null 확인

                // 프로모션 재고 출력
                if (promotionStockQuantity > 0) {
                    System.out.println("- " + name + " " + printPrice + "원 " + promotionStockQuantity + "개 " + promotionLabel);
                } else if (!promotionLabel.isEmpty()) { // 프로모션 라벨이 있지만 재고가 없는 경우
                    System.out.println("- " + name + " " + printPrice + "원 재고 없음 " + promotionLabel);
                }

                // 일반 재고 출력
                if (regularStockQuantity > 0) {
                    System.out.println("- " + name + " " + printPrice + "원 " + regularStockQuantity + "개");
                } else {
                    System.out.println("- " + name + " " + printPrice + "원 재고 없음");
                }
            }

        }
    }


    public static Map<String, Product> productFileHandle() {
        Path filePath = Paths.get("src/main/resources/products.md");
        Map<String, Product> products = new LinkedHashMap<>();
        try {
            List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            lines.stream().skip(1).forEach(line -> {

                String[] values = line.split(",");
                String name = values[0].trim();
                int price = Integer.parseInt(values[1].trim());
                int quantity = Integer.parseInt(values[2].trim());
                String promotionName = values[3].trim().equals("null") ? null : values[3].trim();

                products.putIfAbsent(name, new Product(name, price, 0, 0, promotionName));
                Product product = products.get(name);

                if (promotionName == null) {
                    product.incrementRegularStock(quantity);
                } else {
                    product.incrementPromotionStock(quantity);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("파일 읽기 중 오류가 발생했습니다: " + e.getMessage());
        }

        return products;
    }

    public static Map<String, Promotion> promotionFileHandle() {
        Path filePath = Paths.get("src/main/resources/promotions.md");
        Map<String, Promotion> promotions = new LinkedHashMap<>();

        try {
            List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            for (String line : lines.subList(1, lines.size())) { // 첫 줄 건너뛰기
                String[] values = line.split(",");
                String name = values[0].trim();
                int buy = Integer.parseInt(values[1].trim());
                int get = Integer.parseInt(values[2].trim());
                LocalDate startDate = LocalDate.parse(values[3].trim());
                LocalDate endDate = LocalDate.parse(values[4].trim());

                Promotion promotion = new Promotion(name, buy, get, startDate, endDate);
                promotions.put(name, promotion);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return promotions;
    }


}