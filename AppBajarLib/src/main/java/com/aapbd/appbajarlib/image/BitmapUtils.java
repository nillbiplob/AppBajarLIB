package com.aapbd.appbajarlib.image;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

import com.aapbd.appbajarlib.print.Print;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

public class BitmapUtils {

    public static Bitmap getRescaledBitmap(final Bitmap bit, final int x,
                                           final int y, final boolean flag) {

        return Bitmap.createScaledBitmap(bit, x, y, true);

    }

    public static Vector<Bitmap> getBitmapFromAsset(Context con, String path)
            throws IOException {
        final AssetManager am = con.getAssets();
        final String[] files = am.list(path);
        final Vector<Bitmap> temp = new Vector<Bitmap>();

        for (final String s : files) {
            try {
                temp.addElement(BitmapFactory.decodeStream(am.open(path + "/"
                        + s)));
            } catch (final Exception e) {

            }
        }

        return temp;

    }

    public static Bitmap getResizedBitmapByDeviceWidth(Bitmap src,
                                                       int deviceWidth) {


        final int origWidth = src.getWidth();
        final int origHeight = src.getHeight();


        float scale = (float) origHeight / origWidth;


        final int destHeight = Math.round(deviceWidth * scale);


        Bitmap bit = Bitmap.createScaledBitmap(src, deviceWidth, destHeight, false);


        try {
            Print.message("AAPBDLIB", "image width and height" + origWidth + "" + origHeight);

            Print.message("AAPBDLIB", "destination width and height" + deviceWidth + "" + destHeight);
            Print.message("AAPBDLIB", "new image width and height" + bit.getWidth() + "" + bit.getHeight());


        } catch (Exception e) {

        }

        return bit;


    }

    public static Bitmap getResizedBitmapUsingMatrix(final Bitmap BitmapOrg,
                                                     int x, int y, final boolean flag) {

        final int origHeight = BitmapOrg.getHeight();
        final int origWidth = BitmapOrg.getWidth();
        float scaleWidth;
        float scaleHeight;
        if (origWidth >= origHeight) {
            scaleWidth = (float) x / origWidth;
            scaleHeight = scaleWidth;
        } else {
            scaleHeight = (float) y / origHeight;
            scaleWidth = scaleHeight;
        }
        x = Math.round(origWidth * scaleWidth);
        y = Math.round(origHeight * scaleWidth);

        // create a matrix for the manipulation
        final Matrix matrix = new Matrix();
        // resize the Bitmap
        matrix.postScale(scaleWidth, scaleHeight);
        // if you want to rotate the Bitmap
        // matrix.postRotate(45);

        return Bitmap.createBitmap(BitmapOrg, 0, 0, x, y, matrix, flag);

    }

    public static byte[] getByteArrayFromBitmap(final Bitmap bitmap, int quality) {

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, out);
        return out.toByteArray();
    }

    public static Bitmap getBitmapFromByteArray(final byte data[], int maxSize) {
        final int MAX_SIZE = maxSize;
        if (data.length > 0) {
            try {
                final BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0,
                        data.length, options);
                final int fullWidth = options.outWidth;
                final int fullHeight = options.outHeight;
                int w = 0;
                int h = 0;
                if (fullWidth > fullHeight) {
                    w = MAX_SIZE;
                    h = w * fullHeight / fullWidth;
                } else {
                    h = MAX_SIZE;
                    w = h * fullWidth / fullHeight;
                }
                options.inJustDecodeBounds = false;
                options.inSampleSize = fullWidth / w;
                bitmap = BitmapFactory.decodeByteArray(data, 0, data.length,
                        options);
                return bitmap;
            } catch (final Exception e) {
            }
        }
        return null;
    }


    public static Bitmap getResizedBitmap(final Bitmap bit, int maxSize) {
        final int MAX_SIZE = maxSize;


        if (bit != null) {

            Print.message("Input Bitmap", "is not NULL");
            try {

                final int fullWidth = bit.getWidth();
                final int fullHeight = bit.getHeight();
                Print.message("Input Bitmap size ", fullWidth + " " + fullHeight);


                int w = 0;
                int h = 0;
                if (fullWidth > fullHeight) {
                    w = MAX_SIZE;
                    h = w * fullHeight / fullWidth;
                } else {
                    h = MAX_SIZE;
                    w = h * fullWidth / fullHeight;
                }


                Print.message("Input Bitmap size  after Scale ", w + " " + h);


                BitmapFactory.Options outBitmap = new BitmapFactory.Options();
                outBitmap.inJustDecodeBounds = false; // the decoder will return a bitmap
                outBitmap.inSampleSize = calculateSampleSize(fullWidth, fullHeight, w, h);

                byte[] data1 = getByteArrayFromBitmap(bit, 80);

                Bitmap resizedBitmap = BitmapFactory.decodeByteArray(data1, 0, data1.length, outBitmap);
                data1 = null;

                //	return getRescaledBitmap(bit,w,h,false);


                return resizedBitmap;
            } catch (final Exception e) {

                Print.message("Input Bitmap Resize error", e.toString());


            }
        } else {
            Print.message("Input Bitmap", "NULL");

        }
        return null;
    }


    public static int calculateSampleSize(int width, int height, int targetWidth, int targetHeight) {
        int inSampleSize = 1;

        if (height > targetHeight || width > targetWidth) {

            // Calculate ratios of height and width to requested height and
            // width
            final int heightRatio = Math.round((float) height
                    / (float) targetHeight);
            final int widthRatio = Math.round((float) width / (float) targetWidth);

            // Choose the smallest ratio as inSampleSize value, this will
            // guarantee
            // a final image with both dimensions larger than or equal to the
            // requested height and width.
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }


    // decodes image and scales it to reduce memory consumption
    public static Bitmap decodeFile(File f, int size) {
        try {
            // Decode image size
            final BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(f), null, o);

            // The new size we want to scale to
            final int REQUIRED_SIZE = size;

            // Find the correct scale value. It should be the power of 2.
            int scale = 1;
            while (o.outWidth / scale / 2 >= REQUIRED_SIZE
                    && o.outHeight / scale / 2 >= REQUIRED_SIZE)
                scale *= 2;

            // Decode with inSampleSize
            final BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
        } catch (final FileNotFoundException e) {
        }
        return null;
    }

    public static InputStream getInputStreamFromBitmap(Bitmap bitmap) {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
        final byte[] bitmapdata = out.toByteArray();
        final ByteArrayInputStream bs = new ByteArrayInputStream(bitmapdata);
        return bs;
    }


}
