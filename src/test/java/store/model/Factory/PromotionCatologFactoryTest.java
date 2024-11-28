package store.model.Factory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.FileNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import store.model.arigation.PromotionCatalog;
import store.util.FileReader;

class PromotionCatologFactoryTest {
    PromotionCatalog catalog;
    PromotionCatologFactory factory;

    @BeforeEach
    void setUp() {
        FileReader reader = new FileReader();
        factory = new PromotionCatologFactory(reader);
    }

    @Test
    @DisplayName("팩토리는 product.md를 읽어 프로모션 정보를 저장한다.")
    void create() {
        try {
            catalog = factory.create();
            System.out.println(catalog.promotions().toString());
            assertThat(catalog.promotions().toString())
                    .contains("탄산2+1")
                    .contains("MD추천상품")
                    .contains("반짝할인");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
