package store;

import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Promotion {
    private final String name;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Integer buy;
    private final Integer get;

    public Promotion(String name, LocalDate startDate, LocalDate endDate, Integer buy, Integer get) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.buy = buy;
        this.get = get;
    }

    public boolean isInPromotion() {
        LocalDateTime now = DateTimes.now();
        LocalDateTime start = TimeUtil.toLocalDateTime(startDate);
        LocalDateTime end = TimeUtil.toLocalDateTime(endDate);

        if (!now.isAfter(start)) {
            return false;
        }
        return now.isBefore(end);
    }

    public String getName() {
        return name;
    }

    public Integer getBuy() {
        return buy;
    }

    public Integer getGet() {
        return get;
    }
}
