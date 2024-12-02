package com.collince.rolexcore.entity.shape.primitive;

import android.graphics.Canvas;

import com.collince.rolexcore.camera.Camera;
import com.collince.rolexcore.core.Core;
import com.collince.rolexcore.entity.shape.RectangleShapeEntity;



public class Circle extends RectangleShapeEntity {

    private int mRadius;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public Circle(Core core, int radius) {
        this(core, 0, 0, radius);
    }

    public Circle(Core core, float x, float y, int radius) {
        super(core, x, y, radius * 2, radius * 2);
        mRadius = radius;
    }
    //========================================================

    //--------------------------------------------------------
    // Getter and Setter
    //--------------------------------------------------------
    public int getRadius() {
        return mRadius;
    }

    public void setRadius(int radius) {
        super.setWidth(radius * 2);
        super.setHeight(radius * 2);
        mRadius = radius;
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public void setWidth(int width) {
        setRadius(width / 2);
    }

    @Override
    public void setHeight(int height) {
        setRadius(height / 2);
    }

    @Override
    public boolean isCulling(Canvas canvas, Camera camera) {
        // Check is all four edges out of bound
        boolean isCulling = camera.getWorldToScreenX(mX, mCoordinateType) > canvas.getWidth()
                || camera.getWorldToScreenY(mY, mCoordinateType) > canvas.getHeight()
                || camera.getWorldToScreenX(getEndX(), mCoordinateType) < 0
                || camera.getWorldToScreenY(getEndY(), mCoordinateType) < 0;

        // Print debug info
        if (!isCulling && mCore.isDebugMode() && mCore.getDebugger().isDebugCulling()) {
            canvas.drawRect(camera.getWorldToScreenX(mX, mCoordinateType),
                    camera.getWorldToScreenY(mY, mCoordinateType),
                    camera.getWorldToScreenX(getEndX(), mCoordinateType),
                    camera.getWorldToScreenY(getEndY(), mCoordinateType),
                    mCore.getDebugger().getDebugPaint());
        }

        return isCulling;
    }

    @Override
    protected void onDrawCanvas(Canvas canvas) {
        canvas.drawCircle(mRadius, mRadius, mRadius, mPaint);
    }
    //========================================================

}
