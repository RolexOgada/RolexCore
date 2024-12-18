package com.collince.rolexcore.entity;

import android.graphics.Canvas;

import com.collince.rolexcore.core.Core;
import com.collince.rolexcore.camera.Camera;



public abstract class ScreenEntity extends Entity implements Drawable {

    protected int mLayer;
    private boolean mIsVisible = true;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    protected ScreenEntity(Core core) {
        super(core);
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public int getLayer() {
        return mLayer;
    }

    @Override
    public void setLayer(int layer) {
        mLayer = layer;
    }

    @Override
    public boolean isVisible() {
        return mIsVisible;
    }

    @Override
    public void setVisible(boolean visible) {
        mIsVisible = visible;
    }

    @Override
    public void draw(Canvas canvas, Camera camera) {
        onPreDraw(canvas, camera);
        onDraw(canvas, camera);
        onPostDraw(canvas, camera);
    }

    @Override
    public void reset() {
        super.reset();
        mIsVisible = true;
    }
    //========================================================

    //--------------------------------------------------------
    // Methods
    //--------------------------------------------------------
    protected void onPreDraw(Canvas canvas, Camera camera) {
    }

    protected abstract void onDraw(Canvas canvas, Camera camera);

    protected void onPostDraw(Canvas canvas, Camera camera) {
    }
    //========================================================

}
