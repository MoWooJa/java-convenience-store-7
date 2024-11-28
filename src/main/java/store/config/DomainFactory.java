package store.config;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import store.domain.Product;
import store.domain.Promotion;
import store.util.file.FileReader;
import store.util.file.FileType;
import store.util.parser.FileParser;

public class DomainFactory {

    // 프로모션 리스트 생성
    public List<Promotion> createPromotion() throws FileNotFoundException {
        FileReader fileReader = new FileReader();
        List<String> promotionList = fileReader.read(FileType.PROMOTIONS_FILE_PATH);

        return promotionList.stream()
                .map(FileParser::productParser)
                .map(parsed -> new Promotion(
                        parsed[0],
                        Integer.parseInt(parsed[1]),
                        Integer.parseInt(parsed[2]),
                        LocalDate.parse(parsed[3]),
                        LocalDate.parse(parsed[4])
                ))
                .collect(Collectors.toList());
    }

    // 프로덕트 리스트 생성
    public List<Product> createProduct() throws FileNotFoundException {
        FileReader fileReader = new FileReader();
        List<String> productList = fileReader.read(FileType.PRODUCTS_FILE_PATH);

        // 모든 상품의 이름을 기준으로 일반 재고 및 프로모션 재고를 체크
        List<Product> products = productList.stream()
                .map(FileParser::productParser)
                .map(parsed -> new Product(
                        parsed[0],
                        Integer.parseInt(parsed[1]),
                        Integer.parseInt(parsed[2]),
                        parsed[3]
                ))
                .collect(Collectors.toList());

        // "재고 없음" 상태 추가
        List<Product> productsWithStockStatus = new ArrayList<>(products);
        List<String> productNames = products.stream()
                .map(Product::getName)
                .distinct()
                .collect(Collectors.toList());

        for (String productName : productNames) {
            boolean hasPromotionStock = products.stream()
                    .anyMatch(p -> productName.equals(p.getName()) && !"null".equals(p.getPromotion()));

            boolean hasNonPromotionStock = products.stream()
                    .anyMatch(p -> productName.equals(p.getName()) && "null".equals(p.getPromotion()));

            // 일반 재고가 없고, 프로모션 재고가 있는 경우
            if (hasPromotionStock && !hasNonPromotionStock) {
                productsWithStockStatus.add(new Product(productName, 0, 0, "재고 없음"));
            }
        }

        return productsWithStockStatus;
    }
}
