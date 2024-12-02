package com.collince.rolexcore.entity.modifier;

import com.collince.rolexcore.entity.shape.Shape;
import com.collince.rolexcore.util.modifier.tween.Tweener;



public class AlphaModifier extends SingleValueShapeModifier {

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public AlphaModifier(long duration) {
        super(0, 0, duration);
    }

    public AlphaModifier(long duration, long startDelay) {
        super(0, 0, duration, startDelay);
    }

    public AlphaModifier(long duration, Tweener tweener) {
        super(0, 0, duration, tweener);
    }

    public AlphaModifier(long duration, long startDelay, Tweener tweener) {
        super(0, 0, duration, startDelay, tweener);
    }

    public AlphaModifier(float startValue, float endValue, long duration) {
        super(startValue, endValue, duration);
    }

    public AlphaModifier(float startValue, float endValue, long duration, long startDelay) {
        super(startValue, endValue, duration, startDelay);
    }

    public AlphaModifier(float startValue, float endValue, long duration, Tweener tweener) {
        super(startValue, endValue, duration, tweener);
    }

    public AlphaModifier(float startValue, float endValue, long duration, long startDelay, Tweener tweener) {
        super(startValue, endValue, duration, startDelay, tweener);
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    protected void onInitValue(Shape shape, float alpha) {
        shape.setAlpha((int) alpha);
    }

    @Override
    protected void onUpdateValue(Shape shape, float alpha) {
        shape.setAlpha((int) alpha);
    }

    @Override
    protected void onEndValue(Shape shape, float alpha) {
        shape.setAlpha((int) alpha);
    }
    //========================================================

}
