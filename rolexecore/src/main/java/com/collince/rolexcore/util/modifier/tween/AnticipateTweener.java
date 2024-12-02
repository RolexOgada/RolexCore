package com.collince.rolexcore.util.modifier.tween;

import android.view.animation.AnticipateInterpolator;
import android.view.animation.Interpolator;



public class AnticipateTweener implements Tweener {

    private static final Interpolator INTERPOLATOR = new AnticipateInterpolator();

    private static AnticipateTweener INSTANCE;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    private AnticipateTweener() {
    }
    //========================================================

    //--------------------------------------------------------
    // Static methods
    //--------------------------------------------------------
    public static AnticipateTweener getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AnticipateTweener();
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
