package com.collince.rolexcore.entity.modifier;

import com.collince.rolexcore.entity.shape.Shape;
import com.collince.rolexcore.util.modifier.tween.Tweener;



public class PositionXModifier extends SingleValueShapeModifier {

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public PositionXModifier(long duration) {
        super(0, 0, duration);
    }

    public PositionXModifier(long duration, long startDelay) {
        super(0, 0, duration, startDelay);
    }

    public PositionXModifier(long duration, Tweener tweener) {
        super(0, 0, duration, tweener);
    }

    public PositionXModifier(long duration, long startDelay, Tweener tweener) {
        super(0, 0, duration, startDelay, tweener);
    }

    public PositionXModifier(float startValue, float endValue, long duration) {
        super(startValue, endValue, duration);
    }

    public PositionXModifier(float startValue, float endValue, long duration, long startDelay) {
        super(startValue, endValue, duration, startDelay);
    }

    public PositionXModifier(float startValue, float endValue, long duration, Tweener tweener) {
        super(startValue, endValue, duration, tweener);
    }

    public PositionXModifier(float startValue, float endValue, long duration, long startDelay, Tweener tweener) {
        super(startValue, endValue, duration, startDelay, tweener);
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    protected void onInitValue(Shape shape, float positionX) {
        shape.setX(positionX);
    }

    @Override
    protected void onUpdateValue(Shape shape, float positionX) {
        shape.setX(positionX);
    }

    @Override
    protected void onEndValue(Shape shape, float positionX) {
        shape.setX(positionX);
    }
    //========================================================

}
