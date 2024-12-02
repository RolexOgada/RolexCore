package com.collince.rolexcore.entity.modifier;

import com.collince.rolexcore.entity.shape.Shape;
import com.collince.rolexcore.util.modifier.tween.Tweener;



public class RotationModifier extends SingleValueShapeModifier {

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public RotationModifier(float startValue, float endValue, long duration) {
        super(startValue, endValue, duration);
    }

    public RotationModifier(float startValue, float endValue, long duration, long startDelay) {
        super(startValue, endValue, duration, startDelay);
    }

    public RotationModifier(float startValue, float endValue, long duration, Tweener tweener) {
        super(startValue, endValue, duration, tweener);
    }

    public RotationModifier(float startValue, float endValue, long duration, long startDelay, Tweener tweener) {
        super(startValue, endValue, duration, startDelay, tweener);
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    protected void onInitValue(Shape shape, float rotation) {
        shape.setRotation(rotation);
    }

    @Override
    protected void onUpdateValue(Shape shape, float rotation) {
        shape.setRotation(rotation);
    }

    @Override
    protected void onEndValue(Shape shape, float rotation) {
        shape.setRotation(rotation);
    }
    //========================================================

}
