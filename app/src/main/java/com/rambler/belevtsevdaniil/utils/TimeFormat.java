package com.rambler.belevtsevdaniil.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by Daniil Belevtsev on 02.05.2016 19:05.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
public class TimeFormat {
    private static final DateTimeFormatter FORMATTER_INPUT = DateTimeFormat.forPattern("E, d MMMM yyyy HH:mm:ss Z");
    private static final DateTimeFormatter FORMATTER_OUTPUT = DateTimeFormat.forPattern("d MMMM yyyy HH:mm:ss");

    public static DateTime format(String in) {
        if(in != null) {
            return new DateTime(FORMATTER_INPUT.withOffsetParsed().parseDateTime(in));
        } else {
            return new DateTime(0);
        }
    }

    public static String format(DateTime dateTime) {
        return FORMATTER_OUTPUT.withZone(dateTime.getZone()).print(dateTime);
    }
}
