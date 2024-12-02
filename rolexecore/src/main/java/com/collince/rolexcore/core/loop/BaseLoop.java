package com.collince.rolexcore.core.loop;



public abstract class BaseLoop extends Thread implements Loop {

    private volatile boolean mIsRunning;
    private volatile boolean mIsPause;

    private final Object mLock = new Object();

    //--------------------------------------------------------
    // Constructors
    //--------------------------------------------------------
    public BaseLoop() {
    }
    //========================================================

    //--------------------------------------------------------
    // Overriding methods
    //--------------------------------------------------------
    @Override
    public void run() {
        long elapsedTimeMillis;
        long currentTimeMillis;
        long previousTimeMillis = System.currentTimeMillis();
        while (mIsRunning) {
            currentTimeMillis = System.currentTimeMillis();
            elapsedTimeMillis = currentTimeMillis - previousTimeMillis;
            if (mIsPause) {
                while (mIsPause) {
                    try {
                        synchronized (mLock) {
                            mLock.wait();
                        }
                    } catch (InterruptedException e) {
                        // We stay on the loop
                    }
                }
                currentTimeMillis = System.currentTimeMillis();
            }
            onUpdateLoop(elapsedTimeMillis);
            previousTimeMillis = currentTimeMillis;
        }
    }

    @Override
    public void startLoop() {
        mIsRunning = true;
        mIsPause = false;
        start();
    }

    @Override
    public void stopLoop() {
        mIsRunning = false;
        resumeLoop();
    }

    @Override
    public void pauseLoop() {
        mIsPause = true;
    }

    @Override
    public void resumeLoop() {
        if (mIsPause) {
            mIsPause = false;
            synchronized (mLock) {
                mLock.notify();
            }
        }
    }

    @Override
    public boolean isRunning() {
        return mIsRunning;
    }

    @Override
    public boolean isPaused() {
        return mIsPause;
    }
    //========================================================

    //--------------------------------------------------------
    // Methods
    //--------------------------------------------------------
    protected abstract void onUpdateLoop(long elapsedMillis);
    //========================================================

}
