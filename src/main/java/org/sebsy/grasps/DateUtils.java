package org.sebsy.grasps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe pure fabrication : transformations String vers {@link LocalDateTime}.
 */
public class DateUtils {

    private static final DateTimeFormatter RESERVATION_DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private DateUtils() { }

    public static LocalDateTime toLocalDateTime(String dateStr) {
        return LocalDateTime.parse(dateStr, RESERVATION_DATE_FORMAT);
    }
}
