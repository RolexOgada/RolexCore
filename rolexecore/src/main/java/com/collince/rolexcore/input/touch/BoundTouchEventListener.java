package com.collince.rolexcore.input.touch;

import com.collince.rolexcore.camera.Camera;



public interface BoundTouchEventListener {

    default Camera.CoordinateType getCoordinateType() {
        return Camera.CoordinateType.WORLD;
    }

    float getX();

    float getY();

    float getEndX();

    float getEndY();

    void onBoundTouchEvent(int type, float relativeTouchX, float relativeTouchY);

}
