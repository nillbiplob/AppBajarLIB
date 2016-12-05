package com.aapbd.appbajarlib.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

public class OpenAppInsideorOutside {

    public static void openAppByPackageName(Context con, String packageName)

    {

        if (isPackageInstalled(con, packageName)) { // Open

            Intent i = con.getPackageManager().getLaunchIntentForPackage(
                    packageName);
            i.addCategory(Intent.CATEGORY_LAUNCHER);
            con.startActivity(i);
        } else { // Open market
            try {
                con.startActivity(new Intent(Intent.ACTION_VIEW, Uri
                        .parse("market://details?id=" + packageName)));
            } catch (android.content.ActivityNotFoundException anfe) {
                con.startActivity(new Intent(Intent.ACTION_VIEW, Uri
                        .parse("http://play.google.com/store/apps/details?id="
                                + packageName)));
            }
        }
    }

    public static void openAppWithURL(Context con, String packageName,
                                      String localURl, String globalURL)

    {

        if (isPackageInstalled(con, packageName)) { // Open

            con.startActivity(new Intent(Intent.ACTION_VIEW, Uri
                    .parse(localURl)));

        } else { // Open market

            con.startActivity(new Intent(Intent.ACTION_VIEW, Uri
                    .parse(globalURL)));

        }
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


    public static void uninstallApp(Context con, String packageName) {


        Intent intent = new Intent(Intent.ACTION_DELETE, Uri.fromParts("package",
               packageName,null));
       con. startActivity(intent);


//      PackageManager  pm = con.getPackageManager();
//        Class<?>[] types = new Class[] {String.class, IPackageDeleteObserve.class, int.class};
//        Method method = pm.getClass().getMethod("deletePackage", types);
//        method.invoke(pm, new Object[] {"com.example.com", null, 0})


//        Uri packageUri = Uri.parse(packageName.trim());
//        Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageUri);
//        con.startActivity(uninstallIntent);


    }



}
