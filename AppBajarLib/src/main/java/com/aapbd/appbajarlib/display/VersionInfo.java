package com.aapbd.appbajarlib.display;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by shafiulalambiplob on 1/2/16.
 */
public class VersionInfo {

//    2.2	Froyo	8	0.2%
//            2.3.3 -
//            2.3.7	Gingerbread	10	3.0%
//            4.0.3 -
//            4.0.4	Ice Cream Sandwich	15	2.7%
//            4.1.x	Jelly Bean	16	9.0%
//            4.2.x	17	12.2%
//            4.3	18	3.5%
//            4.4	KitKat	19	36.1%
//            5.0	Lollipop	21	16.9%
//            5.1	22	15.7%
//            6.0	Marshmallow	23	0.7%

    public static String getFullSDKName(String SDKNumber)
    {
        String name="";

        if(SDKNumber.equalsIgnoreCase("8"))
        {
            name="2.2";
        }else if(SDKNumber.equalsIgnoreCase("9"))
        {
            name="2.3.3";
        }

        else if(SDKNumber.equalsIgnoreCase("10"))
        {
            name="2.3.4";
        }

        else if(SDKNumber.equalsIgnoreCase("11"))
        {
            name="2.3.5";
        }

        else if(SDKNumber.equalsIgnoreCase("12"))
        {
            name="2.3.6";
        }

        else if(SDKNumber.equalsIgnoreCase("13"))
        {
            name="2.3.7";
        }

        else if(SDKNumber.equalsIgnoreCase("14"))
        {
            name="4.0";
        }

        else if(SDKNumber.equalsIgnoreCase("15"))
        {
            name="4.0.3";
        }

        else if(SDKNumber.equalsIgnoreCase("16"))
        {
            name="4.1";
        }

        else if(SDKNumber.equalsIgnoreCase("17"))
        {
            name="4.2";
        }

        else if(SDKNumber.equalsIgnoreCase("18"))
        {
            name="4.3";
        }
        else if(SDKNumber.equalsIgnoreCase("19"))
        {
            name="4.4";
        } else if(SDKNumber.equalsIgnoreCase("20"))
        {
            name="4.5";
        } else if(SDKNumber.equalsIgnoreCase("21"))
        {
            name="5.0";
        } else if(SDKNumber.equalsIgnoreCase("22"))
        {
            name="5.1";
        } else if(SDKNumber.equalsIgnoreCase("23"))
        {
            name="6.0";
        }

        else if(SDKNumber.equalsIgnoreCase("24"))
        {
            name="6.1";
        }
        else if(SDKNumber.equalsIgnoreCase("25"))
        {
            name="6.2";
        }
        else
        {
            name="Unknown";
        }




return name;



    }


    public  static String getVersionName(Context con)
    {
        try {

            PackageInfo pInfo = con.getPackageManager().getPackageInfo(con.getPackageName(), 0);
            return pInfo.versionName;
        }catch (Exception e)
        {

        }

        return "Unknown";
    }

    public  static int getVersionCode(Context con)
    {
        try {

            PackageInfo pInfo = con.getPackageManager().getPackageInfo(con.getPackageName(), 0);
            return pInfo.versionCode;
        }catch (Exception e)
        {

        }

        return -1;
    }



    public static boolean isPackageInstalled(Context con, String packagename) {
        PackageManager pm = con.getPackageManager();

        try {
            PackageInfo pInfo= pm.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public  static int getVersionCodeByPackageName(Context con, String packageName)
    {

        PackageManager pm = con.getPackageManager();

        try {
            PackageInfo pInfo= pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return  pInfo.versionCode;

        } catch (Exception e) {
            return -1;
        }

    }
}
