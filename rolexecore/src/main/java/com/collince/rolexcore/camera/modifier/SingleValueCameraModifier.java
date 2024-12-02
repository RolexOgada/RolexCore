package com.collince.rolexcore.camera.modifier;

import com.collince.rolexcore.camera.Camera;
import com.collince.rolexcore.util.modifier.SingleValueModifier;
import com.collince.rolexcore.util.modifier.tween.LinearTweener;
import com.collince.rolexcore.util.modifier.tween.Tweener;

public abstract class SingleValueCameraModifier extends SingleValueModifier<Camera> {

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    protected SingleValueCameraModifier(float startValue, float endValue, long duration) {
        super(startValue, endValue, duration, 0, LinearTweener.getInstance());
    }

    protected SingleValueCameraModifier(float startValue, float endValue, long duration, long startDelay) {
        super(startValue, endValue, duration, startDelay, LinearTweener.getInstance());
    }

    protected SingleValueCameraModifier(float startValue, float endValue, long duration, Tweener tweener) {
        super(startValue, endValue, duration, 0, tweener);
    }

    protected SingleValueCameraModifier(float startValue, float endValue, long duration, long startDelay, Tweener tweener) {
        super(startValue, endValue, duration, startDelay, tweener);
    }
    //========================================================

}
