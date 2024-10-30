package ru.arkhipov.MySecondTestAppSpringBoot.util;

import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    public static DateTimeFormatter getCustomFormat() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
    }
}