package store.util;

import java.time.LocalDateTime;

public class DateNow implements Date {
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
