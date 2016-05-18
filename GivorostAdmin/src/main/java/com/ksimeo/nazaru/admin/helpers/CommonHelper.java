package com.ksimeo.nazaru.admin.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Ksimeo. Created on 11.05.2016 at 18:19 for "Givorost" project.
 * @version 1.0
 * @since 1.0
 */
public class CommonHelper {

    public static String correctDateFormat(Date date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
