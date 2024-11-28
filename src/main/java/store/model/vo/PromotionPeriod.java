package store.model.vo;

import java.time.LocalDateTime;
import store.util.Date;
import store.util.DateParser;

public class PromotionPeriod {
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    public PromotionPeriod(String startTime, String endTime) {
        this.startTime = DateParser.parse(startTime);
        this.endTime = DateParser.parse(endTime);
    }


    public boolean isInPromotionPeriod(Date date) {
        LocalDateTime now = date.now();
        if (now.isAfter(startTime) && now.isBefore(endTime)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return startTime +" "+ endTime;
    }
}
