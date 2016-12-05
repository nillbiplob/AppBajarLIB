package com.aapbd.utils.image;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveAndShareImage {


    private static File dir = null;


    private static void createBaseDirctory() {

        final String extStorageDirectory = Environment
                .getExternalStorageDirectory().toString();
        dir = new File(extStorageDirectory + "/AAPBDLIBSAMPLEIMAGES");

        if (dir.mkdir()) {
            System.out.println("Directory created");
        } else {
            System.out.println("Directory is not created or exists");
        }
    }

    public static File saveImage(Context con, Bitmap bitmap) {
        // TODO Auto-generated method stub

        createBaseDirctory();
        // TODO Auto-generated method stub

        File file = new File(dir, "/testsave.jpeg");

        if (file.exists()) {
            file.delete();
        }


        final ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

        FileOutputStream fo = null;
        try {

            fo = new FileOutputStream(file);
            fo.write(bytes.toByteArray());

        } catch (final IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } finally {
            try {
                fo.close();
            } catch (final IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }


        return file;


    }

    public static File saveAndScan(Context con, Bitmap bitmap, File f) {

        // TODO Auto-generated method stub

        // TODO Auto-generated method stub

        final ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

        FileOutputStream fo = null;
        try {

            fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());

        } catch (final IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } finally {
            try {
                fo.close();
            } catch (final IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        galleryAddPic(f, con);

        return f;

    }


    public static void galleryAddPic(File f, Context con) {
        final Intent mediaScanIntent = new Intent(
                "android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        final Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        con.sendBroadcast(mediaScanIntent);
    }

	/*
     * save and share image
	 */

    public static void saveAndShareImage(Context con, Bitmap bitmap, File f)
            throws Exception {

        final Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/*");

        final File url = saveAndScan(con, bitmap, f);

        share.putExtra(Intent.EXTRA_STREAM,
                Uri.parse("file:///" + url.getAbsolutePath()));
        con.startActivity(Intent.createChooser(share, "Share Image"));

    }

    public static void saveAndShareImage(Context con, File f)
            throws Exception {

        final Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/*");


        share.putExtra(Intent.EXTRA_STREAM,
                Uri.parse("file:///" + f.getAbsolutePath()));
        con.startActivity(Intent.createChooser(share, "Share Image"));

    }
}
