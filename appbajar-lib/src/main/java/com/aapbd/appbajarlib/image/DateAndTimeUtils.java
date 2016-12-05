package com.aapbd.appbajarlib.image;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateAndTimeUtils {

    public static int getAgeFromBirthday(String birthDay) {

        final Calendar now = Calendar.getInstance();
        final Calendar dob = Calendar.getInstance();
        try {
            dob.setTimeInMillis(getTime(birthDay));

        } catch (final Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return -1;

        }
        if (dob.after(now)) {
            return -1;
        }
        final int year1 = now.get(Calendar.YEAR);
        final int year2 = dob.get(Calendar.YEAR);
        int age = year1 - year2;
        final int month1 = now.get(Calendar.MONTH);
        final int month2 = dob.get(Calendar.MONTH);
        if (month2 > month1) {
            age--;
        } else if (month1 == month2) {
            final int day1 = now.get(Calendar.DAY_OF_MONTH);
            final int day2 = dob.get(Calendar.DAY_OF_MONTH);
            if (day2 > day1) {
                age--;
            }
        }
        return age;

    }

    /*
     * get long value from different string formatted date
     */
    public static long getTime(String time) throws Exception {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

        try {
            return format.parse(time).getTime();
        } catch (final Exception e) {
            format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        }
        try {
            return format.parse(time).getTime();
        } catch (final Exception e) {
            format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            // For this you may need to manually adjust time offset
        }
        try {
            return format.parse(time).getTime();
        } catch (final Exception e) {
            format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
        }
        try {
            return format.parse(time).getTime();
        } catch (final Exception e) {
            format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss'Z'");
            // For this you may need to manually adjust time offset
        }

        try {
            return format.parse(time).getTime();
        } catch (final Exception e) {
            format = new SimpleDateFormat("yyyy-MM-dd");
            // For this you may need to manually adjust time offset
        }
        return format.parse(time).getTime();
    }

    public static String friendlyTimeDiff(long oldTimeInMili) {

        final Calendar now = Calendar.getInstance();
        final Calendar dob = Calendar.getInstance();
        try {
            dob.setTimeInMillis(oldTimeInMili);

        } catch (final Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error";

        }

        final long timeDifferenceMilliseconds = now.getTimeInMillis()
                - dob.getTimeInMillis();

        final long diffSeconds = timeDifferenceMilliseconds / 1000;
        final long diffMinutes = timeDifferenceMilliseconds / (60 * 1000);
        final long diffHours = timeDifferenceMilliseconds / (60 * 60 * 1000);
        final long diffDays = timeDifferenceMilliseconds
                / (60 * 60 * 1000 * 24);
        final long diffWeeks = timeDifferenceMilliseconds
                / (60 * 60 * 1000 * 24 * 7);
        final long diffMonths = (long) (timeDifferenceMilliseconds / (60 * 60 * 1000 * 24 * 30.41666666));
        final long diffYears = timeDifferenceMilliseconds
                / (60 * 60 * 1000 * 24 * 365);

        if (diffSeconds < 1) {
            return " 0 second";
        } else if (diffMinutes < 1) {
            return diffSeconds + " second(s)";
        } else if (diffHours < 1) {
            return diffMinutes + " minute(s)";
        } else if (diffDays < 1) {
            return diffHours + " hour(s)";
        } else if (diffWeeks < 1) {
            return diffDays + " day(s)";
        } else if (diffMonths < 1) {
            return diffWeeks + " week(s)";
        } else if (diffYears < 1) {
            return diffMonths + " month(s)";
        } else {
            return diffYears + " year(s)";
        }
    }
}
