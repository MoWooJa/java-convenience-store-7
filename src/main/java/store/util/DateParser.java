package store.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateParser {
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static LocalDateTime parse(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return LocalDate.parse(date, formatter).atStartOfDay();
    }

    public static String convert(LocalDateTime date) {
        return date.toLocalDate().format(DateTimeFormatter.ofPattern(DATE_FORMAT));
    }
}
