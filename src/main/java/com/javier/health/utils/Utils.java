package com.javier.health.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by javiergonzalezcabezas on 18/11/15.
 */
public class Utils {
    public static boolean isOnline(Activity activity) {
        ConnectivityManager cm =
                (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
    /**
     * this method was created for converting Date for locale formatting.
     */
    public static String converStringToDate(String dateInString) {
        String returnString;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
        SimpleDateFormat myFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse(dateInString);
            returnString = myFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            returnString = e.toString();
        }
        return returnString;
    }
}
