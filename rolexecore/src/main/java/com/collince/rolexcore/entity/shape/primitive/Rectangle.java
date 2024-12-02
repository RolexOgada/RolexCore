package com.collince.rolexcore.entity.shape.primitive;

import android.graphics.Canvas;

import com.collince.rolexcore.core.Core;
import com.collince.rolexcore.entity.shape.RectangleShapeEntity;



public class Rectangle extends RectangleShapeEntity {

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public Rectangle(Core core, int width, int height) {
        this(core, 0, 0, width, height);
    }

    public Rectangle(Core core, float x, float y, int width, int height) {
        super(core, x, y, width, height);
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    protected void onDrawCanvas(Canvas canvas) {
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
    }
    //========================================================

}
