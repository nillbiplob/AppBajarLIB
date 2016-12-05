package com.aapbd.appbajarlib.animation;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ViewFlipper;

public class SlideAnimation {

    private static final int speed = 300;

    public static Animation inFromBottomAnimation() {

        final Animation inFromBottom = new TranslateAnimation(

                Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromBottom.setDuration(speed);
        inFromBottom.setInterpolator(new AccelerateInterpolator());
        return inFromBottom;
    }

    public static void flipperBackAnimation(ViewFlipper flipper) {

        flipper.setInAnimation(SlideAnimation.inFromLeftAnimation());
        flipper.setOutAnimation(SlideAnimation.outToRightAnimation());

    }

    public static void flipperNextAnimation(ViewFlipper flipper) {

        flipper.setInAnimation(SlideAnimation.inFromRightAnimation());
        flipper.setOutAnimation(SlideAnimation.outToLeftAnimation());

    }

    public static Animation inFromLeftAnimation() {
        final Animation inFromLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromLeft.setDuration(speed);
        inFromLeft.setInterpolator(new AccelerateInterpolator());
        return inFromLeft;

    }

    public static Animation inFromRightAnimation() {

        final Animation inFromRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromRight.setDuration(speed);
        inFromRight.setInterpolator(new AccelerateInterpolator());
        return inFromRight;

    }

    public static Animation inFromTopAnimation() {
        final Animation inFromTop = new TranslateAnimation(

                Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, -1.0f);
        inFromTop.setDuration(speed);
        inFromTop.setInterpolator(new AccelerateInterpolator());
        return inFromTop;

    }

    public static Animation outToBottomAnimation() {
        final Animation outToBottom = new TranslateAnimation(

                Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        outToBottom.setDuration(speed);
        outToBottom.setInterpolator(new AccelerateInterpolator());
        return outToBottom;
    }

    public static Animation outToLeftAnimation() {
        final Animation outtoLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        outtoLeft.setDuration(speed);
        outtoLeft.setInterpolator(new AccelerateInterpolator());
        return outtoLeft;

    }

    public static Animation outToRightAnimation() {
        final Animation outtoRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        outtoRight.setDuration(speed);
        outtoRight.setInterpolator(new AccelerateInterpolator());
        return outtoRight;
    }

    public static Animation outToTopAnimation() {
        final Animation outToTop = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, -1.0f);
        outToTop.setDuration(speed);
        outToTop.setInterpolator(new AccelerateInterpolator());
        return outToTop;

    }

    public static AnimationSet smallToBig() {

        final AnimationSet rootSet = new AnimationSet(true);
        rootSet.setInterpolator(new BounceInterpolator());

        // Create and add first child, a motion animation.
        final TranslateAnimation trans1 = new TranslateAnimation(0, 0, -400, 0);
        trans1.setStartOffset(0);
        trans1.setDuration(800);
        trans1.setFillAfter(true);

        rootSet.addAnimation(trans1);

        final ScaleAnimation scale = new ScaleAnimation(0, 1, 0,
                1, // From x, to x, from y, to y
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);

        scale.setDuration(800);
        scale.setFillAfter(true);

        // Add rotate and size animations to a new set,
        // then add the set to the root set.
        final AnimationSet childSet = new AnimationSet(true);

        // childSet.addAnimation(rotate);
        childSet.addAnimation(scale);

        childSet.setInterpolator(new BounceInterpolator());
        rootSet.addAnimation(childSet);
        return rootSet;
    }

}
