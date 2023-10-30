package com.example.rubrica.rubrica.util;

import java.time.LocalDate;

public class DateCheck {

    public static boolean isDate(String date) {
        try {
            LocalDate date1 = LocalDate.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    DateCheck.isDate(string)
}
