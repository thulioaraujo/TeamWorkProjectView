package com.teamwork.projectview.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * TeamWorkProjectView - Technical Test
 *
 * Created by Thulio Araujo on 3/5/2018.
 */

public class Util {

    /**
     * Method to format a string from yyyyMMdd to dd/MM/yyyy
     *
     * @param currentDate current date
     * @return converted date
     */
    public static String formatStringDate(String currentDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
        Date data = null;
        try {
            data = simpleDateFormat.parse(currentDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        simpleDateFormat.applyPattern("dd/MM/yyyy");
        return simpleDateFormat.format(data);
    }
}
