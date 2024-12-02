package com.collince.rolexcore.entity.shape.primitive;

import android.graphics.Canvas;
import android.graphics.PorterDuff;

import com.collince.rolexcore.camera.Camera;
import com.collince.rolexcore.core.Core;
import com.collince.rolexcore.entity.ScreenEntity;



public class Plane extends ScreenEntity {

    protected int mColor;
    protected PorterDuff.Mode mColorMode = PorterDuff.Mode.SRC_ATOP;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public Plane(Core core, int color) {
        super(core);
        mColor = color;
    }
    //========================================================

    //--------------------------------------------------------
    // Getter and Setter
    //--------------------------------------------------------
    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        mColor = color;
    }

    public PorterDuff.Mode getColorMode() {
        return mColorMode;
    }

    public void setColorMode(PorterDuff.Mode mode) {
        mColorMode = mode;
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public boolean isCulling(Canvas canvas, Camera camera) {
        // Plane is always on screen
        return false;
    }

    @Override
    public void onDraw(Canvas canvas, Camera camera) {
        canvas.drawColor(mColor, mColorMode);
    }
    //========================================================

}
