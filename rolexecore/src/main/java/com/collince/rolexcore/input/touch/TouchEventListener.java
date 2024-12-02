package com.collince.rolexcore.input.touch;

import com.collince.rolexcore.camera.Camera;



public interface TouchEventListener {

    default Camera.CoordinateType getCoordinateType() {
        return Camera.CoordinateType.WORLD;
    }

    void onTouchEvent(int type, float touchX, float touchY);

}
