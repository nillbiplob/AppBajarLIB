package com.aapbd.appbajarlib.geolocation;

import android.location.Location;
import android.util.Log;

import com.aapbd.appbajarlib.print.Print;
import com.google.android.maps.GeoPoint;

public class GeoUtils {

    private static int EARTH_RADIUS_KM = 6371;
    public static int MILLION = 1000000;

    /**
     * * Computes the distance in kilometers between two points on Earth. * * @param
     * lat1 Latitude of the first point * @param lon1 Longitude of the first
     * point * @param lat2 Latitude of the second point * @param lon2 Longitude
     * of the second point * @return Distance between the two points in
     * kilometers.
     */
    public static double distanceKm(final double lat1, final double lon1,
                                    final double lat2, final double lon2) {

		/*
		 * 
		 */

        float[] result1 = new float[3];


        Location.distanceBetween(lat1, lon1, lat2, lon2, result1);

        Float distance1 = result1[0]; // result im METER

        double d = (distance1 / 1000); // convert to double and KM

        return d;


    }

    public static double distanceM(final double lat1, final double lon1,
                                   final double lat2, final double lon2) {
		
		/*
		 * 
		 */

        float[] result1 = new float[3];


        Location.distanceBetween(lat1, lon1, lat2, lon2, result1);

        Float distance1 = result1[0]; // result im METER

        double d = distance1; // convert to double

        return d;


    }

    public static double distanceMile(double lat1, double lng1, double lat2,
                                      double lng2) {
	
		
		/*
		 * 
		 */

        float[] result1 = new float[3];


        Location.distanceBetween(lat1, lng1, lat2, lng2, result1);

        Float distance1 = result1[0]; // result im METER

        double d = (distance1 / 1000) * 0.621371192; // convert to double, KM and mile

        return d;
    }

    /**
     * * Computes the distance in kilometers between two points on Earth. * * @param
     * p1 First point * @param p2 Second point * @return Distance between the
     * two points in kilometers.
     */
    public static double distanceKm(final GeoPoint p1, final GeoPoint p2) {
        final double lat1 = p1.getLatitudeE6() / (double) GeoUtils.MILLION;
        final double lon1 = p1.getLongitudeE6() / (double) GeoUtils.MILLION;
        final double lat2 = p2.getLatitudeE6() / (double) GeoUtils.MILLION;
        final double lon2 = p2.getLongitudeE6() / (double) GeoUtils.MILLION;
        return GeoUtils.distanceKm(lat1, lon1, lat2, lon2);
    }

    public static GeoPoint getCenter(final GeoPoint p1, final GeoPoint p2) {

        final double lat1 = p1.getLatitudeE6() / (double) GeoUtils.MILLION;
        final double lon1 = p1.getLongitudeE6() / (double) GeoUtils.MILLION;
        final double lat2 = p2.getLatitudeE6() / (double) GeoUtils.MILLION;
        final double lon2 = p2.getLongitudeE6() / (double) GeoUtils.MILLION;

        final double x = (lat1 + lat2) / 2;
        final double y = (lon1 + lon2) / 2;

        return new GeoPoint((int) (x * 1e6), (int) (y * 1e6));

    }

    public static int getZoomLevel(final GeoPoint center, final GeoPoint first) {
        final double distance = GeoUtils.distanceKm(center, first);

        Log.e("distance is ", distance + "");

        int zoomLevel = 0;

        if (distance < 1) {
            zoomLevel = 16;
        } else if (distance >= 1 && distance < 2)

        {
            zoomLevel = 14;

        } else if (distance >= 2 && distance < 4)

        {
            zoomLevel = 12;

        } else if (distance >= 4 && distance < 8)

        {
            zoomLevel = 11;

        } else if (distance >= 8 && distance < 16)

        {
            zoomLevel = 10;

        } else if (distance >= 16 && distance < 32)

        {
            zoomLevel = 9;

        } else if (distance >= 32 && distance < 64)

        {
            zoomLevel = 8;

        } else if (distance >= 64 && distance < 128)

        {
            zoomLevel = 7;

        } else if (distance >= 128 && distance < 256)

        {
            zoomLevel = 6;

        } else {
            zoomLevel = 5;

        }

        Print.message("zoom level", zoomLevel + "");
        return zoomLevel;

    }

    /**
     * * Computes the bearing in degrees between two points on Earth. * * @param
     * p1 First point * @param p2 Second point * @return Bearing between the two
     * points in degrees. A value of 0 means due * north.
     */
    public static double bearing(final GeoPoint p1, final GeoPoint p2) {
        final double lat1 = p1.getLatitudeE6() / (double) GeoUtils.MILLION;
        final double lon1 = p1.getLongitudeE6() / (double) GeoUtils.MILLION;
        final double lat2 = p2.getLatitudeE6() / (double) GeoUtils.MILLION;
        final double lon2 = p2.getLongitudeE6() / (double) GeoUtils.MILLION;
        return GeoUtils.bearing(lat1, lon1, lat2, lon2);
    }

    /**
     * * Computes the bearing in degrees between two points on Earth. * * @param
     * lat1 Latitude of the first point * @param lon1 Longitude of the first
     * point * @param lat2 Latitude of the second point * @param lon2 Longitude
     * of the second point * @return Bearing between the two points in degrees.
     * A value of 0 means due * north.
     */
    public static double bearing(final double lat1, final double lon1,
                                 final double lat2, final double lon2) {
        final double lat1Rad = Math.toRadians(lat1);
        final double lat2Rad = Math.toRadians(lat2);
        final double deltaLonRad = Math.toRadians(lon2 - lon1);
        final double y = Math.sin(deltaLonRad) * Math.cos(lat2Rad);
        final double x = Math.cos(lat1Rad) * Math.sin(lat2Rad)
                - Math.sin(lat1Rad) * Math.cos(lat2Rad) * Math.cos(deltaLonRad);
        return GeoUtils.radToBearing(Math.atan2(y, x));
    }

    /**
     * Converts an angle in radians to degrees
     */
    public static double radToBearing(final double rad) {
        return (Math.toDegrees(rad) + 360) % 360;
    }

}
