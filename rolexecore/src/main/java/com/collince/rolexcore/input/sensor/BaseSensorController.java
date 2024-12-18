package com.collince.rolexcore.input.sensor;

import android.content.Context;
import android.hardware.SensorManager;



public abstract class BaseSensorController implements SensorController {

    protected final SensorManager mSensorManager;

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    protected BaseSensorController(Context context) {
        mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public void start() {
        registerListener();
    }

    @Override
    public void stop() {
        unregisterListener();
    }

    @Override
    public void pause() {
        unregisterListener();
    }

    @Override
    public void resume() {
        registerListener();
    }
    //========================================================

    //--------------------------------------------------------
    // Methods
    //--------------------------------------------------------
    protected abstract void registerListener();

    protected abstract void unregisterListener();
    //========================================================

}
