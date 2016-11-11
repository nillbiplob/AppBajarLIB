package com.aapbd.appbajarlib.view;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Method;

public class TypefaceSetter {
    private Activity mActivity;
    private View mView;
    private Typeface mDefaultTypeface;
    private final AssetManager mAssetManager;

    public TypefaceSetter(Activity activity, String fontSource) {
        mActivity = activity;
        mAssetManager = mActivity.getAssets();
        createDefaultFontSource(fontSource);
        mView = mActivity.findViewById(android.R.id.content);
    }

    public TypefaceSetter(View view, AssetManager assetManager,
                          String fontSource) {
        mView = view;
        mAssetManager = assetManager;
        createDefaultFontSource(fontSource);
    }

    public TypefaceSetter(AssetManager assetManager, String fontSource) {
        mAssetManager = assetManager;
        createDefaultFontSource(fontSource);
    }

    public void createDefaultFontSource(String fontSource) {
        mDefaultTypeface = Typeface.createFromAsset(mAssetManager, fontSource);
    }

    public void setTypeface() {
        if (mView != null) {
            traverseView(mView);
        }
    }

    public void setTypeface(View view) {
        traverseView(view);
    }

    private void setTypeface(View tv, Typeface typeface) {
        Method m = null;
        try {
            m = tv.getClass().getMethod("setTypeface", Typeface.class);
            if (m != null) {
                m.invoke(tv, typeface);
            }
        } catch (final Exception e) {
        }
    }

    private void traverseView(View view) {
        if (view instanceof ViewGroup) {
            final ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                final View v = viewGroup.getChildAt(i);
                setTypeface(v, mDefaultTypeface);
                if (v instanceof ViewGroup) {
                    traverseView(v);
                }
            }
        } else {
            setTypeface(view, mDefaultTypeface);
        }
    }
}
