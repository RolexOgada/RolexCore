package com.collince.rolexcore.core;

import android.graphics.Canvas;

import com.collince.rolexcore.camera.Camera;
import com.collince.rolexcore.entity.Updatable;



public interface CoreListener {

    default void onCoreUpdate(long elapsedMillis) {
    }

    default void onCoreDraw(Canvas canvas, Camera camera) {
    }

    default void onAddToCore(Updatable updatable) {
    }

    default void onRemoveFromCore(Updatable updatable) {
    }

}
