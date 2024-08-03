package com.educandoweb.workshopmongo.resources.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class URL {

    public static String decodeParam(String text) {
        if (text != null) {
            return URLDecoder.decode(text, StandardCharsets.UTF_8);
        } else {
            return "";
        }
    }

    public static LocalDate convertDate(String textDate, LocalDate defaultDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd").
                withZone(ZoneId.of("GMT"));
        try {
            return LocalDate.parse(textDate, dtf);
        } catch (DateTimeParseException e) {
            return defaultDate;
        }
    }

}
