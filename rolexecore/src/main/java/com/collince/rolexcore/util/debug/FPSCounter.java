package com.collince.rolexcore.util.debug;

import android.graphics.Canvas;

import com.collince.rolexcore.camera.Camera;
import com.collince.rolexcore.core.Core;
import com.collince.rolexcore.entity.text.Text;



public class FPSCounter extends Text {

    private int mDrawCount;
    private long mTotalTime;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public FPSCounter(Core core, int width, int height) {
        this(core, 0, 0, width, height);
    }

    public FPSCounter(Core core, float x, float y, int width, int height) {
        super(core, x, y, width, height);
        setCoordinateType(Camera.CoordinateType.CAMERA);
        setPaint(core.getDebugger().getDebugTextPaint());
        setTextHorizontalAlign(TextHorizontalAlign.LEFT);
        setTextVerticalAlign(TextVerticalAlign.TOP);
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    protected void onStart() {
        mDrawCount = 0;
        mTotalTime = 0;
    }

    @Override
    protected void onUpdate(long elapsedMillis) {
        mTotalTime += elapsedMillis;
        if (mTotalTime >= 1000) {
            float fps = mDrawCount * 1000f / mTotalTime;
            setText("FPS: " + fps);
            mDrawCount = 0;
            mTotalTime = mTotalTime % 1000;
        }
    }

    @Override
    protected void onPostDraw(Canvas canvas, Camera camera) {
        mDrawCount++;
    }
    //========================================================

}
