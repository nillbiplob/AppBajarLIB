package com.aapbd.utils.image;

import android.content.Context;
import android.graphics.AvoidXfermode;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

public class RoundedCornerBitmap {
    public static Bitmap getRoundedCornerBitmap(Context context, Bitmap bitmap,
                                                float upperLeft, float upperRight, float lowerRight,
                                                float lowerLeft, int endWidth, int endHeight) {
        final float densityMultiplier = context.getResources()
                .getDisplayMetrics().density;

        // scale incoming bitmap to appropriate px size given arguments and
        // display dpi
        bitmap = Bitmap.createScaledBitmap(bitmap,
                Math.round(endWidth * densityMultiplier),
                Math.round(endHeight * densityMultiplier), true);

        // create empty bitmap for drawing
        final Bitmap output = Bitmap.createBitmap(
                Math.round(endWidth * densityMultiplier),
                Math.round(endHeight * densityMultiplier), Config.ARGB_8888);

        // get canvas for empty bitmap
        final Canvas canvas = new Canvas(output);
        final int width = canvas.getWidth();
        final int height = canvas.getHeight();

        // scale the rounded corners appropriately given dpi
        upperLeft *= densityMultiplier;
        upperRight *= densityMultiplier;
        lowerRight *= densityMultiplier;
        lowerLeft *= densityMultiplier;

        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);

        // fill the canvas with transparency
        canvas.drawARGB(0, 0, 0, 0);

        // draw the rounded corners around the image rect. clockwise, starting
        // in upper left.
        canvas.drawCircle(upperLeft, upperLeft, upperLeft, paint);
        canvas.drawCircle(width - upperRight, upperRight, upperRight, paint);
        canvas.drawCircle(width - lowerRight, height - lowerRight, lowerRight,
                paint);
        canvas.drawCircle(lowerLeft, height - lowerLeft, lowerLeft, paint);

        // fill in all the gaps between circles. clockwise, starting at top.
        final RectF rectT = new RectF(upperLeft, 0, width - upperRight,
                height / 2);
        final RectF rectR = new RectF(width / 2, upperRight, width, height
                - lowerRight);
        final RectF rectB = new RectF(lowerLeft, height / 2,
                width - lowerRight, height);
        final RectF rectL = new RectF(0, upperLeft, width / 2, height
                - lowerLeft);

        canvas.drawRect(rectT, paint);
        canvas.drawRect(rectR, paint);
        canvas.drawRect(rectB, paint);
        canvas.drawRect(rectL, paint);

        // set up the rect for the image
        final Rect imageRect = new Rect(0, 0, width, height);

        // set up paint object such that it only paints on Color.WHITE
        paint.setXfermode(new AvoidXfermode(Color.WHITE, 255,
                AvoidXfermode.Mode.TARGET));

        // draw resized bitmap onto imageRect in canvas, using paint as
        // configured above
        canvas.drawBitmap(bitmap, imageRect, imageRect, paint);

        return output;
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {
        final Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Config.ARGB_8888);
        final Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = pixels;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }

    public static Bitmap getRoundedCornerBitmap(final Bitmap bitmap) {
        final Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Config.ARGB_8888);
        final Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = 12;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }

}
