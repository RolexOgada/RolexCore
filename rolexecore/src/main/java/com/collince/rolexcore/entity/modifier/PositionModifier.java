package com.collince.rolexcore.entity.modifier;

import com.collince.rolexcore.entity.shape.Shape;
import com.collince.rolexcore.util.modifier.tween.Tweener;



public class PositionModifier extends DoubleValueShapeModifier {

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public PositionModifier(long duration) {
        super(0, 0, 0, 0, duration);
    }

    public PositionModifier(long duration, long startDelay) {
        super(0, 0, 0, 0, duration, startDelay);
    }

    public PositionModifier(long duration, Tweener tweener) {
        super(0, 0, 0, 0, duration, tweener);
    }

    public PositionModifier(long duration, long startDelay, Tweener tweener) {
        super(0, 0, 0, 0, duration, startDelay, tweener);
    }

    public PositionModifier(float startValueX, float endValueX, float startValueY, float endValueY, long duration) {
        super(startValueX, endValueX, startValueY, endValueY, duration);
    }

    public PositionModifier(float startValueX, float endValueX, float startValueY, float endValueY, long duration, long startDelay) {
        super(startValueX, endValueX, startValueY, endValueY, duration, startDelay);
    }

    public PositionModifier(float startValueX, float endValueX, float startValueY, float endValueY, long duration, Tweener tweener) {
        super(startValueX, endValueX, startValueY, endValueY, duration, tweener);
    }

    public PositionModifier(float startValueX, float endValueX, float startValueY, float endValueY, long duration, long startDelay, Tweener tweener) {
        super(startValueX, endValueX, startValueY, endValueY, duration, startDelay, tweener);
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    protected void onInitValue(Shape shape, float positionX, float positionY) {
        shape.setX(positionX);
        shape.setY(positionY);
    }

    @Override
    protected void onUpdateValue(Shape shape, float positionX, float positionY) {
        shape.setX(positionX);
        shape.setY(positionY);
    }

    @Override
    protected void onEndValue(Shape shape, float positionX, float positionY) {
        shape.setX(positionX);
        shape.setY(positionY);
    }
    //========================================================

}
