package com.aapbd.appbajarlib.geolocation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.google.android.maps.GeoPoint;

public class MapByIntent {

    public static void showMap(Context con, double latitue, double longitude) {

        try {

            final Uri geoUri = Uri.parse("geo:" + latitue + "," + longitude);
            final Intent mapCall = new Intent(Intent.ACTION_VIEW, geoUri);
            mapCall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            con.startActivity(mapCall);
        } catch (final Exception e) {

        }

    }

    public static void showMap(Context con, String latitue, String longitude) {

        try {

            final Uri geoUri = Uri.parse("geo:" + latitue + "," + longitude);
            final Intent mapCall = new Intent(Intent.ACTION_VIEW, geoUri);
            mapCall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            con.startActivity(mapCall);

        } catch (final Exception e) {

        }

    }

    public static void showMap(Context con, String latlon) {
        try {

            final Uri geoUri = Uri.parse(latlon);
            final Intent mapCall = new Intent(Intent.ACTION_VIEW, geoUri);
            mapCall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            con.startActivity(mapCall);

        } catch (final Exception e) {

        }

    }

    public static void showDirection(Context con, double sLatitue,
                                     double sLongitude, double dLatitue, double dLongitude) {

        try {

            final Uri geoUri = Uri.parse("http://maps.google.com/maps?"
                    + "saddr=" + sLatitue + "," + sLongitude + "&daddr="
                    + dLatitue + "," + dLongitude);
            final Intent mapCall = new Intent(Intent.ACTION_VIEW, geoUri);
            mapCall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            con.startActivity(mapCall);
        } catch (final Exception e) {

        }

    }

    public static void showDirection(Context con, String sLatitue,
                                     String sLongitude, String dLatitue, String dLongitude) {

        try {

            final Uri geoUri = Uri.parse("http://maps.google.com/maps?"
                    + "saddr=" + sLatitue + "," + sLongitude + "&daddr="
                    + dLatitue + "," + dLongitude);
            final Intent mapCall = new Intent(Intent.ACTION_VIEW, geoUri);
            mapCall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            con.startActivity(mapCall);

        } catch (final Exception e) {

        }

    }

    public static void showDirection(Context con, GeoPoint sPoint,
                                     GeoPoint dPoint) {

        try {

            final double sLatitue = sPoint.getLatitudeE6() / 1E6;
            final double sLongitude = sPoint.getLongitudeE6() / 1E6;
            final double dLatitue = dPoint.getLatitudeE6() / 1E6;
            final double dLongitude = dPoint.getLongitudeE6() / 1E6;

            showDirection(con, sLatitue, sLongitude, dLatitue, dLongitude);

        } catch (final Exception e) {

        }

    }

}
