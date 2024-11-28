package store.model.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import store.model.type.PromotionType;
import store.model.vo.PromotionPeriod;
import store.util.DateParser;

class PromotionTest {
    private Promotion promotion;

    @BeforeEach
    void setUp() throws Exception {
        String startTime = "2024-01-01";
        String endTime = "2024-12-31";
        PromotionPeriod period = new PromotionPeriod(startTime, endTime);
        promotion = new Promotion("MD추천상품",PromotionType.BUY_TWO_GET_ONE, period);

    }

    @Test
    @DisplayName("프로모션은 이름을 확인할 수 있다.")
    void promotionTest() {
        assertThat(promotion.getName()).isEqualTo("MD추천상품");
    }
}
