package com.collince.rolexcore.util.modifier.tween;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;



public class LinearTweener implements Tweener {

    private static final Interpolator INTERPOLATOR = new LinearInterpolator();

    private static LinearTweener INSTANCE;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    private LinearTweener() {
    }
    //========================================================

    //--------------------------------------------------------
    // Static methods
    //--------------------------------------------------------
    public static LinearTweener getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new LinearTweener();
        }

        return INSTANCE;
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public float getTweenValue(float percentage) {
        return INTERPOLATOR.getInterpolation(percentage);
    }
    //========================================================

}
