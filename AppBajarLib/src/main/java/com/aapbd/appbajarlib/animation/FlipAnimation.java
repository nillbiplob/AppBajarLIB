package com.aapbd.appbajarlib.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

@SuppressLint("NewApi")
public class FlipAnimation {

    public static void flipIt(final View visible, final View invisible) {
        /*
		 * flip part
		 */
        final Interpolator accelerator = new AccelerateInterpolator();
        final Interpolator decelerator = new DecelerateInterpolator();

        final ObjectAnimator visToInvis = ObjectAnimator.ofFloat(visible,
                "rotationY", 0f, 90f);
        visToInvis.setDuration(500);
        visToInvis.setInterpolator(accelerator);
        final ObjectAnimator invisToVis = ObjectAnimator.ofFloat(invisible,
                "rotationY", -90f, 0f);
        invisToVis.setDuration(500);
        invisToVis.setInterpolator(decelerator);
        visToInvis.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator anim) {
                visible.setVisibility(View.GONE);
                invisToVis.start();
                invisible.setVisibility(View.VISIBLE);
            }
        });
        visToInvis.start();
    }

}
