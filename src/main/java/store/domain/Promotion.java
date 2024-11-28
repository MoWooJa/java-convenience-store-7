package store.domain;

import java.time.LocalDate;

public class Promotion {
    private String name;
    private int buy;
    private int give;
    private LocalDate startDate;
    private LocalDate endDate;

    public Promotion(String name, int buy, int give, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.buy = buy;
        this.give = give;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public int getBuy() {
        return buy;
    }

    public int getGive() {
        return give;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
