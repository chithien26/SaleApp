package com.lct.SaleApp.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RevertDate{
    public static LocalDateTime stringToDateTime(String stringDate){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDateTime.parse(stringDate, dateTimeFormatter);
    }

    public static LocalDate stringToDate(String stringDate){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(stringDate, dateTimeFormatter);
    }

    public static LocalTime stringToTime(String stringTime){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        return LocalTime.parse(stringTime, dateTimeFormatter);
    }
}
