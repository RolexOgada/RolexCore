package com.collince.rolexcore.entity.shape.primitive;

import android.graphics.Canvas;

import com.collince.rolexcore.core.Core;
import com.collince.rolexcore.entity.shape.RectangleShapeEntity;



public class Oval extends RectangleShapeEntity {

    private int mRadiusX;
    private int mRadiusY;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public Oval(Core core, int radiusX, int radiusY) {
        this(core, 0, 0, radiusX, radiusY);
    }

    public Oval(Core core, float x, float y, int radiusX, int radiusY) {
        super(core, x, y, radiusX * 2, radiusY * 2);
        mRadiusX = radiusX;
        mRadiusY = radiusY;
    }
    //========================================================

    //--------------------------------------------------------
    // Getter and Setter
    //--------------------------------------------------------
    public int getRadiusX() {
        return mRadiusX;
    }

    public void setRadiusX(int radiusX) {
        super.setWidth(radiusX * 2);
        mRadiusX = radiusX;
    }

    public int getRadiusY() {
        return mRadiusY;
    }

    public void setRadiusY(int radiusY) {
        super.setHeight(radiusY * 2);
        mRadiusY = radiusY;
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public void setWidth(int width) {
        setRadiusX(width / 2);
    }

    @Override
    public void setHeight(int height) {
        setRadiusY(height / 2);
    }

    @Override
    protected void onDrawCanvas(Canvas canvas) {
        canvas.drawOval(0, 0, getWidth(), getHeight(), mPaint);
    }
    //========================================================

}
