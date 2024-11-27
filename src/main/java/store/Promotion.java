package store;

import java.time.LocalDate;

public class Promotion {
    private String name;
    private int buy;
    private int get;
    private LocalDate startDate;
    private LocalDate endDate;

    public Promotion(String name, int buy, int get, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.buy = buy;
        this.get = get;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean isPromotion(LocalDate currentDate) {
        return (currentDate.isEqual(startDate) || currentDate.isAfter(startDate)) &&
                (currentDate.isEqual(endDate) || currentDate.isBefore(endDate));

    }
    public int calculateGroupSize() {
        return buy+get;
    }
}
