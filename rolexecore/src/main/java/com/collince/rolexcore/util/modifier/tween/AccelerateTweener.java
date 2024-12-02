package com.collince.rolexcore.util.modifier.tween;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;



public class AccelerateTweener implements Tweener {

    private static final Interpolator INTERPOLATOR = new AccelerateInterpolator();

    private static AccelerateTweener INSTANCE;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    private AccelerateTweener() {
    }
    //========================================================

    //--------------------------------------------------------
    // Static methods
    //--------------------------------------------------------
    public static AccelerateTweener getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AccelerateTweener();
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
