package com.collince.rolexcore.util.debug;

import com.collince.rolexcore.camera.Camera;
import com.collince.rolexcore.core.Core;
import com.collince.rolexcore.entity.text.Text;



public class UPSCounter extends Text {

    private int mUpdateCount;
    private long mTotalTime;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public UPSCounter(Core core, int width, int height) {
        this(core, 0, 0, width, height);
    }

    public UPSCounter(Core core, float x, float y, int width, int height) {
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
        mUpdateCount = 0;
        mTotalTime = 0;
    }

    @Override
    protected void onUpdate(long elapsedMillis) {
        mUpdateCount++;
        mTotalTime += elapsedMillis;
        if (mTotalTime >= 1000) {
            float ups = mUpdateCount * 1000f / mTotalTime;
            setText("UPS: " + ups);
            mUpdateCount = 0;
            mTotalTime = mTotalTime % 1000;
        }
    }
    //========================================================

}
