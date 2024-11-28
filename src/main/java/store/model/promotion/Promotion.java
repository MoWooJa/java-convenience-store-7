package store.model.promotion;

import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import store.model.orderannounce.AnnounceCode;
import store.model.orderannounce.OrderAnnounceRequest;

public class Promotion {

    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd";

    private final String name;
    private final int buy;
    private final int get;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    public Promotion(String name, int buy, int get, String startDate, String endDate) {
        this.name = name;
        this.buy = buy;
        this.get = get;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
        this.startDate = LocalDate.parse(startDate, formatter).atStartOfDay();
        this.endDate = LocalDate.parse(endDate, formatter).atStartOfDay();
    }

    public static Promotion of(List<String> promotionInformation) {
        String name = promotionInformation.get(0);
        int buy = Integer.parseInt(promotionInformation.get(1));
        int get = Integer.parseInt(promotionInformation.get(2));
        String startDate = promotionInformation.get(3);
        String endDate = promotionInformation.get(4);
        return new Promotion(name, buy, get, startDate, endDate);
    }

    public boolean isValidDate() {
        LocalDateTime today = DateTimes.now();
        return today.isAfter(startDate) && today.isBefore(endDate);
    }

    public OrderAnnounceRequest getAnnounceCode(int orderAmount) {
        int mod = orderAmount % (buy + get);
        if (mod == 0) {
            return new OrderAnnounceRequest(AnnounceCode.SUCCESS, null, mod);
        }
        if (mod == buy) {
            return new OrderAnnounceRequest(AnnounceCode.MORE_FREE, null, get);
        }
        return new OrderAnnounceRequest(AnnounceCode.PART_NO_PROMOTION, null, mod);
    }

    public String getPromotionName() {
        return name;
    }
}
