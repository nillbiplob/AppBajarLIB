package com.aapbd.appbajarlib.animation;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

public class BlinkAnimation {

    public static void blinkIt(Context con, View v) {

        final Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(50); // You can manage the time of the blink with this
        // parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        v.startAnimation(anim);

    }

    public static void blinkIt(Context con, View v, int duration, int offset) {

        final Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(duration); // You can manage the time of the blink with
        // this parameter
        anim.setStartOffset(offset);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        v.startAnimation(anim);

    }

}
