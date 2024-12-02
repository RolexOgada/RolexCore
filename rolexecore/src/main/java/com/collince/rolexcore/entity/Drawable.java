package com.collince.rolexcore.entity;

import android.graphics.Canvas;

import com.collince.rolexcore.camera.Camera;



public interface Drawable {

    int getLayer();

    void setLayer(int layer);

    boolean isVisible();

    void setVisible(boolean visible);

    boolean isCulling(Canvas canvas, Camera camera);

    void draw(Canvas canvas, Camera camera);

}
