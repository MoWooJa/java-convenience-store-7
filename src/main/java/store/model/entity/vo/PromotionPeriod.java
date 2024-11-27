package store.model.entity.vo;

import java.time.LocalDateTime;
import store.util.Date;

public class PromotionPeriod {
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public PromotionPeriod(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isInPromotionPeriod(Date date) {
        LocalDateTime now = date.now();
        if(now.isAfter(startTime) && now.isBefore(endTime)) {
            return true;
        }
        return false;
    }
}
