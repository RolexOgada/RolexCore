package com.collince.rolexcore.input.touch;

import android.view.View;

import com.collince.rolexcore.util.pool.Pool;
import com.collince.rolexcore.util.pool.SafeFixedObjectPool;

import java.util.ArrayList;
import java.util.List;



public abstract class BaseTouchController implements TouchController {

    protected boolean mIsEnable = false;

    protected final Pool<TouchEvent> mTouchEventPool = new SafeFixedObjectPool<>(new Pool.PoolObjectFactory<TouchEvent>() {
        @Override
        public TouchEvent createObject() {
            return new TouchEvent();
        }
    }, 100);
    protected final List<TouchEvent> mTouchEvents = new ArrayList<>();
    protected final List<TouchEvent> mTouchEventsBuffer = new ArrayList<>();

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    protected BaseTouchController(View view) {
        view.setOnTouchListener(this);
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public void start() {
        mIsEnable = true;
    }

    @Override
    public void stop() {
        mIsEnable = false;
        mTouchEventPool.release();
        mTouchEvents.clear();
        mTouchEventsBuffer.clear();
    }

    @Override
    public void pause() {
        mIsEnable = false;
    }

    @Override
    public void resume() {
        mIsEnable = true;
    }
    //========================================================

}
