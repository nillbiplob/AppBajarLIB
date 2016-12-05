package com.aapbd.appbajarlib.animation;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.GridView;
import android.widget.ListView;

import com.aapbd.appbajarlib.R;



public class WaveAnimation {

    public static void startWave(Context c, ListView list) {

        final Animation animation = AnimationUtils.loadAnimation(c,
                R.anim.wave_scale);
        final LayoutAnimationController controller = new LayoutAnimationController(
                animation, 0.5f);
        list.setLayoutAnimation(controller);

    }

//    public static void startWave(Context c, RecyclerView recyclerView) {
//
//        final Animation animation = AnimationUtils.loadAnimation(c,
//                R.anim.wave_scale);
//        final LayoutAnimationController controller = new LayoutAnimationController(
//                animation, 0.5f);
//        recyclerView.setLayoutAnimation(controller);
//
//    }

    public static void startWave(Context c, GridView gridView) {

        final Animation animation = AnimationUtils.loadAnimation(c,
                R.anim.wave_scale);
        final LayoutAnimationController controller = new LayoutAnimationController(
                animation, 0.5f);
        gridView.setLayoutAnimation(controller);

    }

}
