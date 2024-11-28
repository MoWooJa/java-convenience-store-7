package store.model.entity.vo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import store.model.vo.PromotionPeriod;
import store.util.Date;
import store.util.DateParser;

class PromotionPeriodTest {
    private PromotionPeriod promotionPeriod1;
    private PromotionPeriod promotionPeriod2;
    private Date date;

    class MockDateNow implements Date{
        @Override
        public LocalDateTime now() {
            return LocalDate.of(2024, 12, 1).atStartOfDay();
        }
    }

    @BeforeEach
    void setUp() {
        String startTime1 = "2024-11-01";
        String endTime1 = "2024-11-30";
        String startTime2 = "2024-01-01";
        String endTime2 = "2024-12-31";

       promotionPeriod1 = new PromotionPeriod(startTime1, endTime1);
       promotionPeriod2 = new PromotionPeriod(startTime2, endTime2);

       date = new MockDateNow();
    }

    @Test
    @DisplayName("프로모션 기간이 맞으면 참을 아니면 거짓을 반환한다.")
    void isInPromotionPeriodTest() {
        assertFalse(promotionPeriod1.isInPromotionPeriod(date));
        assertTrue(promotionPeriod2.isInPromotionPeriod(date));
    }
}
