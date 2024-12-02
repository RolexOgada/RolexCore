package com.collince.rolexcore.entity.shape.primitive;

import android.graphics.Canvas;

import com.collince.rolexcore.camera.Camera;
import com.collince.rolexcore.core.Core;
import com.collince.rolexcore.entity.shape.ShapeEntity;



public class Point extends ShapeEntity {

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public Point(Core core, float x, float y) {
        super(core, x, y);
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public boolean isCulling(Canvas canvas, Camera camera) {
        return camera.getWorldToScreenX(mX, mCoordinateType) > canvas.getWidth()
                || camera.getWorldToScreenY(mY, mCoordinateType) > canvas.getHeight()
                || camera.getWorldToScreenX(mX, mCoordinateType) < 0
                || camera.getWorldToScreenY(mY, mCoordinateType) < 0;
    }

    @Override
    protected void onDrawCanvas(Canvas canvas) {
        canvas.drawPoint(0, 0, mPaint);
    }
    //========================================================

}
